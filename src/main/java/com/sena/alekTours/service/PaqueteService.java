package com.sena.alekTours.service;

import com.sena.alekTours.entity.Paquete;
import com.sena.alekTours.repository.PaqueteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;

    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    public Paquete guardar(Paquete paquete) {
        return paqueteRepository.save(paquete);
    }

    public List<Paquete> listar() {
        return paqueteRepository.findAll();
    }

    public Paquete buscarPorId(Integer id) {
        return paqueteRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        paqueteRepository.deleteById(id);
    }
}