package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Proceso;

public class ListaEnlazadaProcesos {

    public NodoProceso Cabeza;
    public int Tamanio;



    public ListaEnlazadaProcesos (){

        this.Cabeza = null;
        this.Tamanio = 0;

    }

    public void insertar(Proceso dato) {
        NodoProceso nuevoNodo = new NodoProceso(dato);
        if (Cabeza == null) {
            Cabeza = nuevoNodo;
        } else {
            NodoProceso NodoAux = Cabeza;
            while (NodoAux.getSiguiente() != null) {
                NodoAux = NodoAux.getSiguiente();
            }
            NodoAux.setSiguiente(nuevoNodo);
        }
        Tamanio++;
    }

    public void imprimirLista() {
        NodoProceso actual = Cabeza;

        while (actual != null) {
            System.out.print("ID Proceso: "+ actual.getProceso().getId()+" -- Nombre Proceso: "+actual.getProceso().getNombre()); // Suponiendo que T tiene un método toString() adecuado
            actual = actual.getSiguiente();
        }

        System.out.println(); // Para imprimir un salto de línea al final
    }

    public Actividad buscarActividad(String nombreActividad) {
        NodoProceso actual = Cabeza;
        while (actual != null) {
            Actividad actividad = buscarActividadEnProceso(actual.getProceso() , nombreActividad);
            if (actividad != null) {
                System.out.println(actividad);
                return actividad;
            }
            actual = actual.siguiente;
        }
        System.out.println("No se encontro");
        return null;
    }

    private Actividad buscarActividadEnProceso(Proceso proceso, String nombreActividad) {

        ListaEnlazadaActividades listaActividades = proceso.getListaEnlazadaActividades();
        NodoActividad actual = listaActividades.getCabeza();

        while (actual != null) {
            if (actual.getActividad().getNombre().equals(nombreActividad)) {
                System.out.println("Actividad : "+ actual.getActividad().getNombre()+" -- "+actual.getActividad().getDescripcion()+"\n");
                return actual.getActividad();
            }
            actual = actual.getSiguiente();
        }
        System.out.println("No hay actividad");
        return null;
    }
}
