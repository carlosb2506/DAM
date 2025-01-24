package com.example.examen5;

import android.app.Activity;

public class Entrenos {
    private int foto;
    private String deporte;
    private int calorias;
    private int duracion;
    private String hora;
    private String fecha;
    private int frec_cardiaca;

    public Entrenos(int foto, String deporte, int calorias, int duracion, String hora, String fecha, int frec_cardiaca) {
        this.foto = foto;
        this.deporte = deporte;
        this.calorias = calorias;
        this.duracion = duracion;
        this.hora = hora;
        this.fecha = fecha;
        this.frec_cardiaca = frec_cardiaca;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDeporte() {
        return deporte;
    }

    public void setDeporte(String deporte) {
        this.deporte = deporte;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getFrec_cardiaca() {
        return frec_cardiaca;
    }

    public void setFrec_cardiaca(int frec_cardiaca) {
        this.frec_cardiaca = frec_cardiaca;
    }
}
