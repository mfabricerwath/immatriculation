package com.inss.immatriculation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inss.immatriculation.pojo.PrsEmployeur;

public interface PrsEmployeurRepository extends JpaRepository<PrsEmployeur, Long> {
}