package com.inss.immatriculation.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class PrsRelationDto {
    private String relCode;
    private String relNom;
    private String relPrenom;
    private LocalDate relDtNaissance;
    private Integer relAnNaissance;
    private String relSexe;
    private String relEtat;
    
    
}