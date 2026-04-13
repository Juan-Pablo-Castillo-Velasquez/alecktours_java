package com.sena.alekTours.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer idCliente;
    
    
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;
    private String celular;

   @Column(name = "id_direccion")
private Integer idDireccion;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    @Column(name = "fecha_registro")
    private LocalDateTime fechaRegistro;

    public Cliente() {}

    public Cliente(String nombre, String apellido, String cedula, String correo,
                   String celular, Integer idDireccion,
                   LocalDate fechaNacimiento, LocalDateTime fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.correo = correo;
        this.celular = celular;
        this.idDireccion = idDireccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdCliente() { return idCliente; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getCedula() { return cedula; }
    public String getCorreo() { return correo; }
    public String getCelular() { return celular; }
    public Integer getIdDireccion() { return idDireccion; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public void setCorreo(String correo) { this.correo = correo; }
    public void setCelular(String celular) { this.celular = celular; }
    public void setIdDireccion(Integer idDireccion) { this.idDireccion = idDireccion; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
}