package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Tarea;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazadaActividades implements Iterable<Actividad> {

    public NodoActividad Cabeza;
    public int Tamanio;
    public String UltimoIngreso;


    public ListaEnlazadaActividades() {

        this.Cabeza = null;
        this.Tamanio = 0;
        this.UltimoIngreso = null;

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
        UltimoIngreso = dato.getNombre();
    }


    public void insertarDespuesDeActividad(Actividad nuevaActividad, String nombreNodoPrevio) {
        NodoActividad nuevoNodo = new NodoActividad(nuevaActividad);
        if (Cabeza == null) {
            Cabeza = nuevoNodo;
            UltimoIngreso = nuevaActividad.getNombre();
            return;
        }

        NodoActividad actual = Cabeza;
        while (actual != null) {
            if (actual.getActividad().getNombre().equals(nombreNodoPrevio)) {
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);
                UltimoIngreso = nuevaActividad.getNombre();
                return;
            }
            actual = actual.getSiguiente();
        }

        insertar(nuevaActividad);
    }

    public void imprimirLista() {
        NodoActividad actual = Cabeza;

        while (actual != null) {
            System.out.print("Actividad: " + actual.getActividad().getNombre() + " -- " + actual.getActividad().getDescripcion() + " \n"); // Suponiendo que T tiene un método toString() adecuado
            actual = actual.getSiguiente();
        }

        System.out.println(); // Para imprimir un salto de línea al final
    }

    public void insertarDespuesDeUltimoIngreso(Actividad nuevaActividad) {
        if (UltimoIngreso == null) {
            System.out.println("El atributo 'ultimoIngreso' es nulo. No se puede realizar la inserción.");
            return;
        }

        NodoActividad nuevoNodo = new NodoActividad(nuevaActividad);

        if (Cabeza == null) {
            Cabeza = nuevoNodo;
            return;
        }

        NodoActividad actual = Cabeza;
        while (actual != null) {
            if (actual.getActividad().getNombre().equals(UltimoIngreso)) {
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("El nodo con nombre igual a 'ultimoIngreso' no se encontró en la lista.");
    }

    //METODOS GETTERS Y SETTERS


    public NodoActividad getCabeza() {
        return Cabeza;
    }

    public void setCabeza(NodoActividad cabeza) {
        Cabeza = cabeza;
    }

    public int getTamanio() {
        return Tamanio;
    }

    public void setTamanio(int tamanio) {
        Tamanio = tamanio;
    }

    public String getUltimoIngreso() {
        return UltimoIngreso;
    }

    public void setUltimoIngreso(String ultimoIngreso) {
        UltimoIngreso = ultimoIngreso;
    }

    public Tarea buscarTareaEnActividad(String NombreActividad, String NombreTarea) {
        NodoActividad actual = Cabeza;

        while (actual.getSiguiente() != null) {

            if (actual.getActividad().getNombre().equals(NombreActividad)) {
                ColaTareas tareas = actual.getActividad().getTareas();
                NodoTarea tareaActual = tareas.nodoPrimero;

                while (tareaActual != null) {
                    if (tareaActual.getTarea().getDescripcion().equals(NombreTarea)) {

                        System.out.println("");
                        System.out.println("Actividad: " + Cabeza.getActividad().getNombre() + "\n" + "Tarea: " + tareaActual.getTarea().Descripcion + "\n" + "Duracion: " + tareaActual.getTarea().getDuracion() + "min");
                        return tareaActual.getTarea();
                    }

                    tareaActual = tareaActual.getSiguiente();
                }
            }

            actual = actual.getSiguiente();
        }

        return null;
    }

    @Override
    public Iterator<Actividad> iterator() {
        return new ListaIterator();
    }

    // Clase interna que implementa la interfaz Iterator
    private class ListaIterator implements Iterator<Actividad> {
        private NodoActividad actual;

        private int posicion;

        // Constructor del Iterator
        public ListaIterator() {
            this.actual = Cabeza;
        }

        // Método para verificar si hay un siguiente elemento
        @Override
        public boolean hasNext() {
            return actual != null;
        }

        // Método para obtener el siguiente elemento
        @Override
        public Actividad next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista.");
            }

            Actividad dato = actual.getActividad();
            actual = actual.getSiguiente();
            posicion++;
            return dato;
        }

    }

}

