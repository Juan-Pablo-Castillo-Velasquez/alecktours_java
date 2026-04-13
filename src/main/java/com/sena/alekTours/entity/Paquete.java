package com.sena.alekTours.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "paquetes")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_paquete")
    private Integer idPaquete;

    @Column(name = "nombre_paquete")
    private String nombrePaquete;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "duracion_dias")
    private Integer duracionDias;

    @Column(name = "precio_base")
    private Double precioBase;

    @Column(name = "activo")
    private Boolean activo;

    public Paquete() {}

    public Integer getIdPaquete() {
        return idPaquete;
    }

    public String getNombrePaquete() {
        return nombrePaquete;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Integer getDuracionDias() {
        return duracionDias;
    }

    public Double getPrecioBase() {
        return precioBase;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setNombrePaquete(String nombrePaquete) {
        this.nombrePaquete = nombrePaquete;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracionDias(Integer duracionDias) {
        this.duracionDias = duracionDias;
    }

    public void setPrecioBase(Double precioBase) {
        this.precioBase = precioBase;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}