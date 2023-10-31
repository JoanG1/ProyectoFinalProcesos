package com.example.proyectofinal.Estructuras;

public class NodoTarea<Tarea> {

    private Tarea Tarea;
    private NodoTarea<Tarea> Siguiente;

    public NodoTarea (Tarea Tarea){
        this.Tarea = Tarea;
        this.Siguiente = null;
    }

    //METODOS GETTERS Y SETTERS


    public Tarea getTarea() {
        return Tarea;
    }

    public void setTarea(Tarea tarea) {
        Tarea = tarea;
    }

    public NodoTarea<Tarea> getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoTarea<Tarea> siguiente) {
        Siguiente = siguiente;
    }
}
