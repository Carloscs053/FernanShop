package models;

public class Worker {

    //Atributos
    private String nombre;
    private String email;
    private int telefono;
    private Order p1;
    private Order p2;
    private int contador = 0;
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

    public Order getP1() {
        return p1;
    }

    public void setP1(Order p1) {
        this.p1 = p1;
    }

    public Order getP2() {
        return p2;
    }

    public void setP2(Order p2) {
        this.p2 = p2;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }


    //Otros métodos
    public void cuentaPedidos() {
        if (p1 != null) contador++;
        if (p2 != null) contador++;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + telefono +
                '}';

    }
}
