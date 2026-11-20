package com.inss.immatriculation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
	public String getEmpAbrev() {
		return empAbrev;
	}
	public void setEmpAbrev(String empAbrev) {
		this.empAbrev = empAbrev;
	}
	public String getEmpVille() {
		return empVille;
	}
	public void setEmpVille(String empVille) {
		this.empVille = empVille;
	}
	public String getEmpTelephone() {
		return empTelephone;
	}
	public void setEmpTelephone(String empTelephone) {
		this.empTelephone = empTelephone;
	}
	public String getEmpEtat() {
		return empEtat;
	}
	public void setEmpEtat(String empEtat) {
		this.empEtat = empEtat;
	}
    
    
    
}