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

    @Column(name = "tser_categorie", length = 6, nullable = false)
    private String tserCategorie;

    @Column(name = "tser_type_ass", length = 2, nullable = false)
    private String tserTypeAss;

    @Column(name = "tser_matricule", length = 10)
    private String tserMatricule;

    @Column(name = "tser_designation", length = 50)
    private String tserDesignation;

    @Column(name = "tser_salaire")
    private BigDecimal tserSalaire;

    @Column(name = "tser_telephone", length = 10)
    private String tserTelephone;

    @Column(name = "tser_affiliation", precision = 10)
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
    
    
    

	public PrsTrvServiceId getId() {
		return id;
	}

	public void setId(PrsTrvServiceId id) {
		this.id = id;
	}

	public String getTserEtat() {
		return tserEtat;
	}

	public void setTserEtat(String tserEtat) {
		this.tserEtat = tserEtat;
	}

	public String getTserCategorie() {
		return tserCategorie;
	}

	public void setTserCategorie(String tserCategorie) {
		this.tserCategorie = tserCategorie;
	}

	public String getTserTypeAss() {
		return tserTypeAss;
	}

	public void setTserTypeAss(String tserTypeAss) {
		this.tserTypeAss = tserTypeAss;
	}

	public String getTserMatricule() {
		return tserMatricule;
	}

	public void setTserMatricule(String tserMatricule) {
		this.tserMatricule = tserMatricule;
	}

	public String getTserDesignation() {
		return tserDesignation;
	}

	public void setTserDesignation(String tserDesignation) {
		this.tserDesignation = tserDesignation;
	}

	public BigDecimal getTserSalaire() {
		return tserSalaire;
	}

	public void setTserSalaire(BigDecimal tserSalaire) {
		this.tserSalaire = tserSalaire;
	}

	public String getTserTelephone() {
		return tserTelephone;
	}

	public void setTserTelephone(String tserTelephone) {
		this.tserTelephone = tserTelephone;
	}

	public Long getTserAffiliation() {
		return tserAffiliation;
	}

	public void setTserAffiliation(Long tserAffiliation) {
		this.tserAffiliation = tserAffiliation;
	}

	public String getTserCodePostal() {
		return tserCodePostal;
	}

	public void setTserCodePostal(String tserCodePostal) {
		this.tserCodePostal = tserCodePostal;
	}

	public String getTserMotif() {
		return tserMotif;
	}

	public void setTserMotif(String tserMotif) {
		this.tserMotif = tserMotif;
	}

	public LocalDate getTserDtFin() {
		return tserDtFin;
	}

	public void setTserDtFin(LocalDate tserDtFin) {
		this.tserDtFin = tserDtFin;
	}

	public LocalDateTime getTserDtCreee() {
		return tserDtCreee;
	}

	public void setTserDtCreee(LocalDateTime tserDtCreee) {
		this.tserDtCreee = tserDtCreee;
	}

	public String getTserUtilCree() {
		return tserUtilCree;
	}

	public void setTserUtilCree(String tserUtilCree) {
		this.tserUtilCree = tserUtilCree;
	}

	public LocalDateTime getTserDtModifiee() {
		return tserDtModifiee;
	}

	public void setTserDtModifiee(LocalDateTime tserDtModifiee) {
		this.tserDtModifiee = tserDtModifiee;
	}

	public String getTserUtilModifie() {
		return tserUtilModifie;
	}

	public void setTserUtilModifie(String tserUtilModifie) {
		this.tserUtilModifie = tserUtilModifie;
	}

	public PrsTravailleur getTravailleur() {
		return travailleur;
	}

	public void setTravailleur(PrsTravailleur travailleur) {
		this.travailleur = travailleur;
	}

	public PrsEmployeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(PrsEmployeur employeur) {
		this.employeur = employeur;
	}
    
    
    
}