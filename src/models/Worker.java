package models;

public class Worker {

    //Atributos
    private String nombre;
    private String email;
    private int telefono;
    //private cont?
    //private pese...?
    //No los veo bien en el UML, cosa que deberíamos desarrollar más en profundidad antes de continuar (creo)

    //Constructor (por hacer)



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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    //Otros métodos

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + telefono +
                '}';

    }
}
