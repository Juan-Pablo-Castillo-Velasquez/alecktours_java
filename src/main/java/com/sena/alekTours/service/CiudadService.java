package com.sena.alekTours.service;

import com.sena.alekTours.entity.Ciudad;
import com.sena.alekTours.repository.CiudadRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    public Ciudad guardar(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public List<Ciudad> listar() {
        return ciudadRepository.findAll();
    }

    public List<Ciudad> porPais(Integer idPais) {
        return ciudadRepository.findByIdPais(idPais);
    }
}