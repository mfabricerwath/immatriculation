package com.inss.immatriculation.controller;

import com.inss.immatriculation.pojo.PrsDocument;
import com.inss.immatriculation.pojo.PrsDocumentId;
import com.inss.immatriculation.service.PrsDocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
public class PrsDocumentController {

    private final PrsDocumentService service;

    public PrsDocumentController(PrsDocumentService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrsDocument> getAll() {
        return service.findAll();
    }

    @GetMapping("/affiliation/{affiliation}")
    public List<PrsDocument> getByAffiliation(@PathVariable Long affiliation) {
        return service.findByAffiliation(affiliation);
    }

    // Récupérer par la clé composite complète
    // URL: /api/documents/{document}/{reference}/{seq}
    @GetMapping("/{document}/{reference}/{seq}")
    public ResponseEntity<PrsDocument> getById(
            @PathVariable String document,
            @PathVariable String reference,
            @PathVariable Long seq) {
        
        PrsDocumentId id = new PrsDocumentId();
        id.setDocDocument(document);
        id.setDocReference(reference);
        id.setDocSeq(seq);

        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PrsDocument create(@RequestBody PrsDocument doc) {
        return service.save(doc);
    }

    @PutMapping("/{document}/{reference}/{seq}")
    public ResponseEntity<PrsDocument> update(
            @PathVariable String document,
            @PathVariable String reference,
            @PathVariable Long seq,
            @RequestBody PrsDocument nouveau) {
        
        PrsDocumentId id = new PrsDocumentId();
        id.setDocDocument(document);
        id.setDocReference(reference);
        id.setDocSeq(seq);

        try {
            return ResponseEntity.ok(service.update(id, nouveau));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{document}/{reference}/{seq}")
    public ResponseEntity<Void> delete(
            @PathVariable String document,
            @PathVariable String reference,
            @PathVariable Long seq) {
        
        PrsDocumentId id = new PrsDocumentId();
        id.setDocDocument(document);
        id.setDocReference(reference);
        id.setDocSeq(seq);

        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}