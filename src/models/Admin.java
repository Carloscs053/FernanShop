package models;

public class Admin {

    //Atributos
    private String nombre;
    private String email;
    private String contrasenia;


    //Constructor
    public Admin(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //Otros métodos

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", password='" + contrasenia + '\'' +
                '}';

    }
}
