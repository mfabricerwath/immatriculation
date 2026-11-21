package com.inss.immatriculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inss.immatriculation.pojo.PrsTrvService;
import com.inss.immatriculation.pojo.PrsTrvServiceId;

public interface PrsTrvServiceRepository extends JpaRepository<PrsTrvService, PrsTrvServiceId> {
	@Modifying
	@Query("DELETE FROM PrsTrvService s WHERE s.travailleur.trvImmatriculation = :immat")
	void deleteAllByTravailleurImmatriculation(@Param("immat") String immat);
}