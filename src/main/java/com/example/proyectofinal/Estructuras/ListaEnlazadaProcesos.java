package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Proceso;
import com.example.proyectofinal.Tarea;

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

    public ListaEnlazadaActividades ListaDeActividadesDeProceso (String Proceso){

        ListaEnlazadaActividades ListaActividades = new ListaEnlazadaActividades();
        NodoProceso Actual = Cabeza;

        while (Actual!=null){

            if(Actual.getProceso().getNombre().equals(Proceso)) {

                return Actual.getProceso().getListaEnlazadaActividades();
            }

            Actual = Actual.getSiguiente();
        }

        return null;
    }

    public Tarea buscarTareaEnProcesos(String nombreProceso, String nombreActividad, String nombreTarea) {
        NodoProceso actual = Cabeza;

        while (actual != null) {
            if (actual.getProceso().getNombre().equals(nombreProceso)||nombreProceso.equals("")) {

                ColaTareas colaTareas = actual.getProceso().getListaEnlazadaActividades().getCabeza().getActividad().getTareas();

                if (actual.getProceso().getListaEnlazadaActividades().getCabeza().getActividad().getNombre().equals(nombreActividad)||nombreActividad.equals("")) {
                    NodoTarea tareaActual = colaTareas.nodoPrimero;
                    while (tareaActual != null) {
                        if (tareaActual.getTarea().getDescripcion().equals(nombreTarea)) {


                            System.out.println("Proceso Padre: "+actual.getProceso().getNombre()+"\n"+"Actividad Padre:"+actual.getProceso().getListaEnlazadaActividades().getCabeza().getActividad().getNombre()+"\n"+"Tarea: "+tareaActual.getTarea().Descripcion);
                            return tareaActual.getTarea();
                        }
                        tareaActual = tareaActual.getSiguiente();
                    }
                }
            }
            actual = actual.siguiente;
        }

        return null; // Retorna null si no se encuentra la tarea
    }

    //METODODS GETTERS Y SETTERS


    public NodoProceso getCabeza() {
        return Cabeza;
    }

    public void setCabeza(NodoProceso cabeza) {
        Cabeza = cabeza;
    }

    public int getTamanio() {
        return Tamanio;
    }

    public void setTamanio(int tamanio) {
        Tamanio = tamanio;
    }
}
