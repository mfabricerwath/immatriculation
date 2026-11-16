package com.inss.immatriculation.service;

import com.inss.immatriculation.pojo.PrsEmpSousSecteur;
import com.inss.immatriculation.pojo.PrsEmpSousSecteurId;
import com.inss.immatriculation.repository.PrsEmpSousSecteurRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PrsEmpSousSecteurService {

    private final PrsEmpSousSecteurRepository sousSecteurRepository;

    public PrsEmpSousSecteurService(PrsEmpSousSecteurRepository sousSecteurRepository) {
        this.sousSecteurRepository = sousSecteurRepository;
    }

    public List<PrsEmpSousSecteur> findAll() {
        return sousSecteurRepository.findAll();
    }

    public Optional<PrsEmpSousSecteur> findById(PrsEmpSousSecteurId id) {
        return sousSecteurRepository.findById(id);
    }

    public List<PrsEmpSousSecteur> findByEmployeur(Long empSequence) {
        return sousSecteurRepository.findByEmployeur(empSequence);
    }

    @Transactional
    public PrsEmpSousSecteur save(PrsEmpSousSecteur sousSecteur) {
        if (sousSecteur.getEsseDtCreee() == null) {
            sousSecteur.setEsseDtCreee(LocalDateTime.now());
            sousSecteur.setEsseUtilCree("admin"); // À remplacer par l'utilisateur connecté
        }
        return sousSecteurRepository.save(sousSecteur);
    }

    @Transactional
    public PrsEmpSousSecteur update(PrsEmpSousSecteurId id, PrsEmpSousSecteur nouveau) {
        return sousSecteurRepository.findById(id)
                .map(ancien -> {
                    // On ne modifie pas l'ID (qui est la clé primaire)
                    ancien.setEsseDtModifiee(LocalDateTime.now());
                    ancien.setEsseUtilModifie(nouveau.getEsseUtilModifie()); // ou l'utilisateur connecté
                    
                    return sousSecteurRepository.save(ancien);
                })
                .orElseThrow(() -> new RuntimeException("Sous-secteur introuvable"));
    }

    @Transactional
    public void delete(PrsEmpSousSecteurId id) {
        sousSecteurRepository.deleteById(id);
    }
}