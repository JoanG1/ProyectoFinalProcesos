package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Tarea;

public class ListaEnlazadaActividades {

    public NodoActividad Cabeza;
    private int Tamanio;

    public ListaEnlazadaActividades (){

        this.Cabeza = null;
        this.Tamanio = 0;

    }

    public void insertar(Actividad dato) {
        NodoActividad nuevoNodo = new NodoActividad(dato);
        if (Cabeza == null) {
            Cabeza = nuevoNodo;
        } else {
            NodoActividad NodoAux = Cabeza;
            while (NodoAux.getSiguiente() != null) {
                NodoAux = NodoAux.getSiguiente();
            }
            NodoAux.setSiguiente(nuevoNodo);
        }
        Tamanio++;
    }

    public void imprimirLista() {
        NodoActividad actual = Cabeza;

        while (actual != null) {
            System.out.print("Actividad: "+ actual.getActividad().getDescripcion()+" "+ actual.getActividad().getNombre() + " "); // Suponiendo que T tiene un método toString() adecuado
            actual = actual.getSiguiente();
        }

        System.out.println(); // Para imprimir un salto de línea al final
    }



}
