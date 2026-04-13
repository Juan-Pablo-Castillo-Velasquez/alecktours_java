package com.sena.alekTours.service;

import com.sena.alekTours.entity.Hotel;
import com.sena.alekTours.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel guardarHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> listarTodos() {
        return hotelRepository.findAll();
    }

    public Hotel buscarPorId(Integer id) {
        return hotelRepository.findById(id).orElse(null);
    }

    public void eliminarHotel(Integer id) {
        hotelRepository.deleteById(id);
    }
}