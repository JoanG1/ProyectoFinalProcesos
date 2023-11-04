package com.example.proyectofinal;

import com.example.proyectofinal.Estructuras.ListaEnlazadaProcesos;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button ImportarProyecto;
    @FXML
    private Button NuevoProyecto;
    @FXML
    private Button BuscarProceso;
    @FXML
    private Button CrearProceso;
    @FXML
    private TableView ListaProcesos;
    @FXML
    private TableColumn columnaNombreProceso;
    @FXML
    private TableColumn columnaIdProcesos;
    @FXML
    private Button CrearActividad;
    @FXML
    private Button BuscarActividad;
    @FXML
    private TableView ListaActividades;
    @FXML
    private TableColumn columnaNombreActividad;
    @FXML
    private TableColumn columnaIdActividad;
    @FXML
    private Button CrearTarea;
    @FXML
    private Button BuscarTarea;
    @FXML
    private TableView ListadoTareas;
    @FXML
    private TableColumn columnaNombreTareas;
    @FXML
    private TableColumn columnaIdTareas;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");

        ListaEnlazadaProcesos listaProcesos = new ListaEnlazadaProcesos();

        Proceso proceso = new Proceso(1, "Mantenimiento pc");

        Proceso proceso1 = new Proceso(2, "Mantenimiento tv");

        Actividad actividad = new Actividad("Analisis", "Actividad encargada en el analisis del computador fisicamente y reviar que daños tiene", true);
        Actividad actividad2 = new Actividad("Entrega", "Actividad encargada de entrega al cliente", true);
        Actividad actividad3 = new Actividad("Cobro", "Actividad encargada de cobrar el trabajo", true);
        Actividad actividad4 = new Actividad("Mantenimiento", "Mantenimiento de pc", true);

        Actividad actividad5 = new Actividad("Desarmar", "Desarmar el dispositivo", true);

        Tarea tarea = new Tarea("Desarmar dispositivo", true, 10);
        Tarea tarea2 = new Tarea("Desconectar componentes", true, 20);
        Tarea tarea3 = new Tarea("Conectar Componentes", true, 15);
        Tarea tarea4 = new Tarea("Limpiar Componentes", true, 30);

        Tarea tarea5 = new Tarea("Desconectar cables", true,20);


        proceso.getListaEnlazadaActividades().insertar(actividad);
        proceso.getListaEnlazadaActividades().insertar(actividad2);
        proceso.getListaEnlazadaActividades().insertarDespuesDeActividad(actividad3, "Analisis");
        proceso.getListaEnlazadaActividades().insertarDespuesDeUltimoIngreso(actividad4);
        proceso.getListaEnlazadaActividades().insertar(actividad5);

        proceso1.getListaEnlazadaActividades().insertar(actividad5);

        actividad.getTareas().encolar(tarea);
        actividad.getTareas().encolar(tarea2);
        actividad.getTareas().insertarEnPosicion(tarea3, 2);
        actividad.getTareas().insertarEnPosicion(tarea4, 2);

        actividad5.getTareas().encolar(tarea5);

        listaProcesos.insertar(proceso);
        listaProcesos.insertar(proceso1);

        listaProcesos.imprimirLista();

        listaProcesos.buscarActividad("Desarmar");

        //listaProcesos.buscarTareaEnProcesos("Mantenimiento pc","Analisis","Desarmar dispositivo");

        listaProcesos.buscarTareaEnProcesos("", "","Desconectar cables");

        proceso.getListaEnlazadaActividades().buscarTareaEnActividad("Analisis","Limpiar Componentes");
    }

    @FXML

    protected void CrearNuevoProyecto (){

    }

    @FXML

    protected void ImportarProyecto (){

    }
    @FXML

    protected void BuscarProceso (){

    }
    @FXML

    protected void CrearNuevoProceso (){

    }
    @FXML

    protected void CrearNuevaActividad (){

    }

    @FXML

    protected void BuscarActividad (){

    }

    @FXML

    protected void BuscarTarea (){

    }
    @FXML

    protected void CrearNuevaTarea (){

    }
}