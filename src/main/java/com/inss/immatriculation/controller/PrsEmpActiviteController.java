package com.inss.immatriculation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inss.immatriculation.pojo.PrsEmpActivite;
import com.inss.immatriculation.service.PrsEmpActiviteService;

@RestController
@RequestMapping("/api/activites")
public class PrsEmpActiviteController {

    private final PrsEmpActiviteService service;

    public PrsEmpActiviteController(PrsEmpActiviteService service) {
        this.service = service;
    }

    @GetMapping
    public List<PrsEmpActivite> getAll() {
        return service.findAll();
    }

    @GetMapping("/employeur/{empSequence}")
    public List<PrsEmpActivite> getByEmployeur(@PathVariable Long empSequence) {
        return service.findByEmployeur(empSequence);
    }

    // Note : Pour un POST avec une clé composite, il est souvent plus simple 
    // de passer l'ID dans le corps de la requête.
    @PostMapping
    public PrsEmpActivite create(@RequestBody PrsEmpActivite activite) {
        return service.save(activite);
    }
}