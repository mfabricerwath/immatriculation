package com.inss.immatriculation.service;

import com.inss.immatriculation.pojo.PrsDocument;
import com.inss.immatriculation.pojo.PrsDocumentId;
import com.inss.immatriculation.repository.PrsDocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PrsDocumentService {

    private final PrsDocumentRepository documentRepository;

    public PrsDocumentService(PrsDocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public List<PrsDocument> findAll() {
        return documentRepository.findAll();
    }

    public Optional<PrsDocument> findById(PrsDocumentId id) {
        return documentRepository.findById(id);
    }

    public List<PrsDocument> findByAffiliation(Long affiliation) {
        return documentRepository.findByDocAffiliation(affiliation);
    }

    @Transactional
    public PrsDocument save(PrsDocument document) {
        if (document.getDocDtCreee() == null) {
            document.setDocDtCreee(LocalDateTime.now());
            document.setDocUtilCree("admin"); // À remplacer par l'utilisateur connecté
        }
        return documentRepository.save(document);
    }

    @Transactional
    public PrsDocument update(PrsDocumentId id, PrsDocument nouveau) {
        return documentRepository.findById(id)
                .map(ancien -> {
                    // On ne modifie pas la clé primaire
                    ancien.setDocDtDepot(nouveau.getDocDtDepot());
                    ancien.setDocNbreCopies(nouveau.getDocNbreCopies());
                    ancien.setDocCommentaires(nouveau.getDocCommentaires());
                    ancien.setDocAffiliation(nouveau.getDocAffiliation());
                    
                    // Traçabilité
                    ancien.setDocDtModifiee(LocalDateTime.now());
                    ancien.setDocUtilModifie(nouveau.getDocUtilModifie()); // ou utilisateur connecté
                    
                    return documentRepository.save(ancien);
                })
                .orElseThrow(() -> new RuntimeException("Document introuvable"));
    }

    @Transactional
    public void delete(PrsDocumentId id) {
        documentRepository.deleteById(id);
    }
}