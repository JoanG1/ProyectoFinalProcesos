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

    // metodo para insertar dato en el final
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

    //busca un proceso en la lista
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

    //metodo que devuelve un arraylist de las actividades que se buscan si hay mas de una en diferentes procesos
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

    //metodo que busca el proceso relacionado con los procesos anteriores en los metodos buscarActividad() para relacionar el id de los procesos
    public ArrayList<Proceso> buscarProcesoRelacionado (String nombreActividad) {
        ArrayList<Proceso> ProcesosPadres = new ArrayList<>();
        Iterator<Proceso> iterator = iterator();

        while (iterator.hasNext()) {
            Proceso proceso = iterator.next();
            ProcesosPadres.addAll(buscarProcesoDeActividad(proceso, nombreActividad));
        }

        return ProcesosPadres;
    }

    private ArrayList<Proceso> buscarProcesoDeActividad(Proceso proceso, String nombreActividad) {
        ArrayList<Proceso> ProcesosPadres = new ArrayList<>();
        ListaEnlazadaActividades listaActividades = proceso.getListaEnlazadaActividades();
        Iterator<Actividad> iterator = listaActividades.iterator();

        while (iterator.hasNext()) {
            Actividad actividad = iterator.next();
            if (actividad.getNombre().equals(nombreActividad)) {
                System.out.println("Proceso ID: "+proceso.getId());
                actividad.ImpresionDetalles();
                ProcesosPadres.add(proceso);
            }
        }

        return ProcesosPadres;
    }

    //Devuelve la lista de actividades de un proceso
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

    //busca de tareas en un proceso en concreto

    public String buscarTareaEnProceso(String Tarea){

        Iterator<Proceso> iterator = iterator();

        while (iterator.hasNext()){

            Proceso proceso = iterator.next();
            ListaEnlazadaActividades listaActividades = proceso.getListaEnlazadaActividades();
            Iterator<Actividad> iteratorActividad = listaActividades.iterator();
            while (iteratorActividad.hasNext()){

                Actividad actividad = iteratorActividad.next();
                ColaTareas colaTareas = actividad.getTareas();
                Iterator<Tarea> iteratorTareas = colaTareas.iterator();

                while (iteratorTareas.hasNext()){

                    Tarea tarea = iteratorTareas.next();
                    if(tarea.getDescripcion().equals(Tarea)){
                        System.out.println("Proceso Padre: "+proceso.getNombre()+"\n"+"Actividad Padre:"+proceso.getListaEnlazadaActividades().getCabeza().getActividad().getNombre()+"\n"+"Tarea: "+tarea.getDescripcion());
                        return "Proceso Padre: "+proceso.getNombre()+"\n"+"Actividad Padre:"+proceso.getListaEnlazadaActividades().getCabeza().getActividad().getNombre()+"\n"+"Tarea: "+tarea.getDescripcion();
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
