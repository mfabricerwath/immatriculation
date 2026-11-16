package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_emp_secteur")
public class PrsEmpSecteur {

    @EmbeddedId
    private PrsEmpSecteurId id;

    @Column(name = "esec_affiliation", precision = 20)
    private Long esecAffiliation;

    @Column(name = "esec_dt_modifiee")
    private LocalDateTime esecDtModifiee;

    @Column(name = "esec_dt_creee", nullable = false)
    private LocalDateTime esecDtCreee;

    @Column(name = "esec_util_modifie", length = 25)
    private String esecUtilModifie;

    @Column(name = "esec_util_cree", nullable = false, length = 25)
    private String esecUtilCree;

    // Relation vers l'employeur (clé étrangère dans le trigger d'audit, et logique métier)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "esec_emp_sequence", 
                referencedColumnName = "emp_sequence",
                insertable = false, updatable = false)
    private PrsEmployeur employeur;
    
    
    // --- MÉTHODES DÉLÉGUÉES POUR ANGULAR ---

    public String getEsecSecteur() {
        return id != null ? id.getEsecSecteur() : null;
    }

    public void setEsecSecteur(String esecSecteur) {
        if (id == null) {
            id = new PrsEmpSecteurId();
        }
        id.setEsecSecteur(esecSecteur);
    }

    public Long getEsecEmpSequence() {
        return id != null ? id.getEsecEmpSequence() : null;
    }

    public void setEsecEmpSequence(Long esecEmpSequence) {
        if (id == null) {
            id = new PrsEmpSecteurId();
        }
        id.setEsecEmpSequence(esecEmpSequence);
    }
    
// -----fin delegation pour angular
    
	public PrsEmpSecteurId getId() {
		return id;
	}

	public void setId(PrsEmpSecteurId id) {
		this.id = id;
	}

	public Long getEsecAffiliation() {
		return esecAffiliation;
	}

	public void setEsecAffiliation(Long esecAffiliation) {
		this.esecAffiliation = esecAffiliation;
	}

	public LocalDateTime getEsecDtModifiee() {
		return esecDtModifiee;
	}

	public void setEsecDtModifiee(LocalDateTime esecDtModifiee) {
		this.esecDtModifiee = esecDtModifiee;
	}

	public LocalDateTime getEsecDtCreee() {
		return esecDtCreee;
	}

	public void setEsecDtCreee(LocalDateTime esecDtCreee) {
		this.esecDtCreee = esecDtCreee;
	}

	public String getEsecUtilModifie() {
		return esecUtilModifie;
	}

	public void setEsecUtilModifie(String esecUtilModifie) {
		this.esecUtilModifie = esecUtilModifie;
	}

	public String getEsecUtilCree() {
		return esecUtilCree;
	}

	public void setEsecUtilCree(String esecUtilCree) {
		this.esecUtilCree = esecUtilCree;
	}

	public PrsEmployeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(PrsEmployeur employeur) {
		this.employeur = employeur;
	}
    
    
}