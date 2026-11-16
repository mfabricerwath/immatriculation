package com.inss.immatriculation.controller;

import com.inss.immatriculation.pojo.PrsEmpSituation;
import com.inss.immatriculation.pojo.PrsEmpSituationId;
import com.inss.immatriculation.service.PrsEmpSituationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/situations")
public class PrsEmpSituationController {

    private final PrsEmpSituationService situationService;

    public PrsEmpSituationController(PrsEmpSituationService situationService) {
        this.situationService = situationService;
    }

    @GetMapping
    public List<PrsEmpSituation> getAll() {
        return situationService.findAll();
    }

    // Récupérer toutes les situations d'un employeur spécifique
    @GetMapping("/employeur/{empSequence}")
    public List<PrsEmpSituation> getByEmployeur(@PathVariable Long empSequence) {
        return situationService.findByEmployeur(empSequence);
    }

    // Récupérer une situation spécifique via sa clé composite
    @GetMapping("/{operation}/{dtLettre}/{empSequence}")
    public ResponseEntity<PrsEmpSituation> getById(
            @PathVariable String operation,
            @PathVariable String dtLettre, 
            @PathVariable Long empSequence) {
        try {
            PrsEmpSituationId id = new PrsEmpSituationId(
                    operation, 
                    LocalDate.parse(dtLettre), 
                    empSequence
            );
            
            // Utilisation de l'Optional renvoyé par le service
            return situationService.findById(id)
                    .map(ResponseEntity::ok) // Si présent, renvoie 200 OK avec l'objet
                    .orElse(ResponseEntity.notFound().build()); // Si absent, renvoie 404 Not Found
                    
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public PrsEmpSituation create(@RequestBody PrsEmpSituation situation) {
        // Le JSON doit contenir l'objet "id" avec les 3 champs
        return situationService.save(situation);
    }

    // Suppression via la clé composite passée dans l'URL
    @DeleteMapping("/{operation}/{dtLettre}/{empSequence}")
    public ResponseEntity<Void> delete(
            @PathVariable String operation,
            @PathVariable String dtLettre,
            @PathVariable Long empSequence) {
        try {
            PrsEmpSituationId id = new PrsEmpSituationId(
                    operation, 
                    LocalDate.parse(dtLettre), 
                    empSequence
            );
            situationService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}