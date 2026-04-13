package com.sena.alekTours.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paises")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pais")
    private Integer idPais;

    @Column(name = "nombre_pais")
    private String nombrePais;

    @Column(name = "codigo_iso")
    private String codigoIso;

    public Pais() {}

    public Integer getIdPais() { return idPais; }
    public String getNombrePais() { return nombrePais; }
    public String getCodigoIso() { return codigoIso; }

    public void setNombrePais(String nombrePais) { this.nombrePais = nombrePais; }
    public void setCodigoIso(String codigoIso) { this.codigoIso = codigoIso; }
}