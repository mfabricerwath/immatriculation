package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.PrsEmpSituation;
import com.inss.immatriculation.pojo.PrsEmpSituationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrsEmpSituationRepository
        extends JpaRepository<PrsEmpSituation, PrsEmpSituationId> {
}