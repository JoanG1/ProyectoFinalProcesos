package com.example.proyectofinal;

public class Tarea {

    public String Descripcion;
    public Boolean Obligatorio;
    public int Duracion;

    public Tarea (String Descripcion, Boolean Obligatorio, int Duracion){

        this.Descripcion = Descripcion;
        this.Duracion = Duracion;
        this.Obligatorio = Obligatorio;

    }

    //METODOS GETTERS Y SETTERS


    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Boolean getObligatorio() {
        return Obligatorio;
    }

    public void setObligatorio(Boolean obligatorio) {
        Obligatorio = obligatorio;
    }



    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }
}
