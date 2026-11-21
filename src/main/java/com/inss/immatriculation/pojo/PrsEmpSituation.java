package com.inss.immatriculation.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "prs_emp_situation")
@Data

public class PrsEmpSituation {

    @EmbeddedId
    private PrsEmpSituationId id;

    @Column(name = "esit_util_modifie", length = 15)
    private String esitUtilModifie;

    @Column(name = "esit_raison", length = 20)
    private String esitRaison;

    @Column(name = "esit_dt_effet", nullable = false)
    private LocalDate esitDtEffet;

    @Column(name = "esit_util_cree", nullable = false, length = 25)
    private String esitUtilCree;

    @Column(name = "esit_dt_cre" + "ee", nullable = false)
    private LocalDateTime esitDtCreee;

    @Column(name = "esit_affiliation", precision = 20)
    private Long esitAffiliation;

    @Column(name = "esit_dt_modifiee")
    private LocalDateTime esitDtModifiee;

    // Relation vers PRS_EMPLOYEUR (FK esit_emp_sequence)
    // Note : le champ esitEmpSequence est déjà dans la clé composite.
    // On le remappe ici en lecture seule pour la relation.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "esit_emp_sequence",
                referencedColumnName = "emp_sequence",
                insertable = false, updatable = false)
    private PrsEmployeur employeur;
    
    
    // Dans PrsEmpSituation.java
    public String getEsitOperation() {
        return id != null ? id.getEsitOperation() : null;
    }
    public void setEsitOperation(String esitOperation) {
        if (id == null) id = new PrsEmpSituationId();
        id.setEsitOperation(esitOperation);
    }
    public LocalDate getEsitDtLettre() {
        return id != null ? id.getEsitDtLettre() : null;
    }
    public void setEsitDtLettre(LocalDate esitDtLettre) {
        if (id == null) id = new PrsEmpSituationId();
        id.setEsitDtLettre(esitDtLettre);
    }
    

	
   
    
}