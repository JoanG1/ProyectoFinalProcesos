package com.example.proyectofinal;

import com.example.proyectofinal.Estructuras.ColaTareas;
import com.example.proyectofinal.Estructuras.ListaEnlazadaActividades;
import com.example.proyectofinal.Estructuras.ListaEnlazadaProcesos;
import com.example.proyectofinal.LecturaUsuarios.LecturaUsuarios;
import com.example.proyectofinal.Usuarios.Rol;
import com.example.proyectofinal.Usuarios.Usuarios;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.util.Iterator;
import java.util.List;

public class HelloController {

    //Variables Clases

    private ListaEnlazadaProcesos listaProcesos;

    private ListaEnlazadaActividades listaActividades;

    private ColaTareas colaTareas;

    private int IdProcesos = 0;

    private Usuarios usuario;

    private LecturaUsuarios lectorUsuarios = new LecturaUsuarios();

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
    private TableView<Proceso> ListaProcesos;
    @FXML
    private TableView<Actividad> ListaActividades;
    @FXML
    private TableView<Tarea> ListadoTareas;

    //Inicio de sesion

        @FXML
        private AnchorPane PanelIngresarSesion;
            @FXML
            private TextField TextFieldNombreUsuario;
        @FXML
        private AnchorPane PanelRegistrarSesion;
            @FXML
            private TextField TextFieldNuevoUsuario;
            @FXML
            private CheckBox Admin;
            @FXML
            private CheckBox Regular;





    @FXML
    private AnchorPane PanelPrincipal;


    @FXML
    private AnchorPane PanelProcesos;
      @FXML
      private AnchorPane PanelCrearProceso;
      @FXML
      private TextField TextFieldNombreProceso;
      @FXML
      private Button CrearProceso;
      @FXML
      private TextField TextFieldActividadBuscarProceso;
      @FXML
      private AnchorPane PanelBuscarActividadProceso;
      @FXML
      private AnchorPane PanelBuscarProceso;
        @FXML
        private TextField TextFieldBuscarProceso;
      @FXML
      private AnchorPane PanelInformacionProceso;
      @FXML
      private TextField TextFieldInformacionProceso;
      @FXML
      private TextField TextFieldDuracionMinima;
      @FXML
      private TextField TextFieldDuracionMaxima;


    @FXML
    private AnchorPane PanelActividades;
      @FXML
      private Button CrearActividad;
      @FXML
      private AnchorPane PanelFiltroActividad;
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
    private AnchorPane PanelTareas;
        @FXML
        private AnchorPane PanelCreacionTareas;
        @FXML
        private TextField TextFieldNombreActividadTareas ;
        @FXML
        private Button CrearNuevaTarea;
        @FXML
        private AnchorPane PanelCreacionDeTareas2;
            @FXML
            private TextField TextFieldDescripcionTarea ;
            @FXML
            private CheckBox ObligatorioTarea ;
            @FXML
            private TextField TextFieldDuracionTarea ;
            @FXML
            private TextField TextFieldPosicionEncolar ;
            @FXML
            private CheckBox PorPosicion ;
            @FXML
            private CheckBox EncolarTareas ;


    //CONFIGURACION VISTA DE LAS LISTAS
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

    //INICIO DE SESION

    @FXML
    protected void IniciarSesion (){

        PanelIngresarSesion.setVisible(true);
    }
    @FXML
    protected void Registrarse (){

        PanelRegistrarSesion.setVisible(true);

    }
    @FXML
    protected void IngresoInicio (){

        if(!TextFieldNombreUsuario.getText().isEmpty()){
            PanelIngresarSesion.setVisible(false);
            usuario = lectorUsuarios.buscarUsuarioPorNombre(TextFieldNombreUsuario.getText());
            PanelPrincipal.setVisible(true);
        }

    }
    @FXML
    protected void IngresoNuevoInicio (){

        PanelRegistrarSesion.setVisible(false);
        if (Admin.isSelected()&&!Regular.isSelected()){
            usuario = new Usuarios(TextFieldNuevoUsuario.getText(), Rol.ADMIN);
            PanelPrincipal.setVisible(true);
            lectorUsuarios.guardarUsuario(usuario);

        } else if (Regular.isSelected()&&!Admin.isSelected()) {
            usuario = new Usuarios(TextFieldNuevoUsuario.getText(), Rol.USUARIO);

            PanelPrincipal.setVisible(true);
            CrearProceso.setDisable(true);
            CrearActividad.setDisable(true);
            CrearNuevaTarea.setDisable(true);

            lectorUsuarios.guardarUsuario(usuario);
        }

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


    //SISTEMAS DE PROCESOS

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
    protected void BuscarProceso (){

        PanelBuscarProceso.setVisible(true);

    }
    @FXML
    protected void BusquedaProceso (){

        if (!TextFieldBuscarProceso.getText().isEmpty()){

            Proceso proceso = listaProcesos.BuscarProceso(TextFieldBuscarProceso.getText());
            if(proceso != null){

                ListaProcesos.getItems().clear();
                ListaProcesos.getItems().add(proceso);
                PanelBuscarProceso.setVisible(false);
                PanelInformacionProceso.setVisible(true);
                TextFieldInformacionProceso.setText(proceso.getNombre());
                TextFieldDuracionMaxima.setText(""+proceso.getListaEnlazadaActividades().DuracionMaxima());
                TextFieldDuracionMinima.setText(""+proceso.getListaEnlazadaActividades().DuracionMinima());
                //proceso.getListaEnlazadaActividades().IntercambioActividades("a","b");

            }

        }

    }
    @FXML
    protected void SalirInformacionProceso (){

        PanelInformacionProceso.setVisible(false);
    }
    @FXML
    protected void PasarActividades () {

        PanelProcesos.setVisible(false);
        PanelActividades.setVisible(true);
        PanelFiltroActividad.setVisible(true);
    }


    //SISTEMAS DE ACTIVIDADES


    @FXML
    protected void EntrarActividades () {

        if(!FiltroProceso.getText().isEmpty()){

            listaActividades = listaProcesos.ListaDeActividadesDeProceso(FiltroProceso.getText());

            if (listaActividades != null){

                PanelFiltroActividad.setVisible(false);
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


        }



    }
    @FXML
    protected void CrearNuevaActividad (){

        PanelCrearActividad.setVisible(true);

    }
    @FXML
    protected void CreacionDeActividad (){

        Actividad nuevaActividad = new Actividad(NombreActividad.getText(),DescripcionActividad.getText(),ObligatorioActividad.isSelected());
        if(MetodoInsercionNormal.isSelected()&&!MetodoDespuesActividad.isSelected()&&!MetodoUltimoIngreso.isSelected()){

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
        else if (MetodoDespuesActividad.isSelected()&&!MetodoUltimoIngreso.isSelected()&&!MetodoInsercionNormal.isSelected()){

            if(ActividadPrecede.getText() != null){

                Boolean flag = listaActividades.insertarDespuesDeActividad(nuevaActividad,ActividadPrecede.getText());
                if (!flag){
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



            }else{
                error.setText("Debe de ingresar una actividad previa para insertar");
            }
        } else if (MetodoUltimoIngreso.isSelected()&&!MetodoInsercionNormal.isSelected()&&!MetodoDespuesActividad.isSelected()) {

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
    protected void BuscarActividad (){

        PanelBuscadorActividad.setVisible(true);

    }
    @FXML
    protected void buscadorActividad (){

        Actividad actividad = listaActividades.BuscarActividad(TextFieldBuscadorActividad.getText());
        if (actividad != null) {
            ListaActividades.getItems().clear();
            ListaActividades.getItems().add(actividad);
            PanelBuscadorActividad.setVisible(false);
        }

    }


    //SISTEMAS DE TAREAS

    @FXML
    protected void EntrarTareas () {

        if (!TextFieldNombreActividadTareas.getText().isEmpty()) {

            colaTareas = listaActividades.ListaDeTareasDeActividad(TextFieldNombreActividadTareas.getText());

            if (colaTareas != null){
                PanelCreacionTareas.setVisible(false);
                TextFieldNombreActividadTareas.clear();
                ListadoTareas.getItems().clear();
                Iterator<Tarea> iterator = colaTareas.iterator();
                while (iterator.hasNext()) {
                    Tarea tarea = iterator.next();
                    ListadoTareas.getItems().add(tarea);
                }

            }

        }

    }
    @FXML
    protected void crearNuevaTarea (){

        PanelActividades.setVisible(false);
        PanelTareas.setVisible(true);
        PanelCreacionTareas.setVisible(true);
    }
    @FXML
    protected void CrearNuevaTarea (){

        PanelCreacionDeTareas2.setVisible(true);

    }
    @FXML
    protected void CrearUnaTarea (){

        if(EncolarTareas.isSelected()&&!PorPosicion.isSelected()){

            if (!TextFieldDuracionTarea.getText().isEmpty()){
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

        } else if (!EncolarTareas.isSelected()&&PorPosicion.isSelected()) {

            if (!TextFieldDuracionTarea.getText().isEmpty()) {
                Tarea tarea = new Tarea(TextFieldDescripcionTarea.getText(), ObligatorioTarea.isSelected(), Integer.parseInt(TextFieldDuracionTarea.getText()));
                colaTareas.insertarEnPosicion(tarea, Integer.parseInt(TextFieldPosicionEncolar.getText()));
                Iterator<Tarea> iterator = colaTareas.iterator();
                ListadoTareas.getItems().clear();
                colaTareas.imprimirCola();
                while (iterator.hasNext()) {
                    Tarea tareas = iterator.next();
                    ListadoTareas.getItems().add(tareas);
                }
                PanelCreacionDeTareas2.setVisible(false);
                TextFieldDuracionTarea.clear();
                TextFieldDescripcionTarea.clear();
                ObligatorioTarea.setSelected(false);
            }
        }


    }
    @FXML
    protected void BuscarTarea (){

    }

    //BOTONES PARA CAMBIO DE PANELES
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


    //BOTONES PARA CERRAR PANELES
    @FXML
    protected void SalirIngresarSesion () {
        PanelIngresarSesion.setVisible(false);


    }
    @FXML
    protected void SalirRegistrarSesion () {
        PanelRegistrarSesion.setVisible(false);


    }
    @FXML
    protected void SalirCrearProceso () {
        PanelCrearProceso.setVisible(false);


    }
    @FXML
    protected void SalirBuscarActividadProceso () {
        PanelBuscarActividadProceso.setVisible(false);


    }
    @FXML
    protected void SalirBuscarProceso () {
        PanelBuscarProceso.setVisible(false);


    }
    @FXML
    protected void SalirFiltroActividad () {
        PanelFiltroActividad.setVisible(false);


    }
    @FXML
    protected void SalirCrearActividad () {
        PanelCrearActividad.setVisible(false);


    }
    @FXML
    protected void SalirBuscadorActividad () {
        PanelBuscadorActividad.setVisible(false);


    }
    @FXML
    protected void SalirCreacionTareas () {
        PanelCreacionTareas.setVisible(false);


    }
    @FXML
    protected void SalirCreacionDeTareas2 () {
        PanelCreacionDeTareas2.setVisible(false);


    }



}