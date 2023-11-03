package com.example.proyectofinal;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
        Proceso proceso = new Proceso(1, "Mantenimiento pc");

        Actividad actividad = new Actividad("Analisis", "Actividad encargada en el analisis del computador fisicamente y reviar que daños tiene",true);
        Tarea tarea = new Tarea("Desarmar dispositivo", true, 10);
        Tarea tarea2 = new Tarea("Desconectar componentes", true, 20);
        Tarea tarea3 = new Tarea("Conectar Componentes", true, 15);
        Tarea tarea4 = new Tarea("Limpiar Componentes", true, 30);

        proceso.getListaEnlazadaActividades().insertar(actividad);
        proceso.ImprimirActividades();

        actividad.getTareas().encolar(tarea);
        actividad.getTareas().encolar(tarea2);
        actividad.getTareas().insertarEnPosicion(tarea3,2);
        actividad.getTareas().insertarEnPosicion(tarea4,2);
        actividad.ImprimirTareas();
    }
}