package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PRS_EMPLOYEUR") // Remplacez par le nom réel de votre table si différent
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PrsEmployeur {

    // --- Section 1 ---

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
    @SequenceGenerator(name = "emp_seq", sequenceName = "seq_prs_employeur", allocationSize = 1) // Assurez-vous que le nom correspond
    @Column(name = "EMP_SEQUENCE", nullable = false)
    
    private Long empSequence;

    @Column(name = "EMP_AFFILIATION")
    private Long empAffiliation;

    @Column(name = "EMP_NOM", length = 300, nullable = false)
    private String empNom;

    @Column(name = "EMP_PRENOM", length = 250)
    private String empPrenom;

    @Column(name = "EMP_ABREV", length = 100, nullable=false)
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

    @Column(name = "EMP_NAT_JURIDIQUE", length = 100)
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

    @Column(name = "EMP_PAYS", length = 50)
    private String empPays;

    @Column(name = "EMP_PROVINCE", length = 50, nullable = false)
    private String empProvince;

    @Column(name = "EMP_COMMUNE", length = 50, nullable = false)
    private String empCommune;

    @Column(name = "EMP_AGENCE", length = 50)
    private String empAgence;

    @Column(name = "EMP_COLLINE", length = 50, nullable = false)
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

    @Column(name = "EMP_PAYS_C", length = 20)
    private String empPaysC;

    @Column(name = "EMP_TELEPHONE_C", length = 20)
    private String empTelephoneC;

    @Column(name = "EMP_CODE_POSTAL_C", length = 40)
    private String empCodePostalC;

    @Column(name = "EMP_RUE_P", length = 50)
    private String empRueP;

    @Column(name = "EMP_VILLE_P", length = 50)
    private String empVilleP;

    @Column(name = "EMP_PAYS_P", length = 20)
    private String empPaysP;

    @Column(name = "EMP_FAX_P", length = 20)
    private String empFaxP;

    @Column(name = "EMP_FREQUENCE_PAIE", length = 20)
    private String empFrequencePaie;

    @Column(name = "EMP_DT_PREMIER_EM", nullable = false)
    private LocalDate empDtPremierEm;

    @Column(name = "EMP_ASSURANCE", length = 20, nullable = false)
    private String empAssurance;

    @Column(name = "EMP_ETAT", length = 10, nullable = false)
    private String empEtat;

    @Column(name = "EMP_CODE_FISCAL", length = 20, nullable = false)
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

    @Column(name = "EMP_DECISION", length = 20)
    private String empDecision;

    @Column(name = "EMP_RAISON", length = 20)
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

    @Column(name = "EMP_IMPRESSION_PR", length = 10) // Nom tronqué
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

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrsEmpActivite> activites = new ArrayList<>();

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrsEmpSecteur> secteurs = new ArrayList<>();

   // @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, orphanRemoval = true)
   // private List<PrsEmpSousSecteur> sousSecteurs = new ArrayList<>();

    @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PrsEmpSituation> situations = new ArrayList<>();

	/*
	 * @OneToMany(mappedBy = "employeur", cascade = CascadeType.ALL, orphanRemoval =
	 * true) private List<PrsDocument> documents = new ArrayList<>();
	 */
    // Getters et Setters pour ces listes...
    
    

	
    
}