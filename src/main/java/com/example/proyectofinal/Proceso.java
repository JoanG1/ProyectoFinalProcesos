package com.example.proyectofinal;

import com.example.proyectofinal.Estructuras.ColaTareas;
import com.example.proyectofinal.Estructuras.ListaEnlazadaActividades;

public class Proceso {

    private int Id;
    private String Nombre ;
    private ListaEnlazadaActividades listaEnlazadaActividades = new ListaEnlazadaActividades();

    public Proceso (int Id, String Nombre){

        this.Id = Id;
        this.Nombre = Nombre;
    }

    //METODOS GETTERS Y SETTERS


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public ListaEnlazadaActividades getListaEnlazadaActividades() {
        return listaEnlazadaActividades;
    }

    public void setListaEnlazadaActividades(ListaEnlazadaActividades listaEnlazadaActividades) {
        this.listaEnlazadaActividades = listaEnlazadaActividades;
    }

    public void ImprimirActividades (){
        listaEnlazadaActividades.imprimirLista();
    }
}
