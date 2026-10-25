package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.PrsEmpActivite;
import com.inss.immatriculation.pojo.PrsEmpActiviteId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrsEmpActiviteRepository extends JpaRepository<PrsEmpActivite, PrsEmpActiviteId> {
    
    // Méthode pratique pour chercher les activités d'un employeur spécifique
    List<PrsEmpActivite> findById_EactEmpSequence(Long empSequence);
}