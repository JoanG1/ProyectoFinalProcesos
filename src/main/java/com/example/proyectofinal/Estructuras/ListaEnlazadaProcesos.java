package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Proceso;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
            System.out.print("ID Proceso: "+ actual.getProceso().getId()+" -- Nombre Proceso: "+actual.getProceso().getNombre()+"\n"); // Suponiendo que T tiene un método toString() adecuado
            actual = actual.getSiguiente();
        }

        System.out.println(); // Para imprimir un salto de línea al final
    }

    public ArrayList<Actividad>buscarActividad(String nombreActividad) {
        ArrayList<Actividad> actividadesEncontradas = new ArrayList<>();
        NodoProceso actual = Cabeza;

        while (actual != null) {
            actividadesEncontradas.addAll(buscarActividadEnProceso(actual.getProceso(), nombreActividad));
            actual = actual.siguiente;
        }

        System.out.println(actividadesEncontradas);
        return actividadesEncontradas;
    }

    private ArrayList<Actividad> buscarActividadEnProceso(Proceso proceso, String nombreActividad) {
        ArrayList<Actividad> actividadesEncontradas = new ArrayList<>();
        ListaEnlazadaActividades listaActividades = proceso.getListaEnlazadaActividades();

        NodoActividad actual = listaActividades.getCabeza();

        while (actual != null) {
            if (actual.getActividad().getNombre().equals(nombreActividad)) {
                System.out.println("Proceso ID: "+proceso.getId());
                actual.getActividad().ImpresionDetalles();
                actividadesEncontradas.add(actual.getActividad());
            }
            actual = actual.getSiguiente();
        }

        return actividadesEncontradas;
    }
}
