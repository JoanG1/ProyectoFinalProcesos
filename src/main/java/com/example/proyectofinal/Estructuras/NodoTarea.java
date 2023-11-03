package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Tarea;

public class NodoTarea {

    public Tarea Tarea;
    public NodoTarea Siguiente;

    public NodoTarea (Tarea Tarea){
        this.Tarea = Tarea;
        this.Siguiente = null;
    }

    public NodoTarea (){
        this.Tarea = null;
        this.Siguiente = null;
    }

    //METODOS GETTERS Y SETTERS


    public Tarea getTarea() {
        return Tarea;
    }

    public void setTarea(Tarea tarea) {
        Tarea = tarea;
    }

    public NodoTarea getSiguiente() {
        return Siguiente;
    }

    public void setSiguiente(NodoTarea siguiente) {
        Siguiente = siguiente;
    }
}
