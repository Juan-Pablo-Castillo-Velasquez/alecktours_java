package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Reserva;
import com.sena.alekTours.service.ReservaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public Reserva guardar(@RequestBody Reserva reserva) {
        return reservaService.guardarReserva(reserva);
    }

    @GetMapping
    public List<Reserva> listar() {
        return reservaService.listarTodas();
    }

    @GetMapping("/{id}")
    public Reserva buscarPorId(@PathVariable Integer id) {
        return reservaService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaService.eliminarReserva(id);
        return "Reserva eliminada";
    }
}