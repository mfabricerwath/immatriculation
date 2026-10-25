package com.inss.immatriculation.pojo;


import java.io.Serializable;
import java.util.Objects;

public class EmpSecteurId implements Serializable {

    private static final long serialVersionUID = 1L;
	private String esecSecteur;
    private Long esecEmpSequence;

    public EmpSecteurId() {}

    public EmpSecteurId(String esecSecteur, Long esecEmpSequence) {
        this.esecSecteur = esecSecteur;
        this.esecEmpSequence = esecEmpSequence;
    }

    public String getEsecSecteur() { return esecSecteur; }
    public void setEsecSecteur(String esecSecteur) { this.esecSecteur = esecSecteur; }

    public Long getEsecEmpSequence() { return esecEmpSequence; }
    public void setEsecEmpSequence(Long esecEmpSequence) { this.esecEmpSequence = esecEmpSequence; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpSecteurId)) return false;
        EmpSecteurId that = (EmpSecteurId) o;
        return Objects.equals(esecSecteur, that.esecSecteur)
            && Objects.equals(esecEmpSequence, that.esecEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esecSecteur, esecEmpSequence);
    }
}