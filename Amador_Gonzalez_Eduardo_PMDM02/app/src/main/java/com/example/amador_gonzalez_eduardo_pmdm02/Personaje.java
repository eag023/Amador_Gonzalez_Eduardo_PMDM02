package com.example.amador_gonzalez_eduardo_pmdm02;

import java.io.Serializable;

//Clase que define el objeto Personaje con su constructor y métodos getters y setters

public class Personaje implements Serializable{
    public int imagen;
    public String nombre;
    public int descripcion;
    public int habilidades;

    public Personaje(int imagen, String nombre, int habilidades, int descripcion) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.habilidades = habilidades;
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(int descripcion) {
        this.descripcion = descripcion;
    }

    public int getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(int habilidades) {
        this.habilidades = habilidades;
    }
}
