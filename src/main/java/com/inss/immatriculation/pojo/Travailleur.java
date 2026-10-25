package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "PRS_TRAVAILLEUR")
public class Travailleur {

    @Id
    @Column(name = "TRV_IMMATRICULATION", length = 10, nullable = false)
    private String immatriculation;

    @Column(name = "TRV_PAYS_P", length = 6)
    private String paysPostale;

    @Column(name = "TRV_CODE_POSTAL", length = 10)
    private String codePostal;

    @Column(name = "TRV_CAT_PROF", length = 6)
    private String categorieProfessionnelle;

    @Column(name = "TRV_UTIL_MODIFIE", length = 15)
    private String utilisateurModifie;

    @Column(name = "TRV_DT_MODIFIEE")
    private Date dateModifiee;

    @Column(name = "TRV_UTIL_CREE", length = 15, nullable = false)
    private String utilisateurCree;

    @Column(name = "TRV_NOM_JEUNEFILLE", length = 50)
    private String nomJeuneFille;

    @Column(name = "TRV_REP_LEGAL", length = 50)
    private String representantLegal;

    @Column(name = "TRV_RUE", length = 50)
    private String rue;

    // ... (ajoutez toutes les autres colonnes de la même manière)

    @Column(name = "TRV_NOM", length = 100, nullable = false)
    private String nom;

    @Column(name = "TRV_PRENOM", length = 50)
    private String prenom;

    
    @Column(name = "TRV_DT_NAISSANCE")
    private Date dateNaissance;

    @Column(name = "TRV_SEXE", length = 1, nullable = false)
    private String sexe;

    @Column(name = "TRV_SALAIRE")
    private BigDecimal salaire;

}