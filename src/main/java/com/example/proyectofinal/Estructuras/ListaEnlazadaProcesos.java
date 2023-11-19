package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Proceso;
import com.example.proyectofinal.Tarea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaEnlazadaProcesos implements Iterable<Proceso> {

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

    public Proceso BuscarProceso (String NombreProceso){

        NodoProceso actual = Cabeza;

        if(actual != null){

            while(actual.getSiguiente() != null){

                if (actual.getProceso().getNombre().equals(NombreProceso)){

                    return actual.getProceso();
                }

                actual = actual.getSiguiente();
            }

            if (actual.getProceso().getNombre().equals(NombreProceso)){

                return actual.getProceso();
            }

        }

        return null;
    }

    public ArrayList<Actividad> buscarActividad(String nombreActividad) {
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

        NodoProceso Actual = Cabeza;

        while (Actual!=null){

            if(Actual.getProceso().getNombre().equals(Proceso)) {

                return Actual.getProceso().getListaEnlazadaActividades();
            }

            Actual = Actual.getSiguiente();
        }

        return null;
    }

    public Tarea buscarTareaEnProceso(String Tarea){

        Iterator<Proceso> iterator = iterator();

        while (iterator.hasNext()){

            Proceso proceso = iterator.next();
            ListaEnlazadaActividades listaActividades = proceso.getListaEnlazadaActividades();
            Iterator<Actividad> iteratorActividad = proceso.getListaEnlazadaActividades().iterator();
            while (iteratorActividad.hasNext()){

                Actividad actividad = iteratorActividad.next();
                ColaTareas colaTareas = actividad.getTareas();
                Iterator<Tarea> iteratorTareas = colaTareas.iterator();

                while (iteratorTareas.hasNext()){

                    Tarea tarea = iteratorTareas.next();
                    if(tarea.getDescripcion().equals(Tarea)){
                        System.out.println("Proceso Padre: "+proceso.getNombre()+"\n"+"Actividad Padre:"+proceso.getListaEnlazadaActividades().getCabeza().getActividad().getNombre()+"\n"+"Tarea: "+tarea.getDescripcion());
                        return tarea;
                    }
                }

            }
        }

        return null;
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

    @Override
    public Iterator<Proceso> iterator() {
        return new ProcesoIterator();
    }

    private class ProcesoIterator implements Iterator<Proceso> {
        private NodoProceso current = Cabeza;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Proceso next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Proceso proceso = current.getProceso();
            current = current.getSiguiente();
            return proceso;
        }

        // Puedes implementar el método remove si lo necesitas, pero en este caso, no lo estamos utilizando.
        // @Override
        // public void remove() {
        //     throw new UnsupportedOperationException();
        // }
    }
}
