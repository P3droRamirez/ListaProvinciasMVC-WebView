package com.example.webview;

import java.io.Serializable;

public class Provincia implements Serializable {

    private static int contador = 1;
    private int id;

    private String nombre;
    private int numHabitantes;
    private String municipio;
    private int imagen;

    public Provincia(int numHabitantes, String nombre, String municipio, int imagen) {
        this.id = contador++;
        this.numHabitantes = numHabitantes;
        this.nombre = nombre;
        this.municipio = municipio;
        this.imagen = imagen;
    }

    public Provincia() {
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumHabitantes() {
        return numHabitantes;
    }

    public void setNumHabitantes(int numHabitantes) {
        this.numHabitantes = numHabitantes;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
