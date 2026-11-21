package com.inss.immatriculation.pojo;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prs_emp_historique")
@Data
public class PrsEmpHistorique {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_hist")
    @SequenceGenerator(name = "seq_hist", sequenceName = "seq_prs_emp_hist", allocationSize = 1)
    @Column(name = "ehis_sequence", nullable = false, precision = 10)
    private Long ehisSequence;

    @Column(name = "ehis_libelle", length = 50)
    private String ehisLibelle;

    @Column(name = "ehis_emp_sequence", precision = 10)
    private Long ehisEmpSequence;

    @Column(name = "ehis_valeur_avant", length = 400)
    private String ehisValeurAvant;

    @Column(name = "ehis_valeur_apres", length = 400)
    private String ehisValeurApres;

    @Column(name = "ehis_dt_creee")
    private LocalDate ehisDtCreee;

    @Column(name = "ehis_util_cree", length = 30)
    private String ehisUtilCree;

    @Column(name = "ehis_affiliation", precision = 10)
    private Long ehisAffiliation;

	
    
}