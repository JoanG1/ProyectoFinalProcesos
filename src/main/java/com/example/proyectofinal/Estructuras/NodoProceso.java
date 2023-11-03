package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Proceso;

public class NodoProceso {

    public Proceso Proceso;
    public NodoProceso siguiente;

    public NodoProceso (Proceso Proceso){
        this.Proceso = Proceso;
    }

    //METODOS GETTERS Y SETTERS


    public com.example.proyectofinal.Proceso getProceso() {
        return Proceso;
    }

    public void setProceso(com.example.proyectofinal.Proceso proceso) {
        Proceso = proceso;
    }

    public NodoProceso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProceso siguiente) {
        this.siguiente = siguiente;
    }
}
