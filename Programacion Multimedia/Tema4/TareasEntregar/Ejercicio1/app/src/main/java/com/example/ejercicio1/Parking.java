package com.example.ejercicio1;

public class Parking {

    private int icono;
    private String ubicacion;

    public int getIcono() {
      return icono;
    }

    public void setIcono(int icono) {
        this.icono = icono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Parking(int icono,String ubicacion) {
        this.icono = icono;
        this.ubicacion = ubicacion;
    }
}
