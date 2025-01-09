package com.example.ejercicio2;

public class Registro {
    //private int foto;
    private String nombre, duenio, edad;

    public Registro(String nombre, String duenio, String edad) {
        //this.foto = foto;
        this.nombre = nombre;
        this.duenio = duenio;
        this.edad = edad;
    }

    //public int getFoto() {
      //  return foto;
    //}

    //public void setFoto(int foto) {
      //  this.foto = foto;
    //}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDuenio() {
        return duenio;
    }

    public void setDuenio(String duenio) {
        this.duenio = duenio;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
