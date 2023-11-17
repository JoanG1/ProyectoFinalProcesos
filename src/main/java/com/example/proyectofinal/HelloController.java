package com.example.proyectofinal;

import com.example.proyectofinal.Estructuras.ColaTareas;
import com.example.proyectofinal.Estructuras.ListaEnlazadaActividades;
import com.example.proyectofinal.Estructuras.ListaEnlazadaProcesos;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.Iterator;

public class HelloController {

    //Variables Clases

    private ListaEnlazadaProcesos listaProcesos;

    private ListaEnlazadaActividades listaActividades;

    private ColaTareas colaTareas;

    private int IdProcesos = 0;

    private TableColumn<Proceso, String> colNombre = new TableColumn<>("Nombre");
    private TableColumn<Proceso, String> colApellido = new TableColumn<>("Id");

    private TableColumn<Actividad, String> colNombreActividad = new TableColumn<>("Nombre");
    private TableColumn<Actividad, String> colDescripcionActividad = new TableColumn<>("Descripcion");
    private TableColumn<Actividad, Boolean> colObligatorio = new TableColumn<>("Obligatorio");

    private TableColumn<Tarea, String> colDescripcionTarea = new TableColumn<>("Descripcion");
    private TableColumn<Tarea, Boolean> colObligatorioTarea = new TableColumn<>("Obligatorio");
    private TableColumn<Tarea, Integer> colDuracionTarea = new TableColumn<>("Duracion");




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
    private Button CrearActividad;
    @FXML
    private Button BuscarActividad;
    @FXML
    private TableView<Actividad> ListaActividades;
    @FXML
    private Button BuscarTarea;
    @FXML
    private TableView<Tarea> ListadoTareas;
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
      private AnchorPane PanelBuscarProceso;
        @FXML
        private TextField TextFieldBuscarProceso;



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
        private AnchorPane PanelBuscadorActividad;
          @FXML
          private TextField TextFieldBuscadorActividad ;
          @FXML
          private Button BuscadorActividad;
          @FXML
          private Button CreacionActividad;

    @FXML
    private AnchorPane PanelTareas;
        @FXML
        private AnchorPane PanelCreacionTareas;
        @FXML
        private TextField TextFieldNombreActividadTareas ;
        @FXML
        private Button CrearTarea;
        @FXML
        private AnchorPane PanelCreacionDeTareas2;
            @FXML
            private TextField TextFieldDescripcionTarea ;
            @FXML
            private CheckBox ObligatorioTarea ;
            @FXML
            private TextField TextFieldDuracionTarea ;



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

        ListadoTareas.getColumns().addAll(colDescripcionTarea,colObligatorioTarea,colDuracionTarea);

        colDescripcionTarea.setCellValueFactory(new PropertyValueFactory<>("Descripcion"));
        colDescripcionTarea.setPrefWidth(260);
        colObligatorioTarea.setCellValueFactory(new PropertyValueFactory<>("Obligatorio"));
        colObligatorioTarea.setPrefWidth(170);
        colDuracionTarea.setCellValueFactory(new PropertyValueFactory<>("Duracion"));
        colDuracionTarea.setPrefWidth(140);

    }

    @FXML

    protected void ImportarProyecto (){

    }
    @FXML

    protected void BuscarProceso (){

        PanelBuscarProceso.setVisible(true);

    }

    @FXML

    protected void BusquedaProceso (){

        ListaProcesos.getItems().clear();
        ListaProcesos.getItems().add(listaProcesos.BuscarProceso(TextFieldBuscarProceso.getText()));
        PanelBuscarProceso.setVisible(false);


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
        Iterator<Proceso> iterator = listaProcesos.iterator();
        ListaProcesos.getItems().clear();
        while (iterator.hasNext()){
            Proceso proceso = iterator.next();
            ListaProcesos.getItems().add(proceso);
        }
        PanelCrearProceso.setVisible(false);
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

        PanelBuscadorActividad.setVisible(true);

    }

    @FXML

    protected void buscadorActividad (){

        ListaActividades.getItems().clear();
        ListaActividades.getItems().add(listaActividades.BuscarActividad(TextFieldBuscadorActividad.getText()));
        PanelBuscadorActividad.setVisible(false);

    }

    @FXML

    protected void crearNuevaTarea (){

        PanelActividades.setVisible(false);
        PanelTareas.setVisible(true);
        PanelCreacionTareas.setVisible(true);
    }

    @FXML

    protected void EntrarTareas (){

    PanelCreacionTareas.setVisible(false);
    colaTareas = listaActividades.ListaDeTareasDeActividad(TextFieldNombreActividadTareas.getText());
    TextFieldNombreActividadTareas.clear();
    ListadoTareas.getItems().clear();
    Iterator<Tarea> iterator = colaTareas.iterator();
        while (iterator.hasNext()){
            Tarea tarea = iterator.next();
            ListadoTareas.getItems().add(tarea);
        }

        //listaActividades.ListaDeTareasDeActividad(TextFieldNombreActividadTareas.getText()).imprimirCola();
    }

    @FXML

    protected void CrearUnaTarea (){

        Tarea tarea = new Tarea(TextFieldDescripcionTarea.getText(),ObligatorioTarea.isSelected(),Integer.parseInt(TextFieldDuracionTarea.getText()));
        colaTareas.encolar(tarea);
        Iterator<Tarea> iterator = colaTareas.iterator();
        ListadoTareas.getItems().clear();
        colaTareas.imprimirCola();
        while (iterator.hasNext()){
            Tarea tareas = iterator.next();
            ListadoTareas.getItems().add(tareas);
        }
        PanelCreacionDeTareas2.setVisible(false);
        TextFieldDuracionTarea.clear();
        TextFieldDescripcionTarea.clear();
        ObligatorioTarea.setSelected(false);

    }

    @FXML

    protected void BuscarTarea (){

    }
    @FXML

    protected void CrearNuevaTarea (){

        PanelCreacionDeTareas2.setVisible(true);

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