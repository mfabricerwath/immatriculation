package com.inss.immatriculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inss.immatriculation.pojo.PrsRelation;
import com.inss.immatriculation.pojo.PrsRelationId;


public interface PrsRelationRepository extends JpaRepository<PrsRelation, PrsRelationId> {
}

