package com.example.proyectofinal.LecturaUsuarios;

import com.example.proyectofinal.Usuarios.Rol;
import com.example.proyectofinal.Usuarios.Usuarios;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LecturaUsuarios {

    private static final String NOMBRE_ARCHIVO ="src/main/java/com/example/proyectofinal/LecturaUsuarios/usuarios.txt";
    public LecturaUsuarios (){

    }

    public void guardarUsuario(Usuarios usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true))) {
            // Escribe el usuario en el archivo
            writer.write(usuario.getId() + "," + usuario.getRol());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Usuarios buscarUsuarioPorNombre(String Id) {
        try (BufferedReader reader = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Procesa la línea y verifica si el nombre de usuario coincide
                String[] partes = linea.split(",");
                String nombreUsuario = partes[0];
                String rol = partes[1];

                if (nombreUsuario.equals(Id)) {
                    // Encuentra el usuario
                    if(rol.equals("ADMIN")){
                        return new Usuarios(Id, Rol.ADMIN);
                    }else{
                        return new Usuarios(Id, Rol.USUARIO);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Si no se encuentra el usuario, retorna null
        return null;
    }

}
