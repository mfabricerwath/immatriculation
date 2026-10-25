package com.inss.immatriculation.pojo;


import java.io.Serializable;
import java.time.LocalDate;

import lombok.Data;

@Data
public class EmpActiviteId implements Serializable {

    private static final long serialVersionUID = 1L;
	private String eactActivite;
    private LocalDate eactDtDebut;
    private Long eactEmpSequence;

    public EmpActiviteId() {}

    public EmpActiviteId(String eactActivite, LocalDate eactDtDebut, Long eactEmpSequence) {
        this.eactActivite = eactActivite;
        this.eactDtDebut = eactDtDebut;
        this.eactEmpSequence = eactEmpSequence;
    }

    // equals / hashCode obligatoires
}