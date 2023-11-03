package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Tarea;

public class NodoActividad {

    private NodoActividad siguiente ;
    private Actividad Actividad;

    public NodoActividad (Actividad Actividad , ColaTareas Tareas){

        this.Actividad = Actividad;
        this.siguiente = null;

    }

    public NodoActividad (Actividad Actividad){

        this.Actividad = Actividad;
        this.siguiente = null;

    }



    //METODOS GETTERS Y SETTERS


    public NodoActividad getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoActividad siguiente) {
        this.siguiente = siguiente;
    }

    public Actividad getActividad() {
        return Actividad;
    }

    public void setActividad(Actividad actividad) {
        Actividad = actividad;
    }

}
