package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRS_EMPLOYEUR") // Remplacez par le nom réel de votre table si différent
@NoArgsConstructor
@AllArgsConstructor

public class PrsEmployeur {

    // --- Section 1 ---

    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq") // Décommenter si auto-généré
    // @SequenceGenerator(name = "emp_seq", sequenceName = "VOTRE_SEQUENCE", allocationSize = 1)
    @Column(name = "EMP_SEQUENCE", nullable = false)
    private Long empSequence;

    @Column(name = "EMP_AFFILIATION")
    private Long empAffiliation;

    @Column(name = "EMP_NOM", length = 100, nullable = false)
    private String empNom;

    @Column(name = "EMP_PRENOM", length = 50)
    private String empPrenom;

    @Column(name = "EMP_ABREV", length = 10)
    private String empAbrev;

    @Column(name = "EMP_DT_CREE_ENTR", nullable = false)
    private LocalDate empDtCreeEntr;

    @Column(name = "EMP_DT_NAISSANCE")
    private LocalDate empDtNaissance;

    @Column(name = "EMP_DT_DEMANDE")
    private LocalDate empDtDemande;

    @Column(name = "EMP_IND_EXEMPTE", length = 1, nullable = false)
    private String empIndExempte;

    @Column(name = "EMP_DT_RECEPTION", nullable = false)
    private LocalDate empDtReception;

    @Column(name = "EMP_AFFIL_PRECEDENT")
    private Long empAffilPrecedent;

    @Column(name = "EMP_DT_EFFET")
    private LocalDate empDtEffet;

    @Column(name = "EMP_DT_DECISION")
    private LocalDate empDtDecision;

    @Column(name = "EMP_NBRE_TRAVAILL", nullable = false) // Nom tronqué dans l'image
    private Long empNbreTravaill;

    @Column(name = "EMP_NAT_JURIDIQUE", length = 6)
    private String empNatJuridique;

    @Column(name = "EMP_RUE", length = 50)
    private String empRue;

    @Column(name = "EMP_LOCALITE", length = 50, nullable = false)
    private String empLocalite;

    @Column(name = "EMP_VILLE", length = 50, nullable = false)
    private String empVille;

    @Column(name = "EMP_CODE_POSTAL", length = 40)
    private String empCodePostal;

    @Column(name = "EMP_TELEPHONE", length = 20, nullable = false)
    private String empTelephone;

    @Column(name = "EMP_PAYS", length = 6)
    private String empPays;

    @Column(name = "EMP_PROVINCE", length = 6, nullable = false)
    private String empProvince;

    @Column(name = "EMP_COMMUNE", length = 6, nullable = false)
    private String empCommune;

    @Column(name = "EMP_AGENCE", length = 6)
    private String empAgence;

    @Column(name = "EMP_COLLINE", length = 6, nullable = false)
    private String empColline;

    @Column(name = "EMP_EMAIL", length = 20)
    private String empEmail;

    @Column(name = "EMP_FAX", length = 20)
    private String empFax;

    @Column(name = "EMP_CONTACTE", length = 100)
    private String empContacte;

    @Column(name = "EMP_QUALITE_C", length = 50)
    private String empQualiteC;

    @Column(name = "EMP_RUE_C", length = 50)
    private String empRueC;

    @Column(name = "EMP_LOCALITE_C", length = 50)
    private String empLocaliteC;

    // --- Section 2 ---

    @Column(name = "EMP_VILLE_C", length = 50)
    private String empVilleC;

    @Column(name = "EMP_PAYS_C", length = 6)
    private String empPaysC;

    @Column(name = "EMP_TELEPHONE_C", length = 20)
    private String empTelephoneC;

    @Column(name = "EMP_CODE_POSTAL_C", length = 40)
    private String empCodePostalC;

    @Column(name = "EMP_RUE_P", length = 50)
    private String empRueP;

    @Column(name = "EMP_VILLE_P", length = 50)
    private String empVilleP;

    @Column(name = "EMP_PAYS_P", length = 6)
    private String empPaysP;

    @Column(name = "EMP_FAX_P", length = 20)
    private String empFaxP;

    @Column(name = "EMP_FREQUENCE_PAIE", length = 6)
    private String empFrequencePaie;

    @Column(name = "EMP_DT_PREMIER_EM", nullable = false)
    private LocalDate empDtPremierEm;

    @Column(name = "EMP_ASSURANCE", length = 2, nullable = false)
    private String empAssurance;

    @Column(name = "EMP_ETAT", length = 1, nullable = false)
    private String empEtat;

    @Column(name = "EMP_CODE_FISCAL", length = 10, nullable = false)
    private String empCodeFiscal;

    @Column(name = "EMP_REG_COMMERCE", length = 20, nullable = false)
    private String empRegCommerce;

    @Column(name = "EMP_LOCALITE_P", length = 50)
    private String empLocaliteP;

    @Column(name = "EMP_TELEPHONE_P", length = 20)
    private String empTelephoneP;

    @Column(name = "EMP_CODE_POSTAL_P", length = 40)
    private String empCodePostalP;

    @Column(name = "EMP_EMAIL_P", length = 20)
    private String empEmailP;

    @Column(name = "EMP_DECISION", length = 1)
    private String empDecision;

    @Column(name = "EMP_RAISON", length = 6)
    private String empRaison;

    @Column(name = "EMP_DT_CREEE", nullable = false)
    private LocalDateTime empDtCreee; // Utilisation de LocalDateTime car "Heure" est mentionnée dans le commentaire

    @Column(name = "EMP_UTIL_CREEE", length = 15, nullable = false)
    private String empUtilCreee;

    @Column(name = "EMP_DT_MODIFIEE")
    private LocalDateTime empDtModifiee;

    @Column(name = "EMP_UTIL_MODIFIE", length = 15)
    private String empUtilModifie;

    @Column(name = "EMP_OLD_AFFILIATION")
    private Long empOldAffiliation;

    @Column(name = "EMP_IMPRESSION_PR", length = 1) // Nom tronqué
    private String empImpressionPr;

    @Column(name = "EMP_COMPTE", length = 20)
    private String empCompte;

    @Column(name = "EMP_BANQUE", length = 300)
    private String empBanque;

    @Column(name = "EMP_MONTANT_ARIE") // Nom tronqué
    private BigDecimal empMontantArie; // BigDecimal est plus sûr pour les montants monétaires

    // --- Section 3 ---

    @Column(name = "EMP_MONTANT_PAYE")
    private BigDecimal empMontantPaye;

    @Column(name = "EMP_MONTANT_REST") // Nom tronqué
    private BigDecimal empMontantRest;

    @Column(name = "EMP_BANQUE_ARIERES", length = 300)
    private String empBanqueArieres;

    @Column(name = "EMP_DATE_PAIEMENT")
    private LocalDate empDatePaiement;

    
    
    

	public Long getEmpSequence() {
		return empSequence;
	}

	public void setEmpSequence(Long empSequence) {
		this.empSequence = empSequence;
	}

	public Long getEmpAffiliation() {
		return empAffiliation;
	}

	public void setEmpAffiliation(Long empAffiliation) {
		this.empAffiliation = empAffiliation;
	}

	public String getEmpNom() {
		return empNom;
	}

	public void setEmpNom(String empNom) {
		this.empNom = empNom;
	}

	public String getEmpPrenom() {
		return empPrenom;
	}

	public void setEmpPrenom(String empPrenom) {
		this.empPrenom = empPrenom;
	}

	public String getEmpAbrev() {
		return empAbrev;
	}

	public void setEmpAbrev(String empAbrev) {
		this.empAbrev = empAbrev;
	}

	public LocalDate getEmpDtCreeEntr() {
		return empDtCreeEntr;
	}

	public void setEmpDtCreeEntr(LocalDate empDtCreeEntr) {
		this.empDtCreeEntr = empDtCreeEntr;
	}

	public LocalDate getEmpDtNaissance() {
		return empDtNaissance;
	}

	public void setEmpDtNaissance(LocalDate empDtNaissance) {
		this.empDtNaissance = empDtNaissance;
	}

	public LocalDate getEmpDtDemande() {
		return empDtDemande;
	}

	public void setEmpDtDemande(LocalDate empDtDemande) {
		this.empDtDemande = empDtDemande;
	}

	public String getEmpIndExempte() {
		return empIndExempte;
	}

	public void setEmpIndExempte(String empIndExempte) {
		this.empIndExempte = empIndExempte;
	}

	public LocalDate getEmpDtReception() {
		return empDtReception;
	}

	public void setEmpDtReception(LocalDate empDtReception) {
		this.empDtReception = empDtReception;
	}

	public Long getEmpAffilPrecedent() {
		return empAffilPrecedent;
	}

	public void setEmpAffilPrecedent(Long empAffilPrecedent) {
		this.empAffilPrecedent = empAffilPrecedent;
	}

	public LocalDate getEmpDtEffet() {
		return empDtEffet;
	}

	public void setEmpDtEffet(LocalDate empDtEffet) {
		this.empDtEffet = empDtEffet;
	}

	public LocalDate getEmpDtDecision() {
		return empDtDecision;
	}

	public void setEmpDtDecision(LocalDate empDtDecision) {
		this.empDtDecision = empDtDecision;
	}

	public Long getEmpNbreTravaill() {
		return empNbreTravaill;
	}

	public void setEmpNbreTravaill(Long empNbreTravaill) {
		this.empNbreTravaill = empNbreTravaill;
	}

	public String getEmpNatJuridique() {
		return empNatJuridique;
	}

	public void setEmpNatJuridique(String empNatJuridique) {
		this.empNatJuridique = empNatJuridique;
	}

	public String getEmpRue() {
		return empRue;
	}

	public void setEmpRue(String empRue) {
		this.empRue = empRue;
	}

	public String getEmpLocalite() {
		return empLocalite;
	}

	public void setEmpLocalite(String empLocalite) {
		this.empLocalite = empLocalite;
	}

	public String getEmpVille() {
		return empVille;
	}

	public void setEmpVille(String empVille) {
		this.empVille = empVille;
	}

	public String getEmpCodePostal() {
		return empCodePostal;
	}

	public void setEmpCodePostal(String empCodePostal) {
		this.empCodePostal = empCodePostal;
	}

	public String getEmpTelephone() {
		return empTelephone;
	}

	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}

	public String getEmpPays() {
		return empPays;
	}

	public void setEmpPays(String empPays) {
		this.empPays = empPays;
	}

	public String getEmpProvince() {
		return empProvince;
	}

	public void setEmpProvince(String empProvince) {
		this.empProvince = empProvince;
	}

	public String getEmpCommune() {
		return empCommune;
	}

	public void setEmpCommune(String empCommune) {
		this.empCommune = empCommune;
	}

	public String getEmpAgence() {
		return empAgence;
	}

	public void setEmpAgence(String empAgence) {
		this.empAgence = empAgence;
	}

	public String getEmpColline() {
		return empColline;
	}

	public void setEmpColline(String empColline) {
		this.empColline = empColline;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getEmpFax() {
		return empFax;
	}

	public void setEmpFax(String empFax) {
		this.empFax = empFax;
	}

	public String getEmpContacte() {
		return empContacte;
	}

	public void setEmpContacte(String empContacte) {
		this.empContacte = empContacte;
	}

	public String getEmpQualiteC() {
		return empQualiteC;
	}

	public void setEmpQualiteC(String empQualiteC) {
		this.empQualiteC = empQualiteC;
	}

	public String getEmpRueC() {
		return empRueC;
	}

	public void setEmpRueC(String empRueC) {
		this.empRueC = empRueC;
	}

	public String getEmpLocaliteC() {
		return empLocaliteC;
	}

	public void setEmpLocaliteC(String empLocaliteC) {
		this.empLocaliteC = empLocaliteC;
	}

	public String getEmpVilleC() {
		return empVilleC;
	}

	public void setEmpVilleC(String empVilleC) {
		this.empVilleC = empVilleC;
	}

	public String getEmpPaysC() {
		return empPaysC;
	}

	public void setEmpPaysC(String empPaysC) {
		this.empPaysC = empPaysC;
	}

	public String getEmpTelephoneC() {
		return empTelephoneC;
	}

	public void setEmpTelephoneC(String empTelephoneC) {
		this.empTelephoneC = empTelephoneC;
	}

	public String getEmpCodePostalC() {
		return empCodePostalC;
	}

	public void setEmpCodePostalC(String empCodePostalC) {
		this.empCodePostalC = empCodePostalC;
	}

	public String getEmpRueP() {
		return empRueP;
	}

	public void setEmpRueP(String empRueP) {
		this.empRueP = empRueP;
	}

	public String getEmpVilleP() {
		return empVilleP;
	}

	public void setEmpVilleP(String empVilleP) {
		this.empVilleP = empVilleP;
	}

	public String getEmpPaysP() {
		return empPaysP;
	}

	public void setEmpPaysP(String empPaysP) {
		this.empPaysP = empPaysP;
	}

	public String getEmpFaxP() {
		return empFaxP;
	}

	public void setEmpFaxP(String empFaxP) {
		this.empFaxP = empFaxP;
	}

	public String getEmpFrequencePaie() {
		return empFrequencePaie;
	}

	public void setEmpFrequencePaie(String empFrequencePaie) {
		this.empFrequencePaie = empFrequencePaie;
	}

	public LocalDate getEmpDtPremierEm() {
		return empDtPremierEm;
	}

	public void setEmpDtPremierEm(LocalDate empDtPremierEm) {
		this.empDtPremierEm = empDtPremierEm;
	}

	public String getEmpAssurance() {
		return empAssurance;
	}

	public void setEmpAssurance(String empAssurance) {
		this.empAssurance = empAssurance;
	}

	public String getEmpEtat() {
		return empEtat;
	}

	public void setEmpEtat(String empEtat) {
		this.empEtat = empEtat;
	}

	public String getEmpCodeFiscal() {
		return empCodeFiscal;
	}

	public void setEmpCodeFiscal(String empCodeFiscal) {
		this.empCodeFiscal = empCodeFiscal;
	}

	public String getEmpRegCommerce() {
		return empRegCommerce;
	}

	public void setEmpRegCommerce(String empRegCommerce) {
		this.empRegCommerce = empRegCommerce;
	}

	public String getEmpLocaliteP() {
		return empLocaliteP;
	}

	public void setEmpLocaliteP(String empLocaliteP) {
		this.empLocaliteP = empLocaliteP;
	}

	public String getEmpTelephoneP() {
		return empTelephoneP;
	}

	public void setEmpTelephoneP(String empTelephoneP) {
		this.empTelephoneP = empTelephoneP;
	}

	public String getEmpCodePostalP() {
		return empCodePostalP;
	}

	public void setEmpCodePostalP(String empCodePostalP) {
		this.empCodePostalP = empCodePostalP;
	}

	public String getEmpEmailP() {
		return empEmailP;
	}

	public void setEmpEmailP(String empEmailP) {
		this.empEmailP = empEmailP;
	}

	public String getEmpDecision() {
		return empDecision;
	}

	public void setEmpDecision(String empDecision) {
		this.empDecision = empDecision;
	}

	public String getEmpRaison() {
		return empRaison;
	}

	public void setEmpRaison(String empRaison) {
		this.empRaison = empRaison;
	}

	public LocalDateTime getEmpDtCreee() {
		return empDtCreee;
	}

	public void setEmpDtCreee(LocalDateTime empDtCreee) {
		this.empDtCreee = empDtCreee;
	}

	public String getEmpUtilCreee() {
		return empUtilCreee;
	}

	public void setEmpUtilCreee(String empUtilCreee) {
		this.empUtilCreee = empUtilCreee;
	}

	public LocalDateTime getEmpDtModifiee() {
		return empDtModifiee;
	}

	public void setEmpDtModifiee(LocalDateTime empDtModifiee) {
		this.empDtModifiee = empDtModifiee;
	}

	public String getEmpUtilModifie() {
		return empUtilModifie;
	}

	public void setEmpUtilModifie(String empUtilModifie) {
		this.empUtilModifie = empUtilModifie;
	}

	public Long getEmpOldAffiliation() {
		return empOldAffiliation;
	}

	public void setEmpOldAffiliation(Long empOldAffiliation) {
		this.empOldAffiliation = empOldAffiliation;
	}

	public String getEmpImpressionPr() {
		return empImpressionPr;
	}

	public void setEmpImpressionPr(String empImpressionPr) {
		this.empImpressionPr = empImpressionPr;
	}

	public String getEmpCompte() {
		return empCompte;
	}

	public void setEmpCompte(String empCompte) {
		this.empCompte = empCompte;
	}

	public String getEmpBanque() {
		return empBanque;
	}

	public void setEmpBanque(String empBanque) {
		this.empBanque = empBanque;
	}

	public BigDecimal getEmpMontantArie() {
		return empMontantArie;
	}

	public void setEmpMontantArie(BigDecimal empMontantArie) {
		this.empMontantArie = empMontantArie;
	}

	public BigDecimal getEmpMontantPaye() {
		return empMontantPaye;
	}

	public void setEmpMontantPaye(BigDecimal empMontantPaye) {
		this.empMontantPaye = empMontantPaye;
	}

	public BigDecimal getEmpMontantRest() {
		return empMontantRest;
	}

	public void setEmpMontantRest(BigDecimal empMontantRest) {
		this.empMontantRest = empMontantRest;
	}

	public String getEmpBanqueArieres() {
		return empBanqueArieres;
	}

	public void setEmpBanqueArieres(String empBanqueArieres) {
		this.empBanqueArieres = empBanqueArieres;
	}

	public LocalDate getEmpDatePaiement() {
		return empDatePaiement;
	}

	public void setEmpDatePaiement(LocalDate empDatePaiement) {
		this.empDatePaiement = empDatePaiement;
	}
    
    
    
}