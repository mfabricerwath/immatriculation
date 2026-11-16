package com.inss.immatriculation.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inss.immatriculation.pojo.PrsEmpSecteur;
import com.inss.immatriculation.pojo.PrsEmpSecteurId;

import java.util.List;


public interface PrsEmpSecteurRepository extends JpaRepository<PrsEmpSecteur, PrsEmpSecteurId> {

    @Query("SELECT s FROM PrsEmpSecteur s WHERE s.id.esecEmpSequence = :empSequence")
    List<PrsEmpSecteur> findByEmployeur(@Param("empSequence") Long empSequence);
    boolean existsById_EsecEmpSequence(Long empSequence);
}