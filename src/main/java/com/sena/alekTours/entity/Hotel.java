package com.sena.alekTours.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private Integer idHotel;

    @Column(name = "nombre_hotel")
    private String nombreHotel;

    private Integer calificacion;

    @Column(name = "id_direccion")
    private Integer idDireccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    private String telefono;

    public Hotel() {}

    public Hotel(String nombreHotel, Integer calificacion, Integer idDireccion,
                 String correoElectronico, String telefono) {
        this.nombreHotel = nombreHotel;
        this.calificacion = calificacion;
        this.idDireccion = idDireccion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
    }

    public Integer getIdHotel() { return idHotel; }
    public String getNombreHotel() { return nombreHotel; }
    public Integer getCalificacion() { return calificacion; }
    public Integer getIdDireccion() { return idDireccion; }
    public String getCorreoElectronico() { return correoElectronico; }
    public String getTelefono() { return telefono; }

    public void setNombreHotel(String nombreHotel) { this.nombreHotel = nombreHotel; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }
    public void setIdDireccion(Integer idDireccion) { this.idDireccion = idDireccion; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}