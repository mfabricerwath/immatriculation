package com.inss.immatriculation.controller;

import com.inss.immatriculation.dto.PrsEmployeurDto;
import com.inss.immatriculation.pojo.PrsEmployeur;
import com.inss.immatriculation.service.PrsEmployeurService;
import org.springframework.http.HttpStatus;
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
        return employeurService.findAll(); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrsEmployeur> getById(@PathVariable Long id) {
        return employeurService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody PrsEmployeur employeur) {
        try {
            PrsEmployeur saved = employeurService.save(employeur);
            
            Map<String, Object> response = new HashMap<>();
            response.put("empSequence", saved.getEmpSequence());
            response.put("empAffiliation", saved.getEmpAffiliation());
            response.put("message", "Employeur créé avec succès");
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Erreur lors de la création : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PrsEmployeur employeur) {
        try {
            PrsEmployeur updated = employeurService.update(id, employeur);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Impossible de mettre à jour : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            employeurService.delete(id);
            Map<String, String> response = new HashMap<>();
            response.put("message", "Employeur supprimé avec succès");
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Impossible de supprimer : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
    
    // ==========================================
    // 2. CORRECTION DE LA RECHERCHE PAR AFFILIATION
    // ==========================================
    @GetMapping("/by-affiliation/{affiliation}")
    public ResponseEntity<?> getByAffiliation(@PathVariable Long affiliation) {
        // On suppose que le service renvoie un Optional ou null
        PrsEmployeurDto employeurDto = employeurService.findByAffiliation(affiliation);
        
        if (employeurDto != null) {
            return ResponseEntity.ok(employeurDto);
        } else {
            // Renvoyer une 404 propre pour que Angular puisse afficher "Aucun employeur trouvé"
            Map<String, String> error = new HashMap<>();
            error.put("message", "Aucun employeur trouvé avec l'affiliation : " + affiliation);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }
}