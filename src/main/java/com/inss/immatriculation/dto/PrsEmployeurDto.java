package com.inss.immatriculation.dto;

import lombok.Data;

@Data

public class PrsEmployeurDto {
    private Long empSequence;
    private Long empAffiliation;
    private String empNom;
    private String empAbrev;
    private String empVille;
    private String empTelephone;
    private String empEtat;
    
    
	public PrsEmployeurDto() {
	
	}
	public PrsEmployeurDto(Long empSequence, Long empAffiliation, String empNom, String empAbrev, String empVille,
			String empTelephone, String empEtat) {
		this.empSequence = empSequence;
		this.empAffiliation = empAffiliation;
		this.empNom = empNom;
		this.empAbrev = empAbrev;
		this.empVille = empVille;
		this.empTelephone = empTelephone;
		this.empEtat = empEtat;
	}
	
	
}