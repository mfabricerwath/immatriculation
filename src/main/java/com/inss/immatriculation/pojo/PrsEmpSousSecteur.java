package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_emp_sous_secteur")
public class PrsEmpSousSecteur {

    @EmbeddedId
    private PrsEmpSousSecteurId id;

    @Column(name = "esse_util_cree", nullable = false, length = 15)
    private String esseUtilCree;

    @Column(name = "esse_util_modifie", length = 15)
    private String esseUtilModifie;

    @Column(name = "esse_dt_modifiee")
    private LocalDateTime esseDtModifiee;

    @Column(name = "esse_dt_creee", nullable = false)
    private LocalDateTime esseDtCreee;

    // Relation vers le secteur parent (clé étrangère)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
        @JoinColumn(name = "esse_esec_secteur", referencedColumnName = "esec_secteur", insertable = false, updatable = false),
        @JoinColumn(name = "esse_esec_emp_sequence", referencedColumnName = "esec_emp_sequence", insertable = false, updatable = false)
    })
    private PrsEmpSecteur secteur;

	public PrsEmpSousSecteurId getId() {
		return id;
	}

	public void setId(PrsEmpSousSecteurId id) {
		this.id = id;
	}

	public String getEsseUtilCree() {
		return esseUtilCree;
	}

	public void setEsseUtilCree(String esseUtilCree) {
		this.esseUtilCree = esseUtilCree;
	}

	public String getEsseUtilModifie() {
		return esseUtilModifie;
	}

	public void setEsseUtilModifie(String esseUtilModifie) {
		this.esseUtilModifie = esseUtilModifie;
	}

	public LocalDateTime getEsseDtModifiee() {
		return esseDtModifiee;
	}

	public void setEsseDtModifiee(LocalDateTime esseDtModifiee) {
		this.esseDtModifiee = esseDtModifiee;
	}

	public LocalDateTime getEsseDtCreee() {
		return esseDtCreee;
	}

	public void setEsseDtCreee(LocalDateTime esseDtCreee) {
		this.esseDtCreee = esseDtCreee;
	}

	public PrsEmpSecteur getSecteur() {
		return secteur;
	}

	public void setSecteur(PrsEmpSecteur secteur) {
		this.secteur = secteur;
	}
    
    
}