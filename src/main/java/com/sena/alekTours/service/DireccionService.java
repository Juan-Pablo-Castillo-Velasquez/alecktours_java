package com.sena.alekTours.service;

import com.sena.alekTours.entity.Direccion;
import com.sena.alekTours.repository.DireccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DireccionService {

    private final DireccionRepository direccionRepository;

    public DireccionService(DireccionRepository direccionRepository) {
        this.direccionRepository = direccionRepository;
    }

    public Direccion guardar(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    public List<Direccion> listar() {
        return direccionRepository.findAll();
    }

    public Direccion buscarPorId(Integer id) {
        return direccionRepository.findById(id).orElse(null);
    }

    public void eliminar(Integer id) {
        direccionRepository.deleteById(id);
    }
}