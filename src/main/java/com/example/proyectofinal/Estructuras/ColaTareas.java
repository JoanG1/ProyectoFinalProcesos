package com.example.proyectofinal.Estructuras;

public class ColaTareas<Tarea> {

    public NodoTarea<Tarea> nodoPrimero, nodoUltimo;
    private int tamanio;

    /**
     * Agrega un elemento en la Cola
     *
     * @param dato elemento a guardar en la Cola
     */
    public void encolar(Tarea dato) {

        NodoTarea<Tarea> nodo = new NodoTarea<>(dato);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nodo;
        } else {
            nodoUltimo.setSiguiente(nodo);
            nodoUltimo = nodo;
        }

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

        NodoTarea<Tarea> nuevoNodo = new NodoTarea<>(dato);

        if (posicion == 0) {
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero = nuevoNodo;
            if (estaVacia()) {
                nodoUltimo = nuevoNodo;
            }
        } else if (posicion == tamanio) {
            encolar(dato); // Si la posición es igual al tamaño, simplemente encolamos el elemento.
        } else {
            NodoTarea<Tarea> anterior = nodoPrimero;
            for (int i = 0; i < posicion - 1; i++) {
                anterior = anterior.getSiguiente();
            }
            NodoTarea<Tarea> siguiente = anterior.getSiguiente();

            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(siguiente);
            tamanio++;
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
    public NodoTarea<Tarea> getPrimero() {
        return nodoPrimero;
    }

    /**
     * @return the ultimo
     */
    public NodoTarea<Tarea> getUltimo() {
        return nodoUltimo;
    }

    /**
     * @return the tamano
     */
    public int getTamano() {
        return tamanio;
    }
}
