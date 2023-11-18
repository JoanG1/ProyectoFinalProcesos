package com.example.proyectofinal.Usuarios;

public class Usuarios {

    private String Id;
    private Rol rol;

    public Usuarios (String Id, Rol rol){

        this.Id = Id;
        this.rol = rol;

    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
