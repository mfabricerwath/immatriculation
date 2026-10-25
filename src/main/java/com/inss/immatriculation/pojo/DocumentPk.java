package com.inss.immatriculation.pojo;


import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class DocumentPk implements Serializable{


	    private static final long serialVersionUID = 1L;
		private String document;      // DOC_DOCUMENT
	    private String reference;     // DOC_REFERENCE
	    private Long seq;             // DOC_SEQ

	    // Constructeur par défaut (obligatoire)
	    public DocumentPk() {}

	    public DocumentPk(String document, String reference, Long seq) {
	        this.document = document;
	        this.reference = reference;
	        this.seq = seq;
	    }

	   

	    // equals() et hashCode() OBLIGATOIRES pour une clé composite
	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        DocumentPk that = (DocumentPk) o;
	        return Objects.equals(document, that.document) &&
	               Objects.equals(reference, that.reference) &&
	               Objects.equals(seq, that.seq);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(document, reference, seq);
	    }
	}

