package com.sena.alekTours.service;

import com.sena.alekTours.entity.Pais;
import com.sena.alekTours.repository.PaisRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaisService {

    private final PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    public Pais guardar(Pais pais) {
        return paisRepository.save(pais);
    }

    public List<Pais> listar() {
        return paisRepository.findAll();
    }
}