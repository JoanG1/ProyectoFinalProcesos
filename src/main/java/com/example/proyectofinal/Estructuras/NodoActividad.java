package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Tarea;

public class NodoActividad<Actividad> {

    private NodoActividad<Actividad> siguiente ;
    private Actividad Actividad;
    private ColaTareas<Tarea> Tareas;

    public NodoActividad (Actividad Actividad , ColaTareas<Tarea> Tareas){

        this.Actividad = Actividad;
        this.siguiente = null;
        this.Tareas = Tareas;

    }

    public NodoActividad (Actividad Actividad){

        this.Actividad = Actividad;
        this.siguiente = null;
        this.Tareas = null;

    }



    //METODOS GETTERS Y SETTERS


    public NodoActividad<Actividad> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoActividad<Actividad> siguiente) {
        this.siguiente = siguiente;
    }

    public Actividad getActividad() {
        return Actividad;
    }

    public void setActividad(Actividad actividad) {
        Actividad = actividad;
    }

    public ColaTareas getTareas() {
        return Tareas;
    }

    public void setTareas(ColaTareas tareas) {
        Tareas = tareas;
    }
}
