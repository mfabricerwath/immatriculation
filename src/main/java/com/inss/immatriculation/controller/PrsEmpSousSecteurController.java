package com.inss.immatriculation.controller;

import com.inss.immatriculation.pojo.PrsEmpSecteurId;
import com.inss.immatriculation.pojo.PrsEmpSousSecteur;
import com.inss.immatriculation.pojo.PrsEmpSousSecteurId;
import com.inss.immatriculation.service.PrsEmpSousSecteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sous-secteurs")
public class PrsEmpSousSecteurController {

    private final PrsEmpSousSecteurService service;

    public PrsEmpSousSecteurController(PrsEmpSousSecteurService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrsEmpSousSecteur> getAll() {
        return service.findAll();
    }

    @GetMapping("/employeur/{empSequence}")
    public List<PrsEmpSousSecteur> getByEmployeur(@PathVariable Long empSequence) {
        return service.findByEmployeur(empSequence);
    }

    // Récupérer par la clé composite complète
    // URL: /api/sous-secteurs/{sousSecteur}/{secteur}/{empSequence}
    @GetMapping("/{sousSecteur}/{secteur}/{empSequence}")
    public ResponseEntity<PrsEmpSousSecteur> getById(
            @PathVariable String sousSecteur,
            @PathVariable String secteur,
            @PathVariable Long empSequence) {
        
        PrsEmpSecteurId secteurId = new PrsEmpSecteurId();
        secteurId.setEsecSecteur(secteur);
        secteurId.setEsecEmpSequence(empSequence);

        PrsEmpSousSecteurId id = new PrsEmpSousSecteurId();
        id.setEsseSousSecteur(sousSecteur);
        id.setSecteurId(secteurId);

        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PrsEmpSousSecteur create(@RequestBody PrsEmpSousSecteur sousSecteur) {
        return service.save(sousSecteur);
    }

    @PutMapping("/{sousSecteur}/{secteur}/{empSequence}")
    public ResponseEntity<PrsEmpSousSecteur> update(
            @PathVariable String sousSecteur,
            @PathVariable String secteur,
            @PathVariable Long empSequence,
            @RequestBody PrsEmpSousSecteur nouveau) {
        
        PrsEmpSecteurId secteurId = new PrsEmpSecteurId();
        secteurId.setEsecSecteur(secteur);
        secteurId.setEsecEmpSequence(empSequence);

        PrsEmpSousSecteurId id = new PrsEmpSousSecteurId();
        id.setEsseSousSecteur(sousSecteur);
        id.setSecteurId(secteurId);

        try {
            return ResponseEntity.ok(service.update(id, nouveau));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{sousSecteur}/{secteur}/{empSequence}")
    public ResponseEntity<Void> delete(
            @PathVariable String sousSecteur,
            @PathVariable String secteur,
            @PathVariable Long empSequence) {
        
        PrsEmpSecteurId secteurId = new PrsEmpSecteurId();
        secteurId.setEsecSecteur(secteur);
        secteurId.setEsecEmpSequence(empSequence);

        PrsEmpSousSecteurId id = new PrsEmpSousSecteurId();
        id.setEsseSousSecteur(sousSecteur);
        id.setSecteurId(secteurId);

        try {
            service.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}