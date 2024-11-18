package com.example.ejercicio1;

public class Dispositivos {

    private boolean marcado;
    private  int foto;
    private String dispositivo;

    public Dispositivos(boolean marcado, int foto, String dispositivo) {
        this.marcado = marcado;
        this.foto = foto;
        this.dispositivo = dispositivo;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
}
