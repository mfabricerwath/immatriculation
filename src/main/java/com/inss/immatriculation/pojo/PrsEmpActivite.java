package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_emp_activite")
public class PrsEmpActivite {

    @EmbeddedId
    private PrsEmpActiviteId id;

    @Column(name = "eact_util_modifie", length = 15)
    private String eactUtilModifie;

    @Column(name = "eact_dt_modifiee")
    private LocalDateTime eactDtModifiee;

    @Column(name = "eact_dt_creee", nullable = false)
    private LocalDateTime eactDtCreee;

    @Column(name = "eact_util_cree", nullable = false, length = 15)
    private String eactUtilCree;

    @Column(name = "eact_dt_fin")
    private LocalDate eactDtFin;

    @Column(name = "eact_affiliation", precision = 10)
    private Long eactAffiliation;

    // Relation vers PRS_EMPLOYEUR (clé étrangère eact_emp_sequence)
    // insertable = false, updatable = false car la colonne est déjà mappée dans la clé composite
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eact_emp_sequence", 
                referencedColumnName = "emp_sequence",
                insertable = false, updatable = false)
    private PrsEmployeur employeur;
}