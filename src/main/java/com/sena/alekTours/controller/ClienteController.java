package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Cliente;
import com.sena.alekTours.service.ClienteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public Cliente guardar(@RequestBody Cliente cliente) {
        return clienteService.guardarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> listar() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Integer id) {
        return clienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        clienteService.eliminarCliente(id);
        return "Cliente eliminado";
    }
}