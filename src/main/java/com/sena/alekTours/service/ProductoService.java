package com.sena.alekTours.service;
import com.sena.alekTours.entity.Producto;
import com.sena.alekTours.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductoService {


    private final ProductoRepository productoRepository;


    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }


    // Guardar producto
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }


    // Listar todos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }


    // Buscar por categoría
    public List<Producto> buscarPorCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }


    // Buscar por ID
    public Producto buscarPorId(Long id) {
        return productoRepository.findById(id).orElse(null);
    }


    // Eliminar producto
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}

