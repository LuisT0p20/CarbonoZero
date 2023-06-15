package com.example.clase1.Utilidades;

public class Usuario {
    private String nombre;
    private Double consumo;
    private String fecha;

    public Usuario() {
    }

    public Usuario(String nombre, Double consumo, String fecha) {
        this.nombre = nombre;
        this.consumo = consumo;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getConsumo() {
        return consumo;
    }

    public void setConsumo(Double consumo) {
        this.consumo = consumo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
