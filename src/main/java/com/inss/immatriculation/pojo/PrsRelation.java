package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_relation")
public class PrsRelation {

    @EmbeddedId
    private PrsRelationId id;

    @Column(name = "rel_nom", length = 50, nullable = false)
    private String relNom;

    @Column(name = "rel_prenom", length = 50)
    private String relPrenom;

    @Column(name = "rel_sexe", length = 1, nullable = false)
    private String relSexe;

    @Column(name = "rel_an_naissance", precision = 4, nullable = false)
    private Integer relAnNaissance;

    @Column(name = "rel_dt_naissance")
    private LocalDate relDtNaissance;

    @Column(name = "rel_beneficiare", length = 6)
    private String relBeneficiare;

    @Column(name = "rel_etat", length = 1)
    private String relEtat; // Légitime, Reconnu, Adopté

    @Column(name = "rel_immatriculation", length = 10)
    private String relImmatriculation;

    @Column(name = "rel_dt_creee", nullable = false)
    private LocalDateTime relDtCreee;

    @Column(name = "rel_util_cree", length = 15, nullable = false)
    private String relUtilCree;

    @Column(name = "rel_dt_modifiee")
    private LocalDateTime relDtModifiee;

    @Column(name = "rel_util_modifie", length = 15)
    private String relUtilModifie;

    // Relation vers le travailleur (Parent)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rel_trv_immatriculation", referencedColumnName = "trv_immatriculation", insertable = false, updatable = false)
    private PrsTravailleur travailleur;

	
    
}