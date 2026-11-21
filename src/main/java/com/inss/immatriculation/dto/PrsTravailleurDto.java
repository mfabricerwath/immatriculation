package com.inss.immatriculation.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class PrsTravailleurDto {
    private String trvImmatriculation;
    private String trvNom;
    private String trvPrenom;
    private String trvNomJeunefille;
    private String trvSexe;
    private LocalDate trvDtNaissance;
    private Integer trvAnNaissance;
    private String trvLieuNaissance;
    private String trvNationalite;
    private String trvEtatCivil;
    private String trvNomPere;
    private String trvNomMere;
    private String trvCni;
    private String trvPhoto;

    // Adresse Physique
    private String trvRue;
    private String trvLocalite;
    private String trvVille;
    private String trvProvince;
    private String trvCommune;
    private String trvColline;
    private String trvPays;
    private String trvCodePostal;
    private String trvTelephone;
    private String trvEmail;
    private String trvFax;

    // Adresse Postale
    private String trvRueP;
    private String trvLocaliteP;
    private String trvVilleP;
    private String trvPaysP;
    private String trvCodePostalP;
    private String trvTelephoneP;
    private String trvEmailP;
    private String trvFaxP;

    // Détails Pro
    private String trvCatProf;
    private String trvNiveauFormation;
    private BigDecimal trvSalaire;
    private String trvRepLegal;
    private String trvLivret;

    // Statut & Dates
    private String trvEtat;
    private LocalDate trvDtDemande;
    private LocalDate trvDtReception;
    private LocalDate trvDtAssurance;

    // Audit
    private LocalDateTime trvDtCreee;
    private String trvUtilCree;
    private LocalDateTime trvDtModifiee;
    private String trvUtilModifie;

    // 👇 LES LISTES IMBRIQUÉES (en DTO)
    private List<PrsRelationDto> relations;
    private List<PrsTrvServiceDto> services;
    
    
    
}