package models;

public class Admin {
    //Atributos
    private String nombre;
    private String email;
    private String contrasena;

    //Constructor
    public Admin(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    //toString
    @Override
    public String toString() {
        return "Admin{" + "nombre=" + nombre + ", contrasena=" + contrasena + ", email= " + email + '}';
    }
}