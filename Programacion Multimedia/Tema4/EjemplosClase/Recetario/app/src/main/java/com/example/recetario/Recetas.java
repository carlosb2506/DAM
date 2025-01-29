package com.example.recetario;

public class Recetas {

    private String nombre;
    private int foto;
    private String dificultad;
    private  int  tiempo;
    private String pasos;

    public Recetas(String nombre, int foto, String dificultad, int tiempo, String pasos) {
        this.nombre = nombre;
        this.foto = foto;
        this.dificultad = dificultad;
        this.tiempo = tiempo;
        this.pasos = pasos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }
}
