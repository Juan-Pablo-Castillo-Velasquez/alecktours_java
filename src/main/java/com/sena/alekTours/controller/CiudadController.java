package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Ciudad;
import com.sena.alekTours.service.CiudadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
@CrossOrigin("*")
public class CiudadController {

    private final CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @PostMapping
    public Ciudad crear(@RequestBody Ciudad ciudad) {
        return ciudadService.guardar(ciudad);
    }

    @GetMapping
    public List<Ciudad> listar() {
        return ciudadService.listar();
    }

    @GetMapping("/pais/{idPais}")
    public List<Ciudad> porPais(@PathVariable Integer idPais) {
        return ciudadService.porPais(idPais);
    }
}