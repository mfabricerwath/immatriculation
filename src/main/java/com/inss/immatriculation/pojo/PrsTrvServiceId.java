package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Embeddable
public class PrsTrvServiceId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "tser_trv_immatriculation", nullable = false, length = 10)
    private String tserTrvImmatriculation;

    @Column(name = "tser_dt_embauche", nullable = false)
    private LocalDate tserDtEmbauche;

    @Column(name = "tser_emp_sequence", nullable = false, precision = 10)
    private Long tserEmpSequence;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsTrvServiceId that = (PrsTrvServiceId) o;
        return Objects.equals(tserTrvImmatriculation, that.tserTrvImmatriculation) &&
               Objects.equals(tserDtEmbauche, that.tserDtEmbauche) &&
               Objects.equals(tserEmpSequence, that.tserEmpSequence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tserTrvImmatriculation, tserDtEmbauche, tserEmpSequence);
    }

	public String getTserTrvImmatriculation() {
		return tserTrvImmatriculation;
	}

	public void setTserTrvImmatriculation(String tserTrvImmatriculation) {
		this.tserTrvImmatriculation = tserTrvImmatriculation;
	}

	public LocalDate getTserDtEmbauche() {
		return tserDtEmbauche;
	}

	public void setTserDtEmbauche(LocalDate tserDtEmbauche) {
		this.tserDtEmbauche = tserDtEmbauche;
	}

	public Long getTserEmpSequence() {
		return tserEmpSequence;
	}

	public void setTserEmpSequence(Long tserEmpSequence) {
		this.tserEmpSequence = tserEmpSequence;
	}
    
    
}