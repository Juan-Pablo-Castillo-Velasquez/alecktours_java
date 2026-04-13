package com.sena.alekTours.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "direcciones")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_direccion")
    private Integer idDireccion;

    @Column(name = "direccion_linea")
    private String direccionLinea;

    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "codigo_postal")
    private String codigoPostal;

    public Direccion() {}

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public String getDireccionLinea() {
        return direccionLinea;
    }

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setDireccionLinea(String direccionLinea) {
        this.direccionLinea = direccionLinea;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}