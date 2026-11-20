package com.inss.immatriculation.controller;

import com.inss.immatriculation.dto.PrsEmployeurDto;
import com.inss.immatriculation.pojo.PrsEmployeur;
import com.inss.immatriculation.service.PrsEmployeurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employeurs")
public class PrsEmployeurController {

    private final PrsEmployeurService employeurService;

    public PrsEmployeurController(PrsEmployeurService employeurService) {
        this.employeurService = employeurService;
    }

    @GetMapping
    public List<PrsEmployeur> getAll() {
        // Assurez-vous que findAll() existe dans votre service
        return employeurService.findAll(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrsEmployeur> getById(@PathVariable Long id) {
        // Assurez-vous que findById() renvoie un Optional ou gérez l'exception
        return employeurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PrsEmployeur employeur) {
        PrsEmployeur saved = employeurService.save(employeur);
        
        // On renvoie un objet JSON simple avec juste l'ID
        Map<String, Object> response = new HashMap<>();
        response.put("empSequence", saved.getEmpSequence());
        response.put("empAffiliation", saved.getEmpAffiliation());
        response.put("message", "Employeur créé avec succès");
        
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrsEmployeur> update(@PathVariable Long id, @RequestBody PrsEmployeur employeur) {
        try {
            // La méthode update() de votre service gère l'historique
            PrsEmployeur updated = employeurService.update(id, employeur);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        employeurService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/by-affiliation/{affiliation}")
    public ResponseEntity<PrsEmployeurDto> getByAffiliation(@PathVariable Long affiliation) {
        return ResponseEntity.ok(employeurService.findByAffiliation(affiliation));
    }
    
    
}