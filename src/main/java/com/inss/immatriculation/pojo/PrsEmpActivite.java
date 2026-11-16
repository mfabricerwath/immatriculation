package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_emp_activite")
public class PrsEmpActivite {

    @EmbeddedId
    private PrsEmpActiviteId id;

    @Column(name = "eact_util_modifie", length = 15)
    private String eactUtilModifie;

    @Column(name = "eact_dt_modifiee")
    private LocalDateTime eactDtModifiee;

    @Column(name = "eact_dt_creee", nullable = false)
    private LocalDateTime eactDtCreee;

    @Column(name = "eact_util_cree", nullable = false, length = 15)
    private String eactUtilCree;

    @Column(name = "eact_dt_fin")
    private LocalDate eactDtFin;

    @Column(name = "eact_affiliation", precision = 10)
    private Long eactAffiliation;

    // Relation vers PRS_EMPLOYEUR (clé étrangère eact_emp_sequence)
    // insertable = false, updatable = false car la colonne est déjà mappée dans la clé composite
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eact_emp_sequence", 
                referencedColumnName = "emp_sequence",
                insertable = false, updatable = false)
    private PrsEmployeur employeur;

    
    /*
     * pour angular
     */
    
    // --- MÉTHODES DÉLÉGUÉES POUR ANGULAR ---

    public String getEactActivite() {
        return id != null ? id.getEactActivite() : null;
    }

    public void setEactActivite(String eactActivite) {
        if (id == null) {
            id = new PrsEmpActiviteId();
        }
        id.setEactActivite(eactActivite);
    }

    public LocalDate getEactDtDebut() {
        return id != null ? id.getEactDtDebut() : null;
    }

    public void setEactDtDebut(LocalDate eactDtDebut) {
        if (id == null) {
            id = new PrsEmpActiviteId();
        }
        id.setEactDtDebut(eactDtDebut);
    }

    public Long getEactEmpSequence() {
        return id != null ? id.getEactEmpSequence() : null;
    }

    public void setEactEmpSequence(Long eactEmpSequence) {
        if (id == null) {
            id = new PrsEmpActiviteId();
        }
        id.setEactEmpSequence(eactEmpSequence);
    }
    
    
    /*****
     * 
     * @return
     */
    
	public PrsEmpActiviteId getId() {
		return id;
	}

	public void setId(PrsEmpActiviteId id) {
		this.id = id;
	}

	public String getEactUtilModifie() {
		return eactUtilModifie;
	}

	public void setEactUtilModifie(String eactUtilModifie) {
		this.eactUtilModifie = eactUtilModifie;
	}

	public LocalDateTime getEactDtModifiee() {
		return eactDtModifiee;
	}

	public void setEactDtModifiee(LocalDateTime eactDtModifiee) {
		this.eactDtModifiee = eactDtModifiee;
	}

	public LocalDateTime getEactDtCreee() {
		return eactDtCreee;
	}

	public void setEactDtCreee(LocalDateTime eactDtCreee) {
		this.eactDtCreee = eactDtCreee;
	}

	public String getEactUtilCree() {
		return eactUtilCree;
	}

	public void setEactUtilCree(String eactUtilCree) {
		this.eactUtilCree = eactUtilCree;
	}

	public LocalDate getEactDtFin() {
		return eactDtFin;
	}

	public void setEactDtFin(LocalDate eactDtFin) {
		this.eactDtFin = eactDtFin;
	}

	public Long getEactAffiliation() {
		return eactAffiliation;
	}

	public void setEactAffiliation(Long eactAffiliation) {
		this.eactAffiliation = eactAffiliation;
	}

	public PrsEmployeur getEmployeur() {
		return employeur;
	}

	public void setEmployeur(PrsEmployeur employeur) {
		this.employeur = employeur;
	}
    
    
}