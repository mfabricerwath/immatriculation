package com.inss.immatriculation.pojo;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "PRS_DOCUMENT", schema = "PRESLIVE")
@IdClass(Document.class)
@Data

public class Document implements Serializable{


	    private static final long serialVersionUID = 1L;

		@Id
	    @Column(name = "DOC_DOCUMENT", length = 6, nullable = false)
	    private DocumentPk docDocument;

	    @Id
	    @Column(name = "DOC_REFERENCE", length = 20, nullable = false)
	    private String docReference;

	    @Id
	    @Column(name = "DOC_SEQ", precision = 6, nullable = false)
	    private Long docSeq;

	    @Column(name = "DOC_DT_DEPOT", nullable = false)
	    private LocalDateTime docDtDepot;

	    @Column(name = "DOC_NBRE_COPIES", precision = 2, nullable = false)
	    private Integer docNbreCopies;

	    @Column(name = "DOC_COMMENTAIRES", length = 200)
	    private String docCommentaires;

	    @Column(name = "DOC_DT_CREEE", nullable = false)
	    private LocalDateTime docDtCreee;

	    @Column(name = "DOC_UTIL_CREE", length = 15, nullable = false)
	    private String docUtilCree;

	    @Column(name = "DOC_DT_MODIFIEE")
	    private LocalDateTime docDtModifiee;

	    @Column(name = "DOC_UTIL_MODIFIE", length = 15)
	    private String docUtilModifie;

	    @Column(name = "DOC_AFFILIATION", precision = 10)
	    private Long docAffiliation;

	    // --- Cycle de vie : audit auto ---
	    @PrePersist
	    public void prePersist() {
	        LocalDateTime now = LocalDateTime.now();
	        if (docDtCreee == null) docDtCreee = now;
	        if (docDtDepot == null) docDtDepot = now;
	    }

	    @PreUpdate
	    public void preUpdate() {
	        docDtModifiee = LocalDateTime.now();
	    }
}
	

