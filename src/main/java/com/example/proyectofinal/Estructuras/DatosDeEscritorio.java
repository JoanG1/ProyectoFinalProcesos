package com.example.proyectofinal.Estructuras;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Proceso;
import com.example.proyectofinal.Tarea;

public class DatosDeEscritorio {

    public ListaEnlazadaProcesos listaEnlazadaProcesos = new ListaEnlazadaProcesos();

    public DatosDeEscritorio(){

    }

    //Inicializacion de datos para pruebas

    Proceso proceso1 = new Proceso(0, "Mantenimiento pc");
    Proceso proceso2 = new Proceso(0, "Mantenimiento tv");

    Actividad actividad1 = new Actividad("Analisis","Analizar componentes",true);
    Actividad actividad2 = new Actividad("Desarmar","Desarmar pc",false);
    Actividad actividad3 = new Actividad("Costos", "Sumar costos",true);
    Actividad actividad7 = new Actividad("Entregar","Entregar pc",false);

    Actividad actividad4 = new Actividad("Analisis","Analizar tv",true);
    Actividad actividad5 = new Actividad("Desarmar","Desarmar tv",false);
    Actividad actividad6 = new Actividad("Calcular","Calcular costos",true);
    Actividad actividad8 = new Actividad("Entregar","Entregar tv",true);

    Tarea tarea1 = new Tarea("Analizar cada componente meticulosamente",true,20);
    Tarea tarea2 = new Tarea("Analizar sus fallos",true,30);
    Tarea tarea3 = new Tarea("Separar los dañados",false,15);

    Tarea tarea4 = new Tarea("Desarmar paso a paso el pc",true,15);
    Tarea tarea5 = new Tarea("Separar piezas por tipo" , false, 20);
    Tarea tarea6 = new Tarea("Etiquetar piezas", true, 10);

    Tarea tarea7 = new Tarea("Averiguar costos", true, 10);
    Tarea tarea8 = new Tarea("Analizar Sobrecosto", false, 25);
    Tarea tarea9 = new Tarea("Sacar Factura", true, 10);

    Tarea tarea10= new Tarea("Averiguar costos", false, 25);
    Tarea tarea11 = new Tarea("Analizar Sobrecosto", true, 10);
    Tarea tarea12 = new Tarea("Realizar Factura", true, 10);

    //Mantenimiento tv

    Tarea tarea13 = new Tarea("Analizar cada componente meticulosamente",true,20);
    Tarea tarea14 = new Tarea("Analizar sus fallos",true,30);
    Tarea tarea15 = new Tarea("Separar los dañados",false,15);

    Tarea tarea16 = new Tarea("Desarmar paso a paso el tv",true,15);
    Tarea tarea17 = new Tarea("Separar piezas por tipo" , false, 20);
    Tarea tarea18 = new Tarea("Etiquetar piezas", true, 10);

    Tarea tarea19 = new Tarea("Averiguar costos", true, 10);
    Tarea tarea20 = new Tarea("Analizar Sobrecosto", false, 25);
    Tarea tarea21 = new Tarea("Sacar Factura", true, 10);

    Tarea tarea22= new Tarea("Averiguar costos", false, 25);
    Tarea tarea23 = new Tarea("Analizar Sobrecosto", true, 10);
    Tarea tarea24 = new Tarea("Realizar Factura", true, 10);

    public void llenarListas (){

        actividad1.getTareas().encolar(tarea1);
        actividad1.getTareas().encolar(tarea2);
        actividad1.getTareas().encolar(tarea3);

        actividad2.getTareas().encolar(tarea4);
        actividad2.getTareas().encolar(tarea5);
        actividad2.getTareas().encolar(tarea6);

        actividad3.getTareas().encolar(tarea7);
        actividad3.getTareas().encolar(tarea8);
        actividad3.getTareas().encolar(tarea9);

        actividad7.getTareas().encolar(tarea10);
        actividad7.getTareas().encolar(tarea11);
        actividad7.getTareas().encolar(tarea12);

        actividad4.getTareas().encolar(tarea13);
        actividad4.getTareas().encolar(tarea14);
        actividad4.getTareas().encolar(tarea15);

        actividad5.getTareas().encolar(tarea16);
        actividad5.getTareas().encolar(tarea17);
        actividad5.getTareas().encolar(tarea18);

        actividad6.getTareas().encolar(tarea19);
        actividad6.getTareas().encolar(tarea20);
        actividad6.getTareas().encolar(tarea21);

        actividad8.getTareas().encolar(tarea22);
        actividad8.getTareas().encolar(tarea23);
        actividad8.getTareas().encolar(tarea24);





        proceso1.getListaEnlazadaActividades().insertar(actividad1);
        proceso1.getListaEnlazadaActividades().insertar(actividad2);
        proceso1.getListaEnlazadaActividades().insertar(actividad3);
        proceso1.getListaEnlazadaActividades().insertar(actividad7);

        proceso2.getListaEnlazadaActividades().insertar(actividad4);
        proceso2.getListaEnlazadaActividades().insertar(actividad5);
        proceso2.getListaEnlazadaActividades().insertar(actividad6);
        proceso2.getListaEnlazadaActividades().insertar(actividad8);

        listaEnlazadaProcesos.insertar(proceso1);
        listaEnlazadaProcesos.insertar(proceso2);


    }
}
