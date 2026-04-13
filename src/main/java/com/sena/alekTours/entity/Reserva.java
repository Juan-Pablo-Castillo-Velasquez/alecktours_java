package com.sena.alekTours.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "id_paquete")
    private Integer idPaquete;

    @Column(name = "fecha_reserva")
    private LocalDateTime fechaReserva;

    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "numero_personas")
    private Integer numeroPersonas;

    private String estado;

    public Reserva() {}

    public Reserva(Integer idCliente, Integer idEmpleado, Integer idPaquete,
                   LocalDateTime fechaReserva, LocalDate fechaInicio,
                   LocalDate fechaFin, Integer numeroPersonas, String estado) {
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.idPaquete = idPaquete;
        this.fechaReserva = fechaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.numeroPersonas = numeroPersonas;
        this.estado = estado;
    }

    public Integer getIdReserva() { return idReserva; }
    public Integer getIdCliente() { return idCliente; }
    public Integer getIdEmpleado() { return idEmpleado; }
    public Integer getIdPaquete() { return idPaquete; }
    public LocalDateTime getFechaReserva() { return fechaReserva; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public Integer getNumeroPersonas() { return numeroPersonas; }
    public String getEstado() { return estado; }

    public void setIdCliente(Integer idCliente) { this.idCliente = idCliente; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setIdPaquete(Integer idPaquete) { this.idPaquete = idPaquete; }
    public void setFechaReserva(LocalDateTime fechaReserva) { this.fechaReserva = fechaReserva; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }
    public void setNumeroPersonas(Integer numeroPersonas) { this.numeroPersonas = numeroPersonas; }
    public void setEstado(String estado) { this.estado = estado; }
}