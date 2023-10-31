package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Tarea;

public class ListaEnlazadaActividades<Actividad> {

    public NodoActividad<Actividad> Cabeza;
    private int Tamanio;

    public ListaEnlazadaActividades (){

        this.Cabeza = null;
        this.Tamanio = 0;

    }

    public void insertar(Actividad dato, ColaTareas<Tarea> Tareas) {
        NodoActividad<Actividad> nuevoNodo = new NodoActividad<>(dato,Tareas);
        if (Cabeza == null) {
            Cabeza = nuevoNodo;
        } else {
            NodoActividad<Actividad> NodoAux = Cabeza;
            while (NodoAux.getSiguiente() != null) {
                NodoAux = NodoAux.getSiguiente();
            }
            NodoAux.setSiguiente(nuevoNodo);
        }
        Tamanio++;
    }

}
