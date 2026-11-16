package com.inss.immatriculation.repository;

import com.inss.immatriculation.pojo.PrsDocument;
import com.inss.immatriculation.pojo.PrsDocumentId;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PrsDocumentRepository extends JpaRepository<PrsDocument, PrsDocumentId> {

    // Pour retrouver tous les documents d'un employeur via son numéro d'affiliation
    List<PrsDocument> findByDocAffiliation(Long docAffiliation);
    
    // Pour retrouver tous les documents liés à une référence donnée
    List<PrsDocument> findById_DocReference(String docReference);
    boolean existsByDocAffiliation(Long docAffiliation);
}