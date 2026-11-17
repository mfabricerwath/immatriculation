package com.inss.immatriculation.controller;

import com.inss.immatriculation.pojo.PrsTravailleur;
import com.inss.immatriculation.service.PrsTravailleurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/travailleurs")
@CrossOrigin(origins = "http://localhost:4200")
public class PrsTravailleurController {

    private final PrsTravailleurService travailleurService;

    public PrsTravailleurController(PrsTravailleurService travailleurService) {
        this.travailleurService = travailleurService;
    }

    @GetMapping
    public List<PrsTravailleur> getAll() {
        return travailleurService.findAll();
    }

    @GetMapping("/{immatriculation}")
    public ResponseEntity<PrsTravailleur> getById(@PathVariable String immatriculation) {
        return travailleurService.findById(immatriculation)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> create(@RequestBody PrsTravailleur travailleur) {
        PrsTravailleur saved = travailleurService.save(travailleur);
        
        Map<String, Object> response = new HashMap<>();
        response.put("trvImmatriculation", saved.getTrvImmatriculation());
        response.put("message", "Travailleur immatriculé avec succès");
        
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{immatriculation}")
    public ResponseEntity<Void> delete(@PathVariable String immatriculation) {
        try {
            travailleurService.delete(immatriculation);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}