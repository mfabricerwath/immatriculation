package com.inss.immatriculation.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inss.immatriculation.pojo.PrsEmployeur;

public interface PrsEmployeurRepository extends JpaRepository<PrsEmployeur, Long> {

    // 1. Pour récupérer le MAX(emp_sequence) (utilisé dans le save)
    @Query("SELECT MAX(e.empSequence) FROM PrsEmployeur e")
    Long findMaxSequence();

    // 2. Pour vérifier les doublons (Nom + Date de naissance) (utilisé dans save et update)
    Long countByEmpNomAndEmpDtNaissance(String empNom, LocalDate empDtNaissance);
    
    // 3. Optionnel : Si vous voulez aussi faire la vérification d'existence 
    // avant suppression pour les documents (lié par l'affiliation)
    boolean existsByEmpAffiliation(Long empAffiliation);
    
    Optional<PrsEmployeur> findByEmpAffiliation(Long empAffiliation);
    
    // optionnel : recherche partielle pour autocomplete
    List<PrsEmployeur> findTop10ByEmpAffiliationStartingWith(Long prefix);
}