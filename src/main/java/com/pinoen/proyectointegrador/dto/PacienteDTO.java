package com.pinoen.proyectointegrador.dto;

import com.pinoen.proyectointegrador.entity.Domicilio;

import java.time.LocalDate;

public class PacienteDTO {
    private Long id;
    private String apellido;
    private String nombre;
    private String dni;
    private LocalDate fechaIngreso;
    private String email;
    private Domicilio domicilio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public PacienteDTO(Long id, String apellido, String nombre, String dni, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public PacienteDTO(String apellido, String nombre, String dni, LocalDate fechaIngreso, String email, Domicilio domicilio) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
        this.domicilio = domicilio;
    }

    public PacienteDTO() {
    }
}
