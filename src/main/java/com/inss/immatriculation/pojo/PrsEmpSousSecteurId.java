package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PrsEmpSousSecteurId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "esse_sous_secteur", nullable = false, length = 6)
    private String esseSousSecteur;

    // On inclut la clé composite de la table parente (PRS_EMP_SECTEUR)
    @Embedded
    private PrsEmpSecteurId secteurId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsEmpSousSecteurId that = (PrsEmpSousSecteurId) o;
        return Objects.equals(esseSousSecteur, that.esseSousSecteur) &&
               Objects.equals(secteurId, that.secteurId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esseSousSecteur, secteurId);
    }


    
}