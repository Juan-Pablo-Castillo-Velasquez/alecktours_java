package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Producto;
import com.sena.alekTours.service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
@Tag(name = "Productos", description = "API para gestionar productos del inventario")
public class ProductoController {


    private final ProductoService productoService;


    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    // ============================================
    // ENDPOINT 1: Crear producto
    // ============================================
    @Operation(
            summary = "Crear un nuevo producto",
            description = "Guarda un producto en la base de datos con los datos proporcionados"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos")
    })
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoService.guardarProducto(producto);
    }


    // ============================================
    // ENDPOINT 2: Listar todos
    // ============================================
    @Operation(
            summary = "Listar todos los productos",
            description = "Retorna una lista completa de todos los productos en inventario"
    )
    @ApiResponse(responseCode = "200", description = "Lista obtenida correctamente")
    @GetMapping
    public List<Producto> listarProductos() {
        return productoService.listarTodos();
    }


    // ============================================
    // ENDPOINT 3: Buscar por categoría
    // ============================================
    @Operation(
            summary = "Buscar productos por categoría",
            description = "Filtra los productos según la categoría especificada"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista filtrada"),
            @ApiResponse(responseCode = "404", description = "Categoría sin productos")
    })
    @GetMapping("/categoria/{categoria}")
    public List<Producto> listarPorCategoria(
            @Parameter(description = "Categoría a buscar", example = "Electrónica")
            @PathVariable String categoria) {
        return productoService.buscarPorCategoria(categoria);
    }


    // ============================================
    // ENDPOINT 4: Buscar por ID
    // ============================================
    @Operation(
            summary = "Buscar producto por ID",
            description = "Retorna un producto específico según su identificador único"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado"),
            @ApiResponse(responseCode = "404", description = "Producto no existe")
    })
    @GetMapping("/{id}")
    public Producto buscarPorId(
            @Parameter(description = "ID del producto", example = "1")
            @PathVariable Long id) {
        return productoService.buscarPorId(id);
    }


    // ============================================
    // ENDPOINT 5: Eliminar
    // ============================================
    @Operation(
            summary = "Eliminar un producto",
            description = "Borra un producto de la base de datos según su ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado"),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado")
    })
    @DeleteMapping("/{id}")
    public String eliminarProducto(
            @Parameter(description = "ID del producto a eliminar", example = "1")
            @PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "Producto eliminado correctamente";
    }

}
