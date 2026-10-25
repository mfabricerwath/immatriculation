package com.inss.immatriculation.pojo;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "prs_emp_activite", schema = "preslive")
@IdClass(EmpActiviteId.class)
public class EmpActivite implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "eact_activite", length = 6, nullable = false)
    private String eactActivite;

    @Id
    @Column(name = "eact_dt_debut", nullable = false)
    private LocalDate eactDtDebut;

    @Id
    @Column(name = "eact_emp_sequence", nullable = false)
    private Long eactEmpSequence;

    @Column(name = "eact_util_modifie", length = 15)
    private String eactUtilModifie;

    @Column(name = "eact_dt_modifiee")
    private LocalDateTime eactDtModifiee;

    @Column(name = "eact_dt_creee", nullable = false)
    private LocalDateTime eactDtCreee;

    @Column(name = "eact_util_cree", length = 15, nullable = false)
    private String eactUtilCree;

    @Column(name = "eact_dt_fin")
    private LocalDate eactDtFin;

    @Column(name = "eact_affiliation")
    private Long eactAffiliation;

    // Getters / Setters / equals / hashCode / constructeurs
}