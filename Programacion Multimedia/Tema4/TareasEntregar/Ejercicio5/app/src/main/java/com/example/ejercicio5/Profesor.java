package com.example.ejercicio5;

public class Profesor {
    int foto;
    String nombre, apellidos, departamento, estado;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

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

    public Profesor(int foto, String nombre, String apellidos, String departamento, String estado) {
        this.foto = foto;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.departamento = departamento;
        this.estado = estado;
    }
}
