package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Pais;
import com.sena.alekTours.service.PaisService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paises")
@CrossOrigin("*")
public class PaisController {

    private final PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @PostMapping
    public Pais crear(@RequestBody Pais pais) {
        return paisService.guardar(pais);
    }

    @GetMapping
    public List<Pais> listar() {
        return paisService.listar();
    }
}