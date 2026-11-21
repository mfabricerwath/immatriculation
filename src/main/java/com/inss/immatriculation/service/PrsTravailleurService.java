package com.inss.immatriculation.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inss.immatriculation.pojo.PrsRelation;
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
    private final PrsRelationRepository relationRepo;
    private final PrsTrvServiceRepository serviceRepo;
    private final JdbcTemplate jdbcTemplate;

    // Constructeur corrigé : plus de "= null", et sans le Mapper
    public PrsTravailleurService(PrsTravailleurRepository travailleurRepo,
                                 PrsRelationRepository relationRepo,
                                 PrsTrvServiceRepository serviceRepo,
                                 JdbcTemplate jdbcTemplate) {
        this.travailleurRepo = travailleurRepo;
        this.relationRepo = relationRepo;
        this.serviceRepo = serviceRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    // --- CRUD DE BASE ---

    public List<PrsTravailleur> findAll() {
        return travailleurRepo.findAll();
    }

    public Optional<PrsTravailleur> findById(String immatriculation) {
        return travailleurRepo.findById(immatriculation);
    }

    @Transactional(readOnly = true)
    public Optional<PrsTravailleur> findEntityById(String immatriculation) {
        Optional<PrsTravailleur> opt = travailleurRepo.findById(immatriculation);
        opt.ifPresent(t -> {
            Hibernate.initialize(t.getRelations());
            Hibernate.initialize(t.getServices());
        });
        return opt;
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

        // 2. GÉNÉRATION DE L'IMMATRICULATION
        if (travailleur.getTrvImmatriculation() == null || travailleur.getTrvImmatriculation().isEmpty()) {
            String nouvelleImmat = jdbcTemplate.queryForObject("SELECT nextval('seq_prs_trv_immat')::text", String.class);
            travailleur.setTrvImmatriculation(nouvelleImmat);
            
            if (travailleurRepo.existsById(nouvelleImmat)) {
                throw new RuntimeException("PRS-000003: Numéro Immatriculation déjà existant.");
            }
            
            travailleur.setTrvDtCreee(LocalDateTime.now());
            travailleur.setTrvUtilCree(currentUser());
        } else {
            travailleur.setTrvDtModifiee(LocalDateTime.now());
            travailleur.setTrvUtilModifie(currentUser());
        }

        // 3. LIAISON DES ENFANTS
        if (travailleur.getRelations() != null) {
            travailleur.getRelations().forEach(r -> {
                if (r.getId() == null) r.setId(new PrsRelationId());
                r.getId().setRelTrvImmatriculation(travailleur.getTrvImmatriculation());
                r.setTravailleur(travailleur);
                
                if (r.getRelDtCreee() == null) r.setRelDtCreee(LocalDateTime.now());
                if (r.getRelUtilCree() == null) r.setRelUtilCree(currentUser());
            });
        }

        if (travailleur.getServices() != null) {
            travailleur.getServices().forEach(s -> {
                if (s.getId() == null) s.setId(new PrsTrvServiceId());
                s.getId().setTserTrvImmatriculation(travailleur.getTrvImmatriculation());
                s.setTravailleur(travailleur);
                
                if (s.getTserDtCreee() == null) s.setTserDtCreee(LocalDateTime.now());
                if (s.getTserUtilCree() == null) s.setTserUtilCree(currentUser());
            });
        }

        return travailleurRepo.save(travailleur);
    }

    // --- UPDATE (Mise à jour sécurisée) ---
    @Transactional
    public PrsTravailleur update(String immatriculation, PrsTravailleur travailleurModifie) {
        
        PrsTravailleur travailleurExistant = travailleurRepo.findById(immatriculation)
            .orElseThrow(() -> new RuntimeException("Travailleur introuvable avec l'immatriculation : " + immatriculation));

        // 1. MISE À JOUR DES CHAMPS SIMPLES
        travailleurExistant.setTrvNom(travailleurModifie.getTrvNom());
        travailleurExistant.setTrvPrenom(travailleurModifie.getTrvPrenom());
        travailleurExistant.setTrvNomJeunefille(travailleurModifie.getTrvNomJeunefille());
        travailleurExistant.setTrvSexe(travailleurModifie.getTrvSexe());
        travailleurExistant.setTrvDtNaissance(travailleurModifie.getTrvDtNaissance());
        travailleurExistant.setTrvAnNaissance(travailleurModifie.getTrvAnNaissance());
        travailleurExistant.setTrvLieuNaissance(travailleurModifie.getTrvLieuNaissance());
        travailleurExistant.setTrvNationalite(travailleurModifie.getTrvNationalite());
        travailleurExistant.setTrvEtatCivil(travailleurModifie.getTrvEtatCivil());
        travailleurExistant.setTrvNomPere(travailleurModifie.getTrvNomPere());
        travailleurExistant.setTrvNomMere(travailleurModifie.getTrvNomMere());
        travailleurExistant.setTrvCni(travailleurModifie.getTrvCni());
        travailleurExistant.setTrvPhoto(travailleurModifie.getTrvPhoto());

        travailleurExistant.setTrvRue(travailleurModifie.getTrvRue());
        travailleurExistant.setTrvLocalite(travailleurModifie.getTrvLocalite());
        travailleurExistant.setTrvVille(travailleurModifie.getTrvVille());
        travailleurExistant.setTrvProvince(travailleurModifie.getTrvProvince());
        travailleurExistant.setTrvCommune(travailleurModifie.getTrvCommune());
        travailleurExistant.setTrvColline(travailleurModifie.getTrvColline());
        travailleurExistant.setTrvPays(travailleurModifie.getTrvPays());
        travailleurExistant.setTrvCodePostal(travailleurModifie.getTrvCodePostal());
        travailleurExistant.setTrvTelephone(travailleurModifie.getTrvTelephone());
        travailleurExistant.setTrvEmail(travailleurModifie.getTrvEmail());
        travailleurExistant.setTrvFax(travailleurModifie.getTrvFax());

        travailleurExistant.setTrvRueP(travailleurModifie.getTrvRueP());
        travailleurExistant.setTrvLocaliteP(travailleurModifie.getTrvLocaliteP());
        travailleurExistant.setTrvVilleP(travailleurModifie.getTrvVilleP());
        travailleurExistant.setTrvPaysP(travailleurModifie.getTrvPaysP());
        travailleurExistant.setTrvCodePostalP(travailleurModifie.getTrvCodePostalP());
        travailleurExistant.setTrvTelephoneP(travailleurModifie.getTrvTelephoneP());
        travailleurExistant.setTrvEmailP(travailleurModifie.getTrvEmailP());
        travailleurExistant.setTrvFaxP(travailleurModifie.getTrvFaxP());

        travailleurExistant.setTrvCatProf(travailleurModifie.getTrvCatProf());
        travailleurExistant.setTrvNiveauFormation(travailleurModifie.getTrvNiveauFormation());
        travailleurExistant.setTrvSalaire(travailleurModifie.getTrvSalaire());
        travailleurExistant.setTrvRepLegal(travailleurModifie.getTrvRepLegal());
        travailleurExistant.setTrvLivret(travailleurModifie.getTrvLivret());
        travailleurExistant.setTrvEtat(travailleurModifie.getTrvEtat());
        travailleurExistant.setTrvDtDemande(travailleurModifie.getTrvDtDemande());
        travailleurExistant.setTrvDtReception(travailleurModifie.getTrvDtReception());
        travailleurExistant.setTrvDtAssurance(travailleurModifie.getTrvDtAssurance());

        travailleurExistant.setTrvDtModifiee(LocalDateTime.now());
        travailleurExistant.setTrvUtilModifie(currentUser());

        // 2. GESTION DES RELATIONS
     // ==========================================
     // 3. GESTION SÉCURISÉE DES RELATIONS (Clé composite)
     // ==========================================
     if (travailleurExistant.getRelations() != null && !travailleurExistant.getRelations().isEmpty()) {
         // On vide D'ABORD la liste du parent pour éviter le conflit
         travailleurExistant.getRelations().clear();
         
         // Ensuite on supprime physiquement les anciennes en base
         relationRepo.deleteAllByTravailleurImmatriculation(immatriculation); 
         // Note : Si la méthode deleteAllBy... n'existe pas, on peut utiliser :
         // List<PrsRelation> anciennes = relationRepo.findByTravailleur(immatriculation);
         // relationRepo.deleteAll(anciennes);
     }

     // On ajoute les nouvelles relations
     if (travailleurModifie.getRelations() != null) {
         for (PrsRelation rel : travailleurModifie.getRelations()) {
             if (rel.getId() == null) rel.setId(new PrsRelationId());
             
             if (rel.getId().getRelCode() == null || rel.getId().getRelCode().trim().isEmpty()) {
                 // On raccourcit le code pour éviter l'erreur 22001 (String too long)
                 long timestampCourt = System.currentTimeMillis() % 1000000;
                 rel.getId().setRelCode("REL" + timestampCourt);
             }
             
             rel.getId().setRelTrvImmatriculation(immatriculation);
             rel.setTravailleur(travailleurExistant);
             
             if (rel.getRelDtCreee() == null) rel.setRelDtCreee(LocalDateTime.now());
             if (rel.getRelUtilCree() == null) rel.setRelUtilCree(currentUser());
             
             travailleurExistant.getRelations().add(rel);
         }
     }

     // ==========================================
     // 4. GESTION SÉCURISÉE DES SERVICES (Clé composite)
     // ==========================================
     if (travailleurExistant.getServices() != null && !travailleurExistant.getServices().isEmpty()) {
         // Même chose : on vide d'abord la liste
         travailleurExistant.getServices().clear();
         
         // Puis on supprime en base (remplacez par la bonne méthode de votre repository)
         serviceRepo.deleteAllByTravailleurImmatriculation(immatriculation);
         // ou :
         // List<PrsTrvService> anciens = serviceRepo.findByTravailleur(immatriculation);
         // serviceRepo.deleteAll(anciens);
     }

     if (travailleurModifie.getServices() != null) {
         for (PrsTrvService srv : travailleurModifie.getServices()) {
             if (srv.getId() == null) srv.setId(new PrsTrvServiceId());
             
             srv.getId().setTserTrvImmatriculation(immatriculation);
             srv.setTravailleur(travailleurExistant);
             
             if (srv.getTserDtCreee() == null) srv.setTserDtCreee(LocalDateTime.now());
             if (srv.getTserUtilCree() == null) srv.setTserUtilCree(currentUser());
             
             travailleurExistant.getServices().add(srv);
         }
     }

        return travailleurRepo.save(travailleurExistant);
    }

    // --- DELETE ---
    @Transactional
    public void delete(String immatriculation) {
        PrsTravailleur travailleur = travailleurRepo.findById(immatriculation)
                .orElseThrow(() -> new RuntimeException("Travailleur introuvable"));

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
        return "mugisha"; 
    }
}