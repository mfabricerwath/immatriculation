package com.inss.immatriculation.service;

import com.inss.immatriculation.pojo.PrsEmpActivite;
import com.inss.immatriculation.pojo.PrsEmpActiviteId;
import com.inss.immatriculation.repository.PrsEmpActiviteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrsEmpActiviteService {

    private final PrsEmpActiviteRepository activiteRepository;

    // Injection par constructeur (recommandée)
    public PrsEmpActiviteService(PrsEmpActiviteRepository activiteRepository) {
        this.activiteRepository = activiteRepository;
    }

    /**
     * Récupérer toutes les activités
     */
    public List<PrsEmpActivite> findAll() {
        return activiteRepository.findAll();
    }

    /**
     * Récupérer une activité par sa clé composite
     */
    public Optional<PrsEmpActivite> findById(PrsEmpActiviteId id) {
        return activiteRepository.findById(id);
    }

    /**
     * Récupérer toutes les activités d'un employeur spécifique
     */
    public List<PrsEmpActivite> findByEmployeur(Long empSequence) {
        return activiteRepository.findById_EactEmpSequence(empSequence);
    }

    /**
     * Créer une nouvelle activité
     */
    @Transactional
    public PrsEmpActivite save(PrsEmpActivite activite) {
        // Vous pouvez ajouter des règles métier ici (ex: vérifier que l'employeur existe)
        return activiteRepository.save(activite);
    }

    /**
     * Mettre à jour une activité existante
     */
    @Transactional
    public PrsEmpActivite update(PrsEmpActiviteId id, PrsEmpActivite nouvelleActivite) {
        return activiteRepository.findById(id)
                .map(ancienneActivite -> {
                    // On ne modifie pas la clé primaire, on copie juste les champs modifiables
                    ancienneActivite.setEactAffiliation(nouvelleActivite.getEactAffiliation());
                    ancienneActivite.setEactDtFin(nouvelleActivite.getEactDtFin());
                    
                    // Champs de traçabilité
                    ancienneActivite.setEactDtModifiee(java.time.LocalDateTime.now());
                    ancienneActivite.setEactUtilModifie(nouvelleActivite.getEactUtilModifie()); // ou l'utilisateur connecté
                    
                    return activiteRepository.save(ancienneActivite);
                })
                .orElseThrow(() -> new RuntimeException("Activité introuvable avec l'ID fourni"));
    }

    /**
     * Supprimer une activité par son ID
     */
    @Transactional
    public void deleteById(PrsEmpActiviteId id) {
        activiteRepository.deleteById(id);
    }
}