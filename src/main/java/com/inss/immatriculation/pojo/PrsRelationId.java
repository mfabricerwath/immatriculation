package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PrsRelationId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "rel_code", nullable = false, length = 6)
    private String relCode;

    @Column(name = "rel_trv_immatriculation", nullable = false, length = 10)
    private String relTrvImmatriculation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsRelationId that = (PrsRelationId) o;
        return Objects.equals(relCode, that.relCode) &&
               Objects.equals(relTrvImmatriculation, that.relTrvImmatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(relCode, relTrvImmatriculation);
    }

	public String getRelCode() {
		return relCode;
	}

	public void setRelCode(String relCode) {
		this.relCode = relCode;
	}

	public String getRelTrvImmatriculation() {
		return relTrvImmatriculation;
	}

	public void setRelTrvImmatriculation(String relTrvImmatriculation) {
		this.relTrvImmatriculation = relTrvImmatriculation;
	}
    
    
}