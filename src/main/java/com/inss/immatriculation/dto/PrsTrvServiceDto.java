package com.inss.immatriculation.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class PrsTrvServiceDto {
    private LocalDate tserDtEmbauche;
    private Long tserEmpSequence;
    private BigDecimal tserSalaire;
    private Long tserAffiliation;
    private String tserTypeAss;
    private String tserEtat;
    private String tserMatricule;
    private String tserEmpNom; // Champ personnalisé pour l'affichage
    private LocalDate tserDtFin;
    
    
}