package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PrsEmpSecteurId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "esec_secteur", nullable = false, length = 20)
    private String esecSecteur;

    @Column(name = "esec_emp_sequence", nullable = false, precision = 20)
    private Long esecEmpSequence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsEmpSecteurId that = (PrsEmpSecteurId) o;
        return Objects.equals(esecSecteur, that.esecSecteur) &&
               Objects.equals(esecEmpSequence, that.esecEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esecSecteur, esecEmpSequence);
    }

	public String getEsecSecteur() {
		return esecSecteur;
	}

	public void setEsecSecteur(String esecSecteur) {
		this.esecSecteur = esecSecteur;
	}

	public Long getEsecEmpSequence() {
		return esecEmpSequence;
	}

	public void setEsecEmpSequence(Long esecEmpSequence) {
		this.esecEmpSequence = esecEmpSequence;
	}
    
    
}