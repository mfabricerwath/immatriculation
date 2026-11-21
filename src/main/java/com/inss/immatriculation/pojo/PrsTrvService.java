package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_trv_service")
public class PrsTrvService {

    @EmbeddedId
    private PrsTrvServiceId id;

    @Column(name = "tser_etat", length = 1, nullable = false)
    private String tserEtat;

    @Column(name = "tser_categorie", length = 6, nullable=true)
    private String tserCategorie="NAN";

    @Column(name = "tser_type_ass", length = 2)
    private String tserTypeAss;

    @Column(name = "tser_matricule", length = 10)
    private String tserMatricule;

    @Column(name = "tser_designation", length = 50)
    private String tserDesignation;

    @Column(name = "tser_salaire")
    private BigDecimal tserSalaire;

    @Column(name = "tser_telephone", length = 10)
    private String tserTelephone;

    @Column(name = "tser_affiliation", precision = 20)
    private Long tserAffiliation;

    @Column(name = "tser_code_postal", length = 10)
    private String tserCodePostal;

    @Column(name = "tser_motif", length = 6)
    private String tserMotif;

    @Column(name = "tser_dt_fin")
    private LocalDate tserDtFin;

    @Column(name = "tser_dt_creee", nullable = false)
    private LocalDateTime tserDtCreee;

    @Column(name = "tser_util_cree", length = 15, nullable = false)
    private String tserUtilCree;

    @Column(name = "tser_dt_modifiee")
    private LocalDateTime tserDtModifiee;

    @Column(name = "tser_util_modifie", length = 15)
    private String tserUtilModifie;

    // Relation vers le travailleur
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tser_trv_immatriculation", referencedColumnName = "trv_immatriculation", insertable = false, updatable = false)
    private PrsTravailleur travailleur;

    // Relation vers l'employeur (via la séquence)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tser_emp_sequence", referencedColumnName = "emp_sequence", insertable = false, updatable = false)
    private PrsEmployeur employeur;
    
    
    

	
    
}