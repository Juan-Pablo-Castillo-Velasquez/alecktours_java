package com.sena.alekTours.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ciudades")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Integer idCiudad;

    @Column(name = "nombre_ciudad")
    private String nombreCiudad;

    @Column(name = "id_pais")
    private Integer idPais;

    public Ciudad() {}

    public Integer getIdCiudad() { return idCiudad; }
    public String getNombreCiudad() { return nombreCiudad; }
    public Integer getIdPais() { return idPais; }

    public void setNombreCiudad(String nombreCiudad) { this.nombreCiudad = nombreCiudad; }
    public void setIdPais(Integer idPais) { this.idPais = idPais; }
}