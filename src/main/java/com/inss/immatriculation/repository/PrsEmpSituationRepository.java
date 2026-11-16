package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.PrsEmpSituation;
import com.inss.immatriculation.pojo.PrsEmpSituationId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PrsEmpSituationRepository extends JpaRepository<PrsEmpSituation, PrsEmpSituationId> {

    // Requête explicite pour éviter les problèmes de résolution de nom avec les clés composites
    @Query("SELECT s FROM PrsEmpSituation s WHERE s.id.esitEmpSequence = :empSequence")
    List<PrsEmpSituation> findByEmployeur(@Param("empSequence") Long empSequence);
    boolean existsById_EsitEmpSequence(Long empSequence);
}