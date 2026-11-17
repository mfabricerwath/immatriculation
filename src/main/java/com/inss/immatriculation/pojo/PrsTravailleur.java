package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "prs_travailleur")
public class PrsTravailleur {

    @Id
    @Column(name = "trv_immatriculation", length = 10, nullable = false)
    private String trvImmatriculation;

    // --- Identité ---
    @Column(name = "trv_nom", length = 100, nullable = false)
    private String trvNom;

    @Column(name = "trv_prenom", length = 50)
    private String trvPrenom;

    @Column(name = "trv_nom_jeunefille", length = 50)
    private String trvNomJeunefille;

    @Column(name = "trv_sexe", length = 1, nullable = false)
    private String trvSexe;

    @Column(name = "trv_dt_naissance")
    private LocalDate trvDtNaissance;

    @Column(name = "trv_an_naissance", precision = 4, nullable = false)
    private Integer trvAnNaissance;

    @Column(name = "trv_lieu_naissance", length = 200)
    private String trvLieuNaissance;

    @Column(name = "trv_nationalite", length = 30)
    private String trvNationalite;

    @Column(name = "trv_etat_civil", length = 1, nullable = false)
    private String trvEtatCivil;

    @Column(name = "trv_nom_pere", length = 100, nullable = false)
    private String trvNomPere;

    @Column(name = "trv_nom_mere", length = 100, nullable = false)
    private String trvNomMere;

    @Column(name = "trv_cni", length = 20)
    private String trvCni;

    @Column(name = "trv_photo", length = 50)
    private String trvPhoto;

    // --- Adresse Physique ---
    @Column(name = "trv_rue", length = 50)
    private String trvRue;
    @Column(name = "trv_localite", length = 50)
    private String trvLocalite;
    @Column(name = "trv_ville", length = 50)
    private String trvVille;
    @Column(name = "trv_province", length = 6, nullable = false)
    private String trvProvince;
    @Column(name = "trv_commune", length = 6, nullable = false)
    private String trvCommune;
    @Column(name = "trv_colline", length = 6, nullable = false)
    private String trvColline;
    @Column(name = "trv_pays", length = 6)
    private String trvPays;
    @Column(name = "trv_code_postal", length = 10)
    private String trvCodePostal;
    @Column(name = "trv_telephone", length = 20)
    private String trvTelephone;
    @Column(name = "trv_email", length = 20)
    private String trvEmail;
    @Column(name = "trv_fax", length = 20)
    private String trvFax;

    // --- Adresse Postale ---
    @Column(name = "trv_rue_p", length = 50)
    private String trvRueP;
    @Column(name = "trv_localite_p", length = 50)
    private String trvLocaliteP;
    @Column(name = "trv_ville_p", length = 50)
    private String trvVilleP;
    @Column(name = "trv_pays_p", length = 6)
    private String trvPaysP;
    @Column(name = "trv_code_postal_p", length = 10)
    private String trvCodePostalP;
    @Column(name = "trv_telephone_p", length = 10)
    private String trvTelephoneP;
    @Column(name = "trv_email_p", length = 20)
    private String trvEmailP;
    @Column(name = "trv_fax_p", length = 20)
    private String trvFaxP;

    // --- Détails Professionnels ---
    @Column(name = "trv_cat_prof", length = 6)
    private String trvCatProf;
    @Column(name = "trv_niveau_formation", length = 6)
    private String trvNiveauFormation;
    @Column(name = "trv_salaire", precision = 30)
    private BigDecimal trvSalaire;
    @Column(name = "trv_dt_embauche_temp", length = 50)
    private String trvDtEmbaucheTemp;
    @Column(name = "trv_dt_naissance_temp", length = 50)
    private String trvDtNaissanceTemp;
    @Column(name = "trv_rep_legal", length = 50)
    private String trvRepLegal;
    @Column(name = "trv_livret", length = 1)
    private String trvLivret;

    // --- Statut & Dates ---
    @Column(name = "trv_etat", length = 1, nullable = false)
    private String trvEtat;
    
    @Column(name = "trv_dt_demande", nullable = false)
    private LocalDate trvDtDemande;
    
    @Column(name = "trv_dt_reception", nullable = false)
    private LocalDate trvDtReception;
    
    @Column(name = "trv_dt_assurance", nullable = false)
    private LocalDate trvDtAssurance;

    // --- Audit ---
    @Column(name = "trv_dt_creee", nullable = false)
    private LocalDateTime trvDtCreee;
    @Column(name = "trv_util_cree", length = 15, nullable = false)
    private String trvUtilCree;
    @Column(name = "trv_dt_modifiee")
    private LocalDateTime trvDtModifiee;
    @Column(name = "trv_util_modifie", length = 15)
    private String trvUtilModifie;

    // --- Champs de migration / historique ---
    @Column(name = "trv_old_immatriculation", length = 10)
    private String trvOldImmatriculation;
    @Column(name = "trv_mig_dt_creee")
    private LocalDate trvMigDtCreee;
    @Column(name = "trv_mig_dt_modifiee")
    private LocalDate trvMigDtModifiee;
    @Column(name = "trv_mig_agent", length = 30)
    private String trvMigAgent;
    @Column(name = "trv_precedent", length = 10)
    private String trvPrecedent;
    @Column(name = "trv_lieu", length = 200)
    private String trvLieu;
    // Dans PrsTravailleur.java

    @OneToMany(mappedBy = "travailleur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrsRelation> relations = new ArrayList<>();

    @OneToMany(mappedBy = "travailleur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrsTrvService> services = new ArrayList<>();

    
    
    
	public String getTrvImmatriculation() {
		return trvImmatriculation;
	}

	public void setTrvImmatriculation(String trvImmatriculation) {
		this.trvImmatriculation = trvImmatriculation;
	}

	public String getTrvNom() {
		return trvNom;
	}

	public void setTrvNom(String trvNom) {
		this.trvNom = trvNom;
	}

	public String getTrvPrenom() {
		return trvPrenom;
	}

	public void setTrvPrenom(String trvPrenom) {
		this.trvPrenom = trvPrenom;
	}

	public String getTrvNomJeunefille() {
		return trvNomJeunefille;
	}

	public void setTrvNomJeunefille(String trvNomJeunefille) {
		this.trvNomJeunefille = trvNomJeunefille;
	}

	public String getTrvSexe() {
		return trvSexe;
	}

	public void setTrvSexe(String trvSexe) {
		this.trvSexe = trvSexe;
	}

	public LocalDate getTrvDtNaissance() {
		return trvDtNaissance;
	}

	public void setTrvDtNaissance(LocalDate trvDtNaissance) {
		this.trvDtNaissance = trvDtNaissance;
	}

	public Integer getTrvAnNaissance() {
		return trvAnNaissance;
	}

	public void setTrvAnNaissance(Integer trvAnNaissance) {
		this.trvAnNaissance = trvAnNaissance;
	}

	public String getTrvLieuNaissance() {
		return trvLieuNaissance;
	}

	public void setTrvLieuNaissance(String trvLieuNaissance) {
		this.trvLieuNaissance = trvLieuNaissance;
	}

	public String getTrvNationalite() {
		return trvNationalite;
	}

	public void setTrvNationalite(String trvNationalite) {
		this.trvNationalite = trvNationalite;
	}

	public String getTrvEtatCivil() {
		return trvEtatCivil;
	}

	public void setTrvEtatCivil(String trvEtatCivil) {
		this.trvEtatCivil = trvEtatCivil;
	}

	public String getTrvNomPere() {
		return trvNomPere;
	}

	public void setTrvNomPere(String trvNomPere) {
		this.trvNomPere = trvNomPere;
	}

	public String getTrvNomMere() {
		return trvNomMere;
	}

	public void setTrvNomMere(String trvNomMere) {
		this.trvNomMere = trvNomMere;
	}

	public String getTrvCni() {
		return trvCni;
	}

	public void setTrvCni(String trvCni) {
		this.trvCni = trvCni;
	}

	public String getTrvPhoto() {
		return trvPhoto;
	}

	public void setTrvPhoto(String trvPhoto) {
		this.trvPhoto = trvPhoto;
	}

	public String getTrvRue() {
		return trvRue;
	}

	public void setTrvRue(String trvRue) {
		this.trvRue = trvRue;
	}

	public String getTrvLocalite() {
		return trvLocalite;
	}

	public void setTrvLocalite(String trvLocalite) {
		this.trvLocalite = trvLocalite;
	}

	public String getTrvVille() {
		return trvVille;
	}

	public void setTrvVille(String trvVille) {
		this.trvVille = trvVille;
	}

	public String getTrvProvince() {
		return trvProvince;
	}

	public void setTrvProvince(String trvProvince) {
		this.trvProvince = trvProvince;
	}

	public String getTrvCommune() {
		return trvCommune;
	}

	public void setTrvCommune(String trvCommune) {
		this.trvCommune = trvCommune;
	}

	public String getTrvColline() {
		return trvColline;
	}

	public void setTrvColline(String trvColline) {
		this.trvColline = trvColline;
	}

	public String getTrvPays() {
		return trvPays;
	}

	public void setTrvPays(String trvPays) {
		this.trvPays = trvPays;
	}

	public String getTrvCodePostal() {
		return trvCodePostal;
	}

	public void setTrvCodePostal(String trvCodePostal) {
		this.trvCodePostal = trvCodePostal;
	}

	public String getTrvTelephone() {
		return trvTelephone;
	}

	public void setTrvTelephone(String trvTelephone) {
		this.trvTelephone = trvTelephone;
	}

	public String getTrvEmail() {
		return trvEmail;
	}

	public void setTrvEmail(String trvEmail) {
		this.trvEmail = trvEmail;
	}

	public String getTrvFax() {
		return trvFax;
	}

	public void setTrvFax(String trvFax) {
		this.trvFax = trvFax;
	}

	public String getTrvRueP() {
		return trvRueP;
	}

	public void setTrvRueP(String trvRueP) {
		this.trvRueP = trvRueP;
	}

	public String getTrvLocaliteP() {
		return trvLocaliteP;
	}

	public void setTrvLocaliteP(String trvLocaliteP) {
		this.trvLocaliteP = trvLocaliteP;
	}

	public String getTrvVilleP() {
		return trvVilleP;
	}

	public void setTrvVilleP(String trvVilleP) {
		this.trvVilleP = trvVilleP;
	}

	public String getTrvPaysP() {
		return trvPaysP;
	}

	public void setTrvPaysP(String trvPaysP) {
		this.trvPaysP = trvPaysP;
	}

	public String getTrvCodePostalP() {
		return trvCodePostalP;
	}

	public void setTrvCodePostalP(String trvCodePostalP) {
		this.trvCodePostalP = trvCodePostalP;
	}

	public String getTrvTelephoneP() {
		return trvTelephoneP;
	}

	public void setTrvTelephoneP(String trvTelephoneP) {
		this.trvTelephoneP = trvTelephoneP;
	}

	public String getTrvEmailP() {
		return trvEmailP;
	}

	public void setTrvEmailP(String trvEmailP) {
		this.trvEmailP = trvEmailP;
	}

	public String getTrvFaxP() {
		return trvFaxP;
	}

	public void setTrvFaxP(String trvFaxP) {
		this.trvFaxP = trvFaxP;
	}

	public String getTrvCatProf() {
		return trvCatProf;
	}

	public void setTrvCatProf(String trvCatProf) {
		this.trvCatProf = trvCatProf;
	}

	public String getTrvNiveauFormation() {
		return trvNiveauFormation;
	}

	public void setTrvNiveauFormation(String trvNiveauFormation) {
		this.trvNiveauFormation = trvNiveauFormation;
	}

	public BigDecimal getTrvSalaire() {
		return trvSalaire;
	}

	public void setTrvSalaire(BigDecimal trvSalaire) {
		this.trvSalaire = trvSalaire;
	}

	public String getTrvDtEmbaucheTemp() {
		return trvDtEmbaucheTemp;
	}

	public void setTrvDtEmbaucheTemp(String trvDtEmbaucheTemp) {
		this.trvDtEmbaucheTemp = trvDtEmbaucheTemp;
	}

	public String getTrvDtNaissanceTemp() {
		return trvDtNaissanceTemp;
	}

	public void setTrvDtNaissanceTemp(String trvDtNaissanceTemp) {
		this.trvDtNaissanceTemp = trvDtNaissanceTemp;
	}

	public String getTrvRepLegal() {
		return trvRepLegal;
	}

	public void setTrvRepLegal(String trvRepLegal) {
		this.trvRepLegal = trvRepLegal;
	}

	public String getTrvLivret() {
		return trvLivret;
	}

	public void setTrvLivret(String trvLivret) {
		this.trvLivret = trvLivret;
	}

	public String getTrvEtat() {
		return trvEtat;
	}

	public void setTrvEtat(String trvEtat) {
		this.trvEtat = trvEtat;
	}

	public LocalDate getTrvDtDemande() {
		return trvDtDemande;
	}

	public void setTrvDtDemande(LocalDate trvDtDemande) {
		this.trvDtDemande = trvDtDemande;
	}

	public LocalDate getTrvDtReception() {
		return trvDtReception;
	}

	public void setTrvDtReception(LocalDate trvDtReception) {
		this.trvDtReception = trvDtReception;
	}

	public LocalDate getTrvDtAssurance() {
		return trvDtAssurance;
	}

	public void setTrvDtAssurance(LocalDate trvDtAssurance) {
		this.trvDtAssurance = trvDtAssurance;
	}

	public LocalDateTime getTrvDtCreee() {
		return trvDtCreee;
	}

	public void setTrvDtCreee(LocalDateTime trvDtCreee) {
		this.trvDtCreee = trvDtCreee;
	}

	public String getTrvUtilCree() {
		return trvUtilCree;
	}

	public void setTrvUtilCree(String trvUtilCree) {
		this.trvUtilCree = trvUtilCree;
	}

	public LocalDateTime getTrvDtModifiee() {
		return trvDtModifiee;
	}

	public void setTrvDtModifiee(LocalDateTime trvDtModifiee) {
		this.trvDtModifiee = trvDtModifiee;
	}

	public String getTrvUtilModifie() {
		return trvUtilModifie;
	}

	public void setTrvUtilModifie(String trvUtilModifie) {
		this.trvUtilModifie = trvUtilModifie;
	}

	public String getTrvOldImmatriculation() {
		return trvOldImmatriculation;
	}

	public void setTrvOldImmatriculation(String trvOldImmatriculation) {
		this.trvOldImmatriculation = trvOldImmatriculation;
	}

	public LocalDate getTrvMigDtCreee() {
		return trvMigDtCreee;
	}

	public void setTrvMigDtCreee(LocalDate trvMigDtCreee) {
		this.trvMigDtCreee = trvMigDtCreee;
	}

	public LocalDate getTrvMigDtModifiee() {
		return trvMigDtModifiee;
	}

	public void setTrvMigDtModifiee(LocalDate trvMigDtModifiee) {
		this.trvMigDtModifiee = trvMigDtModifiee;
	}

	public String getTrvMigAgent() {
		return trvMigAgent;
	}

	public void setTrvMigAgent(String trvMigAgent) {
		this.trvMigAgent = trvMigAgent;
	}

	public String getTrvPrecedent() {
		return trvPrecedent;
	}

	public void setTrvPrecedent(String trvPrecedent) {
		this.trvPrecedent = trvPrecedent;
	}

	public String getTrvLieu() {
		return trvLieu;
	}

	public void setTrvLieu(String trvLieu) {
		this.trvLieu = trvLieu;
	}

	public List<PrsRelation> getRelations() {
		return relations;
	}

	public void setRelations(List<PrsRelation> relations) {
		this.relations = relations;
	}

	public List<PrsTrvService> getServices() {
		return services;
	}

	public void setServices(List<PrsTrvService> services) {
		this.services = services;
	}
    
    // Si vous avez créé l'entité pour PRS_TRV_DETAILS :
    // @OneToMany(mappedBy = "travailleur", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<PrsTrvDetails> details = new ArrayList<>();

    // --- Relations (seront complétées plus tard) ---
    // @ManyToOne
    // @JoinColumn(name = "trv_employeur_affiliation")
    // private PrsEmployeur employeur;
    
    
}