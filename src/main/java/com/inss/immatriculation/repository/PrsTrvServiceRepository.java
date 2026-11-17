package com.inss.immatriculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inss.immatriculation.pojo.PrsTrvService;
import com.inss.immatriculation.pojo.PrsTrvServiceId;

public interface PrsTrvServiceRepository extends JpaRepository<PrsTrvService, PrsTrvServiceId> {
}