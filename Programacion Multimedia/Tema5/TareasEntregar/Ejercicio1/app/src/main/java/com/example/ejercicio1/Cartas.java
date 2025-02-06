package com.example.ejercicio1;

public class Cartas {
    private int foto;
    private boolean vuelta;

    public Cartas(boolean vuelta, int foto) {
        this.vuelta = vuelta;
        this.foto = foto;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public boolean isVuelta() {
        return vuelta;
    }

    public void setVuelta(boolean vuelta) {
        this.vuelta = vuelta;
    }
}
