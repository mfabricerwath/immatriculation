package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_emp_sous_secteur")
public class PrsEmpSousSecteur {

    @EmbeddedId
    private PrsEmpSousSecteurId id;

    @Column(name = "esse_util_cree", nullable = false, length = 15)
    private String esseUtilCree;

    @Column(name = "esse_util_modifie", length = 15)
    private String esseUtilModifie;

    @Column(name = "esse_dt_modifiee")
    private LocalDateTime esseDtModifiee;

    @Column(name = "esse_dt_creee", nullable = false)
    private LocalDateTime esseDtCreee;

    // Relation vers le secteur parent (clé étrangère)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "esse_esec_secteur", referencedColumnName = "esec_secteur", insertable = false, updatable = false),
        @JoinColumn(name = "esse_esec_emp_sequence", referencedColumnName = "esec_emp_sequence", insertable = false, updatable = false)
    })
    private PrsEmpSecteur secteur;

	
    
}