package com.inss.immatriculation.pojo;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prs_emp_historique")
@Data
public class PrsEmpHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hist")
    @SequenceGenerator(name = "seq_hist", sequenceName = "seq_prs_emp_hist", allocationSize = 1)
    @Column(name = "ehis_sequence", nullable = false, precision = 10)
    private Long ehisSequence;

    @Column(name = "ehis_libelle", length = 50)
    private String ehisLibelle;

    @Column(name = "ehis_emp_sequence", precision = 10)
    private Long ehisEmpSequence;

    @Column(name = "ehis_valeur_avant", length = 400)
    private String ehisValeurAvant;

    @Column(name = "ehis_valeur_apres", length = 400)
    private String ehisValeurApres;

    @Column(name = "ehis_dt_creee")
    private LocalDate ehisDtCreee;

    @Column(name = "ehis_util_cree", length = 30)
    private String ehisUtilCree;

    @Column(name = "ehis_affiliation", precision = 10)
    private Long ehisAffiliation;

	public Long getEhisSequence() {
		return ehisSequence;
	}

	public void setEhisSequence(Long ehisSequence) {
		this.ehisSequence = ehisSequence;
	}

	public String getEhisLibelle() {
		return ehisLibelle;
	}

	public void setEhisLibelle(String ehisLibelle) {
		this.ehisLibelle = ehisLibelle;
	}

	public Long getEhisEmpSequence() {
		return ehisEmpSequence;
	}

	public void setEhisEmpSequence(Long ehisEmpSequence) {
		this.ehisEmpSequence = ehisEmpSequence;
	}

	public String getEhisValeurAvant() {
		return ehisValeurAvant;
	}

	public void setEhisValeurAvant(String ehisValeurAvant) {
		this.ehisValeurAvant = ehisValeurAvant;
	}

	public String getEhisValeurApres() {
		return ehisValeurApres;
	}

	public void setEhisValeurApres(String ehisValeurApres) {
		this.ehisValeurApres = ehisValeurApres;
	}

	public LocalDate getEhisDtCreee() {
		return ehisDtCreee;
	}

	public void setEhisDtCreee(LocalDate ehisDtCreee) {
		this.ehisDtCreee = ehisDtCreee;
	}

	public String getEhisUtilCree() {
		return ehisUtilCree;
	}

	public void setEhisUtilCree(String ehisUtilCree) {
		this.ehisUtilCree = ehisUtilCree;
	}

	public Long getEhisAffiliation() {
		return ehisAffiliation;
	}

	public void setEhisAffiliation(Long ehisAffiliation) {
		this.ehisAffiliation = ehisAffiliation;
	}

    
}