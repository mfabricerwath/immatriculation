package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.PrsTravailleur;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PrsTravailleurRepository extends JpaRepository<PrsTravailleur, String> {
    
    // Pour vérifier si un travailleur existe déjà par son CNI
    Optional<PrsTravailleur> findByTrvCni(String trvCni);
    
    // Pour vérifier si un travailleur existe déjà par son nom et prénom
    Optional<PrsTravailleur> findByTrvNomAndTrvPrenom(String trvNom, String trvPrenom);
    
    // Pour rechercher par immatriculation
    Optional<PrsTravailleur> findByTrvImmatriculation(String trvImmatriculation);
}