package com.inss.immatriculation.pojo;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PRS_EMP_SECTEUR")
public class EmpSecteur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Nonnull
    @Size(max = 6)
    @Column(name = "ESEC_SECTEUR", length = 6, nullable = false)
    private String EmpSecteurId;

    @Id
    @Nonnull
    @Column(name = "ESEC_EMP_SEQUENCE", nullable = false)
    private Long esecEmpSequence;

    @Column(name = "ESEC_AFFILIATION")
    private Long esecAffiliation;

   
    @Column(name = "ESEC_DT_MODIFIEE")
    private Date esecDtModifiee;

    @Nonnull
    @Column(name = "ESEC_DT_CREEE", nullable = false)
    private Date esecDtCreee;

    @Size(max = 15)
    @Column(name = "ESEC_UTIL_MODIFIE", length = 15)
    private String esecUtilModifie;

    @Nonnull
    @Size(max = 15)
    @Column(name = "ESEC_UTIL_CREE", length = 15, nullable = false)
    private String esecUtilCree;

    // ===== Cycle de vie =====

    @PrePersist
    public void prePersist() {
        if (this.esecDtCreee == null) {
            this.esecDtCreee = new Date();
        }
    }

    @PreUpdate
    public void preUpdate() {
        this.esecDtModifiee = new Date();
    }

    // ===== equals / hashCode (clé composite) =====

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmpSecteur)) return false;
        EmpSecteur that = (EmpSecteur) o;
        return Objects.equals(EmpSecteurId, that.EmpSecteurId)
            && Objects.equals(esecEmpSequence, that.esecEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EmpSecteurId, esecEmpSequence);
    }
}