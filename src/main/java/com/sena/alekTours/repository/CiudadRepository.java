package com.sena.alekTours.repository;

import com.sena.alekTours.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    List<Ciudad> findByIdPais(Integer idPais);
}