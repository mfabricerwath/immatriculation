package com.inss.immatriculation.pojo;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "prs_document")
public class PrsDocument {

    @EmbeddedId
    private PrsDocumentId id;

    @Column(name = "doc_dt_depot", nullable = false)
    private LocalDate docDtDepot;

    @Column(name = "doc_nbre_copies", nullable = false, precision = 2)
    private Integer docNbreCopies;

    @Column(name = "doc_commentaires", length = 200)
    private String docCommentaires;

    @Column(name = "doc_dt_creee", nullable = false)
    private LocalDateTime docDtCreee;

    @Column(name = "doc_util_cree", nullable = false, length = 15)
    private String docUtilCree;

    @Column(name = "doc_dt_modifiee")
    private LocalDateTime docDtModifiee;

    @Column(name = "doc_util_modifie", length = 15)
    private String docUtilModifie;

    @Column(name = "doc_affiliation", precision = 10)
    private Long docAffiliation;

    
    
    
    
    
	public PrsDocumentId getId() {
		return id;
	}

	public void setId(PrsDocumentId id) {
		this.id = id;
	}

	public LocalDate getDocDtDepot() {
		return docDtDepot;
	}

	public void setDocDtDepot(LocalDate docDtDepot) {
		this.docDtDepot = docDtDepot;
	}

	public Integer getDocNbreCopies() {
		return docNbreCopies;
	}

	public void setDocNbreCopies(Integer docNbreCopies) {
		this.docNbreCopies = docNbreCopies;
	}

	public String getDocCommentaires() {
		return docCommentaires;
	}

	public void setDocCommentaires(String docCommentaires) {
		this.docCommentaires = docCommentaires;
	}

	public LocalDateTime getDocDtCreee() {
		return docDtCreee;
	}

	public void setDocDtCreee(LocalDateTime docDtCreee) {
		this.docDtCreee = docDtCreee;
	}

	public String getDocUtilCree() {
		return docUtilCree;
	}

	public void setDocUtilCree(String docUtilCree) {
		this.docUtilCree = docUtilCree;
	}

	public LocalDateTime getDocDtModifiee() {
		return docDtModifiee;
	}

	public void setDocDtModifiee(LocalDateTime docDtModifiee) {
		this.docDtModifiee = docDtModifiee;
	}

	public String getDocUtilModifie() {
		return docUtilModifie;
	}

	public void setDocUtilModifie(String docUtilModifie) {
		this.docUtilModifie = docUtilModifie;
	}

	public Long getDocAffiliation() {
		return docAffiliation;
	}

	public void setDocAffiliation(Long docAffiliation) {
		this.docAffiliation = docAffiliation;
	}
    
    
    
}