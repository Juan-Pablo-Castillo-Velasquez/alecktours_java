package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Paquete;
import com.sena.alekTours.service.PaqueteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/paquetes")
@CrossOrigin("*")
public class PaqueteController {

    private final PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @PostMapping
    public Paquete crear(@RequestBody Paquete paquete) {
        return paqueteService.guardar(paquete);
    }

    @GetMapping
    public List<Paquete> listar() {
        return paqueteService.listar();
    }

    @GetMapping("/{id}")
    public Paquete buscar(@PathVariable Integer id) {
        return paqueteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        paqueteService.eliminar(id);
    }
}