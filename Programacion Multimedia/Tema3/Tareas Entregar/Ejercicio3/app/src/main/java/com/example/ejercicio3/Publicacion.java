package com.example.ejercicio3;

public class Publicacion {

    private int publicacion;
    private int numMg;

    public Publicacion(int publicacion, int numMg){
        this.publicacion = publicacion;
        this.numMg = numMg;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }

    public int getNumLikes() {
        return numMg;
    }

    public void setNumLikes(int numMg) {
        this.numMg = numMg;
    }
}
