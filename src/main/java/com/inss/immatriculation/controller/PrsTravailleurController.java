package com.inss.immatriculation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inss.immatriculation.mapper.TravailleurMapper;
import com.inss.immatriculation.pojo.PrsTravailleur;
import com.inss.immatriculation.service.PrsTravailleurService;

@RestController
@RequestMapping("/api/travailleurs")
public class PrsTravailleurController {

    private final PrsTravailleurService travailleurService;
    private final TravailleurMapper mapper;

    // UN SEUL CONSTRUCTEUR (supprimez l'autre)
    public PrsTravailleurController(PrsTravailleurService travailleurService, TravailleurMapper mapper) {
        this.travailleurService = travailleurService;
        this.mapper = mapper;
    }

    // ==========================================
    // 1. LIRE TOUS LES TRAVAILLEURS (GET)
    // ==========================================
    @GetMapping
    public ResponseEntity<List<PrsTravailleur>> getAll() {
        List<PrsTravailleur> travailleurs = travailleurService.findAll();
        return ResponseEntity.ok(travailleurs);
    }

    // ==========================================
    // 2. LIRE UN TRAVAILLEUR PAR IMMATRICULATION (GET)
    // ==========================================
    @GetMapping("/{immatriculation}")
    public ResponseEntity<?> getById(@PathVariable String immatriculation) {
        return travailleurService.findEntityById(immatriculation)
                .map(entity -> ResponseEntity.ok(mapper.toDto(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    // ==========================================
    // 3. CRÉER UN TRAVAILLEUR (POST)
    // ==========================================
    @PostMapping
    public ResponseEntity<?> create(@RequestBody PrsTravailleur travailleur) {
        try {
            PrsTravailleur saved = travailleurService.save(travailleur);
            
            Map<String, Object> response = new HashMap<>();
            response.put("trvImmatriculation", saved.getTrvImmatriculation());
            response.put("message", "Travailleur immatriculé avec succès");
            
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Erreur lors de la création : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
        }
    }

    // ==========================================
    // 4. METTRE À JOUR UN TRAVAILLEUR (PUT)
    // ==========================================
    @PutMapping("/{immatriculation}")
    public ResponseEntity<?> update(@PathVariable String immatriculation, @RequestBody PrsTravailleur travailleur) {
        try {
            travailleur.setTrvImmatriculation(immatriculation);
            
            PrsTravailleur updated = travailleurService.update(immatriculation, travailleur);
            
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Travailleur mis à jour avec succès");
            response.put("travailleur", mapper.toDto(updated)); // On utilise le mapper ici aussi
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Impossible de mettre à jour : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    // ==========================================
    // 5. SUPPRIMER UN TRAVAILLEUR (DELETE)
    // ==========================================
    @DeleteMapping("/{immatriculation}")
    public ResponseEntity<?> delete(@PathVariable String immatriculation) {
        try {
            travailleurService.delete(immatriculation);
            
            Map<String, String> response = new HashMap<>();
            response.put("message", "Travailleur supprimé avec succès");
            
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            Map<String, String> error = new HashMap<>();
            error.put("message", "Impossible de supprimer : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
    }
}