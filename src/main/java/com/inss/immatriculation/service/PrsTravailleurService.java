package com.inss.immatriculation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inss.immatriculation.pojo.PrsRelationId;
import com.inss.immatriculation.pojo.PrsTravailleur;
import com.inss.immatriculation.pojo.PrsTrvService;
import com.inss.immatriculation.pojo.PrsTrvServiceId;
import com.inss.immatriculation.repository.PrsRelationRepository;
import com.inss.immatriculation.repository.PrsTravailleurRepository;
import com.inss.immatriculation.repository.PrsTrvServiceRepository;

@Service
public class PrsTravailleurService {

    private final PrsTravailleurRepository travailleurRepo;
    private final JdbcTemplate jdbcTemplate;

    public PrsTravailleurService(PrsTravailleurRepository travailleurRepo,
                                 PrsRelationRepository relationRepo,
                                 PrsTrvServiceRepository serviceRepo,
                                 JdbcTemplate jdbcTemplate) {
        this.travailleurRepo = travailleurRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    // --- CRUD DE BASE ---

    public List<PrsTravailleur> findAll() {
        return travailleurRepo.findAll();
    }

    public Optional<PrsTravailleur> findById(String immatriculation) {
        return travailleurRepo.findById(immatriculation);
    }

    // --- SAVE (Création avec logique métier) ---
    @Transactional
    public PrsTravailleur save(PrsTravailleur travailleur) {
        // 1. RÈGLE MÉTIER : L'affiliation est obligatoire
        if (travailleur.getServices() != null && !travailleur.getServices().isEmpty()) {
            for (PrsTrvService service : travailleur.getServices()) {
                if (service.getTserAffiliation() == null) {
                    throw new RuntimeException("L'affiliation doit être renseignée pour le service.");
                }
            }
        } else {
            throw new RuntimeException("Le travailleur doit être rattaché à un service (avec affiliation).");
        }

        // 2. GÉNÉRATION DE L'IMMATRICULATION (Si nouvelle création)
        if (travailleur.getTrvImmatriculation() == null || travailleur.getTrvImmatriculation().isEmpty()) {
            // On utilise une séquence PostgreSQL
            String nouvelleImmat = jdbcTemplate.queryForObject("SELECT 'TRV' || nextval('seq_prs_trv_immat')", String.class);
            travailleur.setTrvImmatriculation(nouvelleImmat);
            
            // Vérification d'unicité (sécurité)
            if (travailleurRepo.existsById(nouvelleImmat)) {
                throw new RuntimeException("PRS-000003: Numéro Immatriculation déjà existant.");
            }
            
            travailleur.setTrvDtCreee(LocalDateTime.now());
            travailleur.setTrvUtilCree(currentUser());
        } else {
            travailleur.setTrvDtModifiee(LocalDateTime.now());
            travailleur.setTrvUtilModifie(currentUser());
        }

        // 3. LIAISON DES ENFANTS (Relations et Services)
        if (travailleur.getRelations() != null) {
            travailleur.getRelations().forEach(r -> {
                // On assigne l'immatriculation du parent à la clé composite de l'enfant
                if (r.getId() == null) r.setId(new PrsRelationId());
                r.getId().setRelTrvImmatriculation(travailleur.getTrvImmatriculation());
                r.setTravailleur(travailleur);
                
                // Audit de l'enfant
                if (r.getRelDtCreee() == null) r.setRelDtCreee(LocalDateTime.now());
                if (r.getRelUtilCree() == null) r.setRelUtilCree(currentUser());
            });
        }

        if (travailleur.getServices() != null) {
            travailleur.getServices().forEach(s -> {
                if (s.getId() == null) s.setId(new PrsTrvServiceId());
                s.getId().setTserTrvImmatriculation(travailleur.getTrvImmatriculation());
                s.setTravailleur(travailleur);
                
                // Audit de l'enfant
                if (s.getTserDtCreee() == null) s.setTserDtCreee(LocalDateTime.now());
                if (s.getTserUtilCree() == null) s.setTserUtilCree(currentUser());
            });
        }

        // 4. Sauvegarde en cascade (Hibernate gérera les inserts dans les bonnes tables)
        return travailleurRepo.save(travailleur);
    }

    // --- DELETE (Avec vérification) ---
    @Transactional
    public void delete(String immatriculation) {
        PrsTravailleur travailleur = travailleurRepo.findById(immatriculation)
                .orElseThrow(() -> new RuntimeException("Travailleur introuvable"));

        // RÈGLE MÉTIER (On Check Delete Master)
        if (travailleur.getRelations() != null && !travailleur.getRelations().isEmpty()) {
            throw new RuntimeException("Suppression impossible : des relations (ayants droit) existent.");
        }
        if (travailleur.getServices() != null && !travailleur.getServices().isEmpty()) {
            throw new RuntimeException("Suppression impossible : des services sont liés à ce travailleur.");
        }

        travailleurRepo.deleteById(immatriculation);
    }

    // Méthode utilitaire pour simuler l'utilisateur
    private String currentUser() {
        return "mugisha"; // À remplacer par Spring Security plus tard
    }
}