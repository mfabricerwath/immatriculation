package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Embeddable
public class PrsEmpActiviteId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "eact_activite", nullable = false, length = 6)
    private String eactActivite;

    @Column(name = "eact_dt_debut", nullable = false)
    private LocalDate eactDtDebut;

    @Column(name = "eact_emp_sequence", nullable = false, precision = 10)
    private Long eactEmpSequence;

    // Lombok @Data génère les getters/setters et equals/hashCode.
    // Cependant, il est recommandé d'écrire equals/hashCode manuellement pour les clés composites.
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsEmpActiviteId that = (PrsEmpActiviteId) o;
        return Objects.equals(eactActivite, that.eactActivite) &&
               Objects.equals(eactDtDebut, that.eactDtDebut) &&
               Objects.equals(eactEmpSequence, that.eactEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eactActivite, eactDtDebut, eactEmpSequence);
    }
}