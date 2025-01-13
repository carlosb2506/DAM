package com.example.ejercicio5;

public class Profesor {
    String nombre, apellidos, departamento, estado;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Profesor(String nombre, String apellidos, String departamento, String estado) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.estado = estado;
    }
}
