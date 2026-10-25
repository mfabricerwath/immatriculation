package com.inss.immatriculation.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.inss.immatriculation.pojo.PrsEmpSituation;
import com.inss.immatriculation.pojo.PrsEmpSituationId;
import com.inss.immatriculation.repository.PrsEmpSituationRepository;

@Service
public class PrsEmpSituationService {

    private final PrsEmpSituationRepository repo;

    public PrsEmpSituationService(PrsEmpSituationRepository repo) {
        this.repo = repo;
    }

    public PrsEmpSituation create(String operation, LocalDate dtLettre,
                                  Long empSequence, PrsEmpSituation data) {
        PrsEmpSituationId id = new PrsEmpSituationId(operation, dtLettre, empSequence);
        data.setId(id);
        return repo.save(data);
    }
}