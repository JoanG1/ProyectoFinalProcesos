package com.example.proyectofinal;

public class Actividad {

    private String Nombre;
    private String Descripcion;
    private boolean Obligatorio;

    public Actividad (String Nombre, String Descripcion, boolean Obligatorio ){

        this.Descripcion = Descripcion;
        this.Nombre = Nombre;
        this.Obligatorio = Obligatorio;

    }

    //METODOS GETTERS Y SETTERS


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public boolean isObligatorio() {
        return Obligatorio;
    }

    public void setObligatorio(boolean obligatorio) {
        Obligatorio = obligatorio;
    }
}
