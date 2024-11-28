package com.example.ejercicio2;

import android.widget.ToggleButton;

public class Tareas {
    private String tareas;
    private String horas;
    private String nombres;
    private boolean tbHecha;

    public Tareas(String tareas, String horas, String nombres, boolean tbHecha) {
        this.tareas = tareas;
        this.horas = horas;
        this.nombres = nombres;
        this.tbHecha = tbHecha;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getHoras() {
        return horas;
    }

    public void setHoras(String horas) {
        this.horas = horas;
    }

    public boolean getTbHecha() {
        return tbHecha;
    }

    public void setTbHecha(boolean tbHecha) {
        this.tbHecha = tbHecha;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
}
