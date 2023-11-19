package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Tarea;

import java.util.Iterator;

public class ColaTareas implements Iterable<Tarea> {

    public NodoTarea nodoPrimero, nodoUltimo;
    public int tamanio;
    public int DuracionTotal;

    /**
     * Agrega un elemento en la Cola
     *
     * @param dato elemento a guardar en la Cola
     */
    public void encolar(Tarea dato) {

        NodoTarea nodo = new NodoTarea(dato);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nodo;
        } else {
            nodoUltimo.setSiguiente(nodo);
            nodoUltimo = nodo;
        }

        DuracionTotal += nodo.getTarea().getDuracion();
        tamanio++;
    }


    /**
     * Agrega un elemento por una posicion especifica
     * @param dato
     * @param posicion
     */
    public void insertarEnPosicion(Tarea dato, int posicion) {
        if (posicion < 0 || posicion > tamanio) {
            throw new IllegalArgumentException("Posición inválida");
        }

        NodoTarea nuevoNodo = new NodoTarea(dato);

        if (posicion == 0) {
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero = nuevoNodo;
            DuracionTotal += nuevoNodo.getTarea().getDuracion();
            if (estaVacia()) {
                nodoUltimo = nuevoNodo;
                DuracionTotal += nuevoNodo.getTarea().getDuracion();
            }
        } else if (posicion == tamanio) {
            encolar(dato); // Si la posición es igual al tamaño, simplemente encolamos el elemento.
        } else {
            NodoTarea anterior = nodoPrimero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.getSiguiente();
            }
            NodoTarea siguiente = anterior.getSiguiente();

            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(siguiente);
            tamanio++;
            DuracionTotal += nuevoNodo.getTarea().getDuracion();

        }
    }

    /**
     * Verifica si la Cola est� vac�a
     * @return true si est� vac�a
     */
    public boolean estaVacia() {
        return nodoPrimero == null;
    }


    /**
     * Borra completamente la Cola
     */
    public void borrarCola() {
        nodoPrimero = nodoUltimo = null;
        tamanio = 0;
    }

    /**
     * @return the primero
     */
    public NodoTarea getPrimero() {
        return nodoPrimero;
    }

    /**
     * @return the ultimo
     */
    public NodoTarea getUltimo() {
        return nodoUltimo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamanio;
    }

    public void imprimirCola (){

        NodoTarea nodoActual = nodoPrimero;


        while (nodoActual != null) {
            System.out.print(nodoActual.getTarea().getDuracion() + " min : " + nodoActual.getTarea().getDescripcion() +  "\n"); // Suponiendo que Tarea tiene un método toString() adecuado

            nodoActual = nodoActual.getSiguiente();

            System.out.println("Duracion Total: "+DuracionTotal);
            System.out.println(); // Para imprimir un salto de línea al final
        }

    }

    public Tarea buscadorTarea (String Tarea){

        Iterator<Tarea> iterator = iterator();

        while (iterator.hasNext()){

            Tarea tarea = iterator.next();

            if(tarea.getDescripcion().equals(Tarea)){
                System.out.println("Tarea: "+tarea.getDescripcion());
                return tarea;

            }

        }

        return null;
    }


    @Override
    public Iterator<Tarea> iterator() {
        return new TareaIterator();
    }

    private class TareaIterator implements Iterator<Tarea> {
        private NodoTarea current = nodoPrimero;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Tarea next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Tarea tarea = current.getTarea();
            current = current.getSiguiente();
            return tarea;
        }

        // Puedes implementar el método remove si lo necesitas, pero en este caso, no lo estamos utilizando.
        // @Override
        // public void remove() {
        //     throw new UnsupportedOperationException();
    }   // }
}
