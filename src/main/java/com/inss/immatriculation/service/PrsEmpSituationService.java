package com.inss.immatriculation.service;

import com.inss.immatriculation.pojo.PrsEmpSituation;
import com.inss.immatriculation.pojo.PrsEmpSituationId;
import com.inss.immatriculation.repository.PrsEmpSituationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PrsEmpSituationService {

    private final PrsEmpSituationRepository situationRepository;

    public PrsEmpSituationService(PrsEmpSituationRepository situationRepository) {
        this.situationRepository = situationRepository;
    }

    // --- MÉTHODES CRUD DE BASE ---

    public List<PrsEmpSituation> findAll() {
        return situationRepository.findAll();
    }
    public List<PrsEmpSituation> findByEmployeur(Long empSequence) {
        return situationRepository.findByEmployeur(empSequence); // Plus de "findById_Esit..."
    }

    public Optional<PrsEmpSituation> findById(PrsEmpSituationId id) {
        return situationRepository.findById(id);
    }

    @Transactional
    public PrsEmpSituation save(PrsEmpSituation situation) {
        // Si c'est une création, on peut forcer les champs de traçabilité
        if (situation.getEsitDtCreee() == null) {
            situation.setEsitDtCreee(java.time.LocalDateTime.now());
        }
        return situationRepository.save(situation);
    }

    @Transactional
    public void delete(PrsEmpSituationId id) {
        situationRepository.deleteById(id);
    }
}