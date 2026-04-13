package com.sena.alekTours.controller;

import com.sena.alekTours.entity.Hotel;
import com.sena.alekTours.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hoteles")
@CrossOrigin(origins = "*")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    public Hotel guardar(@RequestBody Hotel hotel) {
        return hotelService.guardarHotel(hotel);
    }

    @GetMapping
    public List<Hotel> listar() {
        return hotelService.listarTodos();
    }

    @GetMapping("/{id}")
    public Hotel buscarPorId(@PathVariable Integer id) {
        return hotelService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        hotelService.eliminarHotel(id);
        return "Hotel eliminado";
    }
}