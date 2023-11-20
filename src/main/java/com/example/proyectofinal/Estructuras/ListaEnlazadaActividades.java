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

    //metodo para insertar un dato
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


    //metodo para insertar un dato desde una actividad dada
    public Boolean insertarDespuesDeActividad(Actividad nuevaActividad, String nombreNodoPrevio) {
        NodoActividad nuevoNodo = new NodoActividad(nuevaActividad);
        if (Cabeza == null) {
            Cabeza = nuevoNodo;
            UltimoIngreso = nuevaActividad.getNombre();
            return false;
        }

        NodoActividad actual = Cabeza;
        while (actual != null) {
            if (actual.getActividad().getNombre().equals(nombreNodoPrevio)) {
                nuevoNodo.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoNodo);
                UltimoIngreso = nuevaActividad.getNombre();
                return false;
            }
            actual = actual.getSiguiente();
        }

        return true;
    }

    //imprimir lista
    public void imprimirLista() {
        NodoActividad actual = Cabeza;

        while (actual != null) {
            System.out.print("Actividad: " + actual.getActividad().getNombre() + " -- " + actual.getActividad().getDescripcion() + " \n"); // Suponiendo que T tiene un método toString() adecuado
            actual = actual.getSiguiente();
        }

        System.out.println(); // Para imprimir un salto de línea al final
    }

    //metodo ppara insertar despues del ultimo ingreso a la lista
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

        return null;
    }

    //Metodos de buscar actividad dentro de la lista dada el nombre
    public Actividad BuscarActividad (String Actividad){

        Iterator<Actividad> iterator = iterator();

        while (iterator.hasNext()){

            Actividad actividad = iterator.next();
            if(actividad.getNombre().equals(Actividad)){

                return actividad;
            }
        }

        return null;
    }

    //metodo para devolver la lista de tareas de una actividad especifica
    public ColaTareas ListaDeTareasDeActividad (String Actividad) {

        NodoActividad Actual = Cabeza;

        while (Actual!=null){

            if(Actual.getActividad().getNombre().equals(Actividad)) {

                return Actual.getActividad().getTareas();
            }

            Actual = Actual.getSiguiente();
        }

        return null;
    }

    //metodo para traer duracion maxima de actividades
    public int DuracionMaxima (){
        int DuracionMaxima = 0;

        ColaTareas colaTareas;
        NodoActividad actual = Cabeza;

        while (actual!=null){

            colaTareas = actual.getActividad().getTareas();
            Iterator<Tarea> iterator = colaTareas.iterator();

            while (iterator.hasNext()){

               Tarea tarea = iterator.next();
               DuracionMaxima += tarea.getDuracion();

            }

            actual = actual.getSiguiente();

        }

        return DuracionMaxima;
    }

    //metodo para traer duracion minima
    public int DuracionMinima (){
        int DuracionMinima = 0;

        ColaTareas colaTareas;
        NodoActividad actual = Cabeza;

        while (actual!=null){

            if(actual.getActividad().isObligatorio()){

                colaTareas = actual.getActividad().getTareas();
                Iterator<Tarea> iterator = colaTareas.iterator();

                while (iterator.hasNext()){

                    Tarea tarea = iterator.next();

                    if(tarea.getObligatorio()){

                        DuracionMinima += tarea.getDuracion();

                    }

                }


            }

            actual = actual.getSiguiente();

        }

        return DuracionMinima;
    }

    //metodo para intercambio de tareas dadas dos actividades diferentes
    public void IntercambioActividades(String Actividad1, String Actividad2){

       Actividad actividad1 = BuscarActividad(Actividad1);
       Actividad actividad2 = BuscarActividad(Actividad2);

       ColaTareas colaAuxiliar;

       colaAuxiliar = actividad1.getTareas();

       actividad1.setTareas(actividad2.getTareas());
       actividad2.setTareas(colaAuxiliar);

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

