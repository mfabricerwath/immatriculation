package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class PrsEmpSituationId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "esit_operation", nullable = false, length = 6)
    private String esitOperation;

    @Column(name = "esit_dt_lettre", nullable = false)
    private LocalDate esitDtLettre;

    @Column(name = "esit_emp_sequence", nullable = false, precision = 10)
    private Long esitEmpSequence;

    public PrsEmpSituationId() {}

    public PrsEmpSituationId(String esitOperation, LocalDate esitDtLettre, Long esitEmpSequence) {
        this.esitOperation = esitOperation;
        this.esitDtLettre = esitDtLettre;
        this.esitEmpSequence = esitEmpSequence;
    }

    // getters / setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PrsEmpSituationId)) return false;
        PrsEmpSituationId that = (PrsEmpSituationId) o;
        return Objects.equals(esitOperation, that.esitOperation)
            && Objects.equals(esitDtLettre, that.esitDtLettre)
            && Objects.equals(esitEmpSequence, that.esitEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(esitOperation, esitDtLettre, esitEmpSequence);
    }
}