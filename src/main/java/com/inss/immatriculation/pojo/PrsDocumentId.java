package com.inss.immatriculation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;
import java.util.Objects;

@Data
@Embeddable
public class PrsDocumentId implements Serializable {

    private static final long serialVersionUID = 1L;

	@Column(name = "doc_document", nullable = false, length = 6)
    private String docDocument;

    @Column(name = "doc_reference", nullable = false, length = 20)
    private String docReference;

    @Column(name = "doc_seq", nullable = false, precision = 6)
    private Long docSeq;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrsDocumentId that = (PrsDocumentId) o;
        return Objects.equals(docDocument, that.docDocument) &&
               Objects.equals(docReference, that.docReference) &&
               Objects.equals(docSeq, that.docSeq);
    }

    @Override
    public int hashCode() {
        return Objects.hash(docDocument, docReference, docSeq);
    }

	public String getDocDocument() {
		return docDocument;
	}

	public void setDocDocument(String docDocument) {
		this.docDocument = docDocument;
	}

	public String getDocReference() {
		return docReference;
	}

	public void setDocReference(String docReference) {
		this.docReference = docReference;
	}

	public Long getDocSeq() {
		return docSeq;
	}

	public void setDocSeq(Long docSeq) {
		this.docSeq = docSeq;
	}
    
    
}