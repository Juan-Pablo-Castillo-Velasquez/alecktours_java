package com.sena.alekTours.repository;
import com.sena.alekTours.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ProductoRepository extends JpaRepository<Producto, Long> {
    // Buscar productos por categoría
    List<Producto> findByCategoria(String categoria);
}
