package com.inss.immatriculation.controller;

import com.inss.immatriculation.pojo.PrsEmpSecteur;
import com.inss.immatriculation.pojo.PrsEmpSecteurId;
import com.inss.immatriculation.service.PrsEmpSecteurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/secteurs")
public class PrsEmpSecteurController {

    private final PrsEmpSecteurService secteurService;

    public PrsEmpSecteurController(PrsEmpSecteurService secteurService) {
        this.secteurService = secteurService;
    }

    @GetMapping
    public List<PrsEmpSecteur> getAll() {
        return secteurService.findAll();
    }

    @GetMapping("/employeur/{empSequence}")
    public List<PrsEmpSecteur> getByEmployeur(@PathVariable Long empSequence) {
        return secteurService.findByEmployeur(empSequence);
    }

    @GetMapping("/{secteur}/{empSequence}")
    public ResponseEntity<PrsEmpSecteur> getById(
            @PathVariable String secteur, 
            @PathVariable Long empSequence) {
        
        PrsEmpSecteurId id = new PrsEmpSecteurId();
        id.setEsecSecteur(secteur);
        id.setEsecEmpSequence(empSequence);

        return secteurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PrsEmpSecteur create(@RequestBody PrsEmpSecteur secteur) {
        return secteurService.save(secteur);
    }

    @PutMapping("/{secteur}/{empSequence}")
    public ResponseEntity<PrsEmpSecteur> update(
            @PathVariable String secteur, 
            @PathVariable Long empSequence, 
            @RequestBody PrsEmpSecteur nouveau) {
        
        PrsEmpSecteurId id = new PrsEmpSecteurId();
        id.setEsecSecteur(secteur);
        id.setEsecEmpSequence(empSequence);

        try {
            return ResponseEntity.ok(secteurService.update(id, nouveau));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{secteur}/{empSequence}")
    public ResponseEntity<Void> delete(
            @PathVariable String secteur, 
            @PathVariable Long empSequence) {
        
        PrsEmpSecteurId id = new PrsEmpSecteurId();
        id.setEsecSecteur(secteur);
        id.setEsecEmpSequence(empSequence);

        try {
            secteurService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}