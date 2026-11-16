package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.AuditRec;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AuditRecRepository extends JpaRepository<AuditRec, Long> {
}