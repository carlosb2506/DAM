package com.example.barrosocarlos_pi;

public class Reservas {
    int foto;
    String nombre, direccion;

    public Reservas(int foto, String nombre, String direccion) {
        this.foto = foto;
        this.nombre = nombre;
        this.direccion = direccion;
    }

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
