package com.example.proyectofinal;

import com.example.proyectofinal.Actividad;
import com.example.proyectofinal.Estructuras.ColaTareas;
import com.example.proyectofinal.Estructuras.ListaEnlazadaActividades;
import com.example.proyectofinal.Estructuras.ListaEnlazadaProcesos;
import com.example.proyectofinal.Proceso;
import com.example.proyectofinal.Tarea;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImportacionExcel {

    public ImportacionExcel (){

    }

    public ListaEnlazadaProcesos leerProcesosDesdeExcel(String ruta) throws IOException {
        ListaEnlazadaProcesos listaProcesos = new ListaEnlazadaProcesos();
        //SimpleList<Process> procesos = new SimpleList<Process>();

        //Aqui se abre el flujo de INGRESO DE DATOS
        FileInputStream inputStream = new FileInputStream(ruta);
        Workbook workbook = new HSSFWorkbook(inputStream);

        //FOR QUE RECORRE EL NUMERO DE HOJAS DEL ARCHIVO ENCONTRADO
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);

            //Indice para la fila
            int indexRow = 1;
            Row row;

            //MIENTRAS ESTE POSICIONADO EN UNA FILA PERMITIDA
            while ((row = sheet.getRow(indexRow)) != null) {
                // Leer las celdas de la fila y procesarlas.

                Cell headerCell = row.getCell(0);

                //VALIDAMOS QUE NO SE ESTE BUSCANDO UNA CELDA LLAMADA ACTIVIDAD
                if ((headerCell != null) && headerCell.getStringCellValue().equals("Activity Name")) {
                    break;
                }
                //COMPROBAR QUE LA FILA TENGA 2 CELDAS VALIDAS
                if (row.getPhysicalNumberOfCells() >= 2) {

                    //TOMAMOS LOS DATOS DE LA FILA
                    String id = row.getCell(0).getStringCellValue();
                    String nombre = row.getCell(1).getStringCellValue();
                    Proceso proceso = new Proceso(Integer.parseInt(id), nombre);


                    // Ahora, verifica si hay actividades y procesa las actividades y tareas.
                    int indexRowAct = indexRow + 2;
                    Row activityRow;
                    while ((activityRow = sheet.getRow(indexRowAct)) != null
                            && activityRow.getPhysicalNumberOfCells() >= 3) {
                        String activityName = activityRow.getCell(0).getStringCellValue();
                        String activityDescription = activityRow.getCell(1).getStringCellValue();
                        String actividadObligacion = activityRow.getCell(2).getStringCellValue();
                        Actividad activity = new Actividad(activityName, activityDescription, false);
                        if(actividadObligacion.equals("TRUE")){
                            activity = new Actividad(activityName, activityDescription, true);
                        }
                        proceso.getListaEnlazadaActividades().insertar(activity);

                        // Avanzar al siguiente índice de fila.
                        indexRowAct++;

                        // Verificar y procesar las tareas (si las hay).
                        Row taskRow;

                        do {
                            taskRow = sheet.getRow(indexRowAct);

                            if (taskRow == null || taskRow.getPhysicalNumberOfCells() < 3) {
                                // La fila no cumple con los requisitos mínimos para ser una fila de tarea, sal
                                // del bucle.
                                break;
                            }
                            Cell cell1 = taskRow.getCell(0);
                            if(cell1.getStringCellValue().equals("Activity Name")){
                                indexRowAct++;
                                break;
                            }

                            // Comprueba si esta fila es una tarea y no una actividad.
                            Cell cell0 = taskRow.getCell(0);
                            if (cell0 != null && cell0.getStringCellValue().equals("Task Description")) {
                                // Es un encabezado de tarea, salta al siguiente índice de fila.
                                indexRowAct++;
                                continue;
                            }

                            String taskDescription = taskRow.getCell(0).getStringCellValue();
                            String taskObligatorio = taskRow.getCell(1).getStringCellValue();
                            String taskDuracion = taskRow.getCell(2).getStringCellValue();
                            Tarea tarea = new Tarea(taskDescription, false, Integer.parseInt(taskDuracion));
                            if(taskObligatorio.equals("TRUE")){
                                tarea = new Tarea(taskDescription, true, Integer.parseInt(taskDuracion));
                            }
                            activity.getTareas().encolar(tarea);

                            // Avanzar al siguiente índice de fila.
                            indexRowAct++;
                        } while (taskRow != null);
                    }

                    listaProcesos.insertar(proceso);
                }

                // Avanzar al siguiente índice de fila.
                indexRow++;
            }
        }

        workbook.close();
        inputStream.close();

        return listaProcesos;
    }


    //METODO CARGAR DATOS
    public void saveProcessesInExcel(String ruta, ListaEnlazadaProcesos listProcess) throws IOException {
        @SuppressWarnings("resource")
        Workbook workbook = new HSSFWorkbook();
        String Obligatorio = "";

        for (Proceso proceso : listProcess) {
            Sheet processSheet = workbook.createSheet(proceso.getNombre());

            int rowIndex = 0;
            Row processRow = processSheet.createRow(rowIndex++);
            processRow.createCell(0).setCellValue("ID");
            processRow.createCell(1).setCellValue("Name");

            // Agregar los atributos del proceso
            processRow = processSheet.createRow(rowIndex++);
            processRow.createCell(0).setCellValue(String.valueOf(proceso.getId()));
            processRow.createCell(1).setCellValue(proceso.getNombre());


            // Encabezado para las actividades
            //Row activityHeaderRow = processSheet.createRow(rowIndex++);
          /*  activityHeaderRow.createCell(0).setCellValue("Activity Name");
            activityHeaderRow.createCell(1).setCellValue("Activity Description");
            activityHeaderRow.createCell(2).setCellValue("Activity Obligatorio");*/

            for (Actividad activity : proceso.getListaEnlazadaActividades()) {
                Row activityHeaderRow = processSheet.createRow(rowIndex++);
                activityHeaderRow.createCell(0).setCellValue("Nombre Actividad");
                activityHeaderRow.createCell(1).setCellValue("Descripcion actividad");
                activityHeaderRow.createCell(2).setCellValue("Obligatorio");
                Row activityRow = processSheet.createRow(rowIndex++);
                activityRow.createCell(0).setCellValue(activity.getNombre());
                activityRow.createCell(1).setCellValue(activity.getDescripcion());
                if(activity.isObligatorio()){
                    Obligatorio="TRUE";
                }else{
                    Obligatorio = "FALSE";
                }
                activityRow.createCell(2).setCellValue(Obligatorio);

                // Encabezado para las tareas
                Row taskHeaderRow = processSheet.createRow(rowIndex++);
                taskHeaderRow.createCell(0).setCellValue("Tarea Descripcion");
                taskHeaderRow.createCell(1).setCellValue("Obligatorio");
                taskHeaderRow.createCell(2).setCellValue("Duracion");

                for (Tarea tarea : activity.getTareas()) {
                    Row taskRow = processSheet.createRow(rowIndex++);
                    taskRow.createCell(0).setCellValue(tarea.getDescripcion());
                    if(tarea.Obligatorio){
                        Obligatorio="TRUE";
                    }else{
                        Obligatorio = "FALSE";
                    }
                    taskRow.createCell(1).setCellValue(Obligatorio);
                    taskRow.createCell(2).setCellValue(String.valueOf(tarea.getDuracion()));
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream(ruta);
        workbook.write(outputStream);
        outputStream.close();
    }

}
