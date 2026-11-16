package com.inss.immatriculation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inss.immatriculation.pojo.PrsEmpSousSecteur;
import com.inss.immatriculation.pojo.PrsEmpSousSecteurId;

public interface PrsEmpSousSecteurRepository extends JpaRepository<PrsEmpSousSecteur, PrsEmpSousSecteurId> {

    // Pour récupérer les sous-secteurs d'un employeur spécifique
    @Query("SELECT s FROM PrsEmpSousSecteur s WHERE s.id.secteurId.esecEmpSequence = :empSequence")
    List<PrsEmpSousSecteur> findByEmployeur(@Param("empSequence") Long empSequence);

    // Pour récupérer les sous-secteurs d'un secteur spécifique
    @Query("SELECT s FROM PrsEmpSousSecteur s WHERE s.id.secteurId.esecSecteur = :secteur AND s.id.secteurId.esecEmpSequence = :empSequence")
    List<PrsEmpSousSecteur> findBySecteur(@Param("secteur") String secteur, @Param("empSequence") Long empSequence);
}