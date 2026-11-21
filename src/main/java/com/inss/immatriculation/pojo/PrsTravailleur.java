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

    @Column(name = "trv_an_naissance", precision = 10, nullable = false)
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
    @Column(name = "trv_province", length = 20, nullable = false)
    private String trvProvince;
    @Column(name = "trv_commune", length = 20, nullable = false)
    private String trvCommune;
    @Column(name = "trv_colline", length = 20, nullable = false)
    private String trvColline;
    @Column(name = "trv_pays", length = 20)
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
    @Column(name = "trv_pays_p", length = 25)
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
    @Column(name = "trv_cat_prof", length = 20)
    private String trvCatProf;
    @Column(name = "trv_niveau_formation", length = 20)
    private String trvNiveauFormation;
    @Column(name = "trv_salaire", precision = 30)
    private BigDecimal trvSalaire;
    @Column(name = "trv_dt_embauche_temp", length = 50)
    private String trvDtEmbaucheTemp;
    @Column(name = "trv_dt_naissance_temp", length = 50)
    private String trvDtNaissanceTemp;
    @Column(name = "trv_rep_legal", length = 50)
    private String trvRepLegal;
    @Column(name = "trv_livret", length = 10)
    private String trvLivret;

    // --- Statut & Dates ---
    @Column(name = "trv_etat", length = 5, nullable = false)
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

    
    
    
    // Si vous avez créé l'entité pour PRS_TRV_DETAILS :
    // @OneToMany(mappedBy = "travailleur", cascade = CascadeType.ALL, orphanRemoval = true)
    // private List<PrsTrvDetails> details = new ArrayList<>();

    // --- Relations (seront complétées plus tard) ---
    // @ManyToOne
    // @JoinColumn(name = "trv_employeur_affiliation")
    // private PrsEmployeur employeur;
    
    
}