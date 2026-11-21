package com.inss.immatriculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inss.immatriculation.pojo.PrsRelation;
import com.inss.immatriculation.pojo.PrsRelationId;


public interface PrsRelationRepository extends JpaRepository<PrsRelation, PrsRelationId> {
	
	@Modifying
	@Query("DELETE FROM PrsRelation r WHERE r.travailleur.trvImmatriculation = :immat")
	void deleteAllByTravailleurImmatriculation(@Param("immat") String immat);
}

