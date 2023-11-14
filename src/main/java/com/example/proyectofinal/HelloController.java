package com.example.proyectofinal;

import com.example.proyectofinal.Estructuras.ListaEnlazadaActividades;
import com.example.proyectofinal.Estructuras.ListaEnlazadaProcesos;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

import java.util.Iterator;

public class HelloController {

    //Variables Clases

    private ListaEnlazadaProcesos listaProcesos;

    private ListaEnlazadaActividades listaActividades;

    private int IdProcesos = 0;

    private TableColumn<Proceso, String> colNombre = new TableColumn<>("Nombre");
    private TableColumn<Proceso, String> colApellido = new TableColumn<>("Id");

    private TableColumn<Actividad, String> colNombreActividad = new TableColumn<>("Nombre");
    private TableColumn<Actividad, String> colDescripcionActividad = new TableColumn<>("Descripcion");
    private TableColumn<Actividad, Boolean> colObligatorio = new TableColumn<>("Obligatorio");




    //Variables UI

    @FXML
    private Button ImportarProyecto;
    @FXML
    private Button NuevoProyecto;
    @FXML
    private Button BuscarProceso;
    @FXML
    private Button CrearProceso;
    @FXML
    private Button ActividadesEnProceso;
    @FXML
    private TableView<Proceso> ListaProcesos;
    @FXML
    private TableColumn<Proceso,String> columnaNombreProceso;
    @FXML
    private TableColumn<Proceso,String> columnaIdProcesos;

    @FXML
    private TableColumn<Proceso,String> columnax;

    @FXML
    private Button CrearActividad;
    @FXML
    private Button BuscarActividad;
    @FXML
    private TableView<Actividad> ListaActividades;
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
    private AnchorPane PanelPrincipal;
    @FXML
    private AnchorPane PanelProcesos;
      @FXML
      private AnchorPane PanelCrearProceso;
      @FXML
      private TextField TextFieldNombreProceso;
      @FXML
      private Button CreacionProceso;
      @FXML
      private TextField TextFieldActividadBuscarProceso;
      @FXML
      private AnchorPane PanelBuscarActividadProceso;


    @FXML
    private AnchorPane PanelActividades;
      @FXML
      private AnchorPane PanelFiltroActividad;
      @FXML
      private Button EntrarActividad;
      @FXML
      private TextField FiltroProceso;
      @FXML
      private AnchorPane PanelCrearActividad;
        @FXML
        private TextField NombreActividad ;
        @FXML
        private TextField DescripcionActividad ;
        @FXML
        private CheckBox ObligatorioActividad ;
        @FXML
        private CheckBox MetodoInsercionNormal ;
        @FXML
        private CheckBox MetodoDespuesActividad ;
        @FXML
        private CheckBox MetodoUltimoIngreso ;
        @FXML
        private TextField ActividadPrecede ;
        @FXML
        private Label error ;

      @FXML
      private Button CreacionActividad;




    @FXML
    private AnchorPane PanelTareas;



    /*@FXML
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
    */

    @FXML

    protected void CrearNuevoProyecto (){

        listaProcesos = new ListaEnlazadaProcesos();
        PanelPrincipal.setVisible(false);
        PanelProcesos.setVisible(true);
        ListaProcesos.getColumns().addAll(colNombre,colApellido);

        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colNombre.setPrefWidth(170);
        colApellido.setCellValueFactory(new PropertyValueFactory<>("id"));

        ListaActividades.getColumns().addAll(colNombreActividad,colDescripcionActividad,colObligatorio);

        colNombreActividad.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colNombreActividad.setPrefWidth(170);
        colDescripcionActividad.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
        colDescripcionActividad.setPrefWidth(200);
        colObligatorio.setCellValueFactory(new PropertyValueFactory<>("Obligatorio"));
        colObligatorio.setPrefWidth(170);

    }

    @FXML

    protected void ImportarProyecto (){

    }
    @FXML

    protected void BuscarProceso (){

    }
    @FXML

    protected void CrearNuevoProceso (){

        PanelCrearProceso.setVisible(true);
    }

    @FXML

    protected void CreacionDeProceso () {

        Proceso nuevoProceso = new Proceso(IdProcesos, TextFieldNombreProceso.getText());
        listaProcesos.insertar(nuevoProceso);
        listaProcesos.imprimirLista();
        PanelCrearProceso.setVisible(false);
        ListaProcesos.getItems().add(nuevoProceso);
        IdProcesos++;
        TextFieldNombreProceso.clear();

    }

    @FXML
    protected void CreacionDeActividad (){

        Actividad nuevaActividad = new Actividad(NombreActividad.getText(),DescripcionActividad.getText(),ObligatorioActividad.isSelected());
        if(MetodoInsercionNormal.isSelected()){

            listaActividades.insertar(nuevaActividad);
            Iterator<Actividad> iterator = listaActividades.iterator();
            ListaActividades.getItems().clear();
            listaActividades.imprimirLista();
            while (iterator.hasNext()){
                Actividad actividad = iterator.next();
                ListaActividades.getItems().add(actividad);
            }
            NombreActividad.clear();
            DescripcionActividad.clear();
            ObligatorioActividad.setSelected(false);
            PanelCrearActividad.setVisible(false);
            ActividadPrecede.clear();
            MetodoInsercionNormal.setSelected(false);
        }
        else if (MetodoDespuesActividad.isSelected()){

            if(ActividadPrecede.getText() != null){

                listaActividades.insertarDespuesDeActividad(nuevaActividad,ActividadPrecede.getText());
                Iterator<Actividad> iterator = listaActividades.iterator();
                ListaActividades.getItems().clear();
                listaActividades.imprimirLista();
                while (iterator.hasNext()){
                    Actividad actividad = iterator.next();
                    ListaActividades.getItems().add(actividad);
                }
                NombreActividad.clear();
                DescripcionActividad.clear();
                ObligatorioActividad.setSelected(false);
                PanelCrearActividad.setVisible(false);
                ActividadPrecede.clear();
                MetodoDespuesActividad.setSelected(false);


            }else{
                error.setText("Debe de ingresar una actividad previa para insertar");
            }
        } else if (MetodoUltimoIngreso.isSelected()) {

            listaActividades.insertarDespuesDeUltimoIngreso(nuevaActividad);
            Iterator<Actividad> iterator = listaActividades.iterator();
            ListaActividades.getItems().clear();
            listaActividades.imprimirLista();
            while (iterator.hasNext()){
                Actividad actividad = iterator.next();
                ListaActividades.getItems().add(actividad);
            }
            NombreActividad.clear();
            DescripcionActividad.clear();
            ObligatorioActividad.setSelected(false);
            PanelCrearActividad.setVisible(false);
            ActividadPrecede.clear();
            MetodoDespuesActividad.setSelected(false);

        }

    }
    @FXML

    protected void CrearNuevaActividad (){

        PanelCrearActividad.setVisible(true);

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

    @FXML

    protected void PasarActividades () {

        PanelProcesos.setVisible(false);
        PanelActividades.setVisible(true);
        PanelFiltroActividad.setVisible(true);
    }

    @FXML

    protected void EntrarActividades () {

        PanelFiltroActividad.setVisible(false);
        listaActividades = listaProcesos.ListaDeActividadesDeProceso(FiltroProceso.getText());
        FiltroProceso.clear();
        ListaActividades.getItems().clear();
        //Refactorizar volverlo solo un metodo
        Iterator<Actividad> iterator = listaActividades.iterator();
        while (iterator.hasNext()){
            Actividad actividad = iterator.next();
            ListaActividades.getItems().add(actividad);
        }

        //listaProcesos.ListaDeActividadesDeProceso(FiltroProceso.getText()).imprimirLista();

    }

    @FXML
    protected void BuscarActividadEnProceso () {

        PanelBuscarActividadProceso.setVisible(true);
    }

    @FXML
    protected void BusquedaActividadProceso(){


        listaProcesos.buscarActividad(TextFieldActividadBuscarProceso.getText());
        PanelBuscarActividadProceso.setVisible(false);
    }

    @FXML
    protected void SigInicio () {
        PanelProcesos.setVisible(false);
        PanelActividades.setVisible(true);
    }

    @FXML
    protected void SigActividades () {
        PanelActividades.setVisible(false);
        PanelTareas.setVisible(true);
    }
    @FXML
    protected void AntActividades () {
        PanelActividades.setVisible(false);
        PanelProcesos.setVisible(true);
    }
    @FXML
    protected void AntTareas () {
        PanelTareas.setVisible(false);
        PanelActividades.setVisible(true);


    }

}