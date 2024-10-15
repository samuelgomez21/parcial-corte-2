package org.example.domain;
import java.io.Serializable;

public class Fruta implements Serializable {
    private static final long serialVersionUID = 1L; // Para la serialización
    private int id;
    private String nombre;
    private String color;

    public Fruta(int id, String nombre, String color) {
        this.id = id;
        this.nombre = nombre;
        this.color = color;
    }


    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Fruta{" + "id=" + id + ", nombre='" + nombre + '\'' + ", color='" + color + '\'' + '}';
    }
}
