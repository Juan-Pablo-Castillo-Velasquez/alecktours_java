package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Direccion;
import com.sena.alekTours.service.DireccionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/direcciones")
@CrossOrigin(origins = "*")
public class DireccionController {

    private final DireccionService direccionService;

    public DireccionController(DireccionService direccionService) {
        this.direccionService = direccionService;
    }

    @PostMapping
    public Direccion crear(@RequestBody Direccion direccion) {
        return direccionService.guardar(direccion);
    }

    @GetMapping
    public List<Direccion> listar() {
        return direccionService.listar();
    }

    @GetMapping("/{id}")
    public Direccion obtener(@PathVariable Integer id) {
        return direccionService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        direccionService.eliminar(id);
        return "Dirección eliminada";
    }
}