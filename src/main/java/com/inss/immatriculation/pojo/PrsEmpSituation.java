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

@Entity
@Table(name = "prs_emp_situation")

public class PrsEmpSituation {

    @EmbeddedId
    private PrsEmpSituationId id;

    @Column(name = "esit_util_modifie", length = 15)
    private String esitUtilModifie;

    @Column(name = "esit_raison", length = 6)
    private String esitRaison;

    @Column(name = "esit_dt_effet", nullable = false)
    private LocalDate esitDtEffet;

    @Column(name = "esit_util_cree", nullable = false, length = 15)
    private String esitUtilCree;

    @Column(name = "esit_dt_cre" + "ee", nullable = false)
    private LocalDateTime esitDtCreee;

    @Column(name = "esit_affiliation", precision = 10)
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

	public PrsEmpSituationId getId() {
		return id;
	}

	public void setId(PrsEmpSituationId id) {
		this.id = id;
	}

	public String getEsitUtilModifie() {
		return esitUtilModifie;
	}

	public void setEsitUtilModifie(String esitUtilModifie) {
		this.esitUtilModifie = esitUtilModifie;
	}

	public String getEsitRaison() {
		return esitRaison;
	}

	public void setEsitRaison(String esitRaison) {
		this.esitRaison = esitRaison;
	}

	public LocalDate getEsitDtEffet() {
		return esitDtEffet;
	}

	public void setEsitDtEffet(LocalDate esitDtEffet) {
		this.esitDtEffet = esitDtEffet;
	}

	public String getEsitUtilCree() {
		return esitUtilCree;
	}

	public void setEsitUtilCree(String esitUtilCree) {
		this.esitUtilCree = esitUtilCree;
	}

	public LocalDateTime getEsitDtCreee() {
		return esitDtCreee;
	}

	public void setEsitDtCreee(LocalDateTime esitDtCreee) {
		this.esitDtCreee = esitDtCreee;
	}

	public Long getEsitAffiliation() {
		return esitAffiliation;
	}

	public void setEsitAffiliation(Long esitAffiliation) {
		this.esitAffiliation = esitAffiliation;
	}

	public LocalDateTime getEsitDtModifiee() {
		return esitDtModifiee;
	}

	public void setEsitDtModifiee(LocalDateTime esitDtModifiee) {
		this.esitDtModifiee = esitDtModifiee;
	}

	public PrsEmployeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(PrsEmployeur employeur) {
		this.employeur = employeur;
	}

    // getters / setters
   
    
}