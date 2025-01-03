package models;

public class Admin {
    //Atributos
    private String nombre;
    private String email;
    private String clave;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;

    //Constructor
    //Deberíamos preestableces las credenciales, el constructor probablemente vaya vacío
    public Admin(String nombre, String email, String clave) {
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }


    //Otros métodos
    public boolean loginAdmin(String email, String clave) {
        //lo he simplificado ya que si no se cumple una de las dos da falso
        return ((/*this.nombre.equals(nombre) || */this.email.equals(email)) && this.clave.equals(clave)) ;
    }

    public boolean altaTrabajador(Trabajador trabajador) {
        if (trabajador1 == null) {
            trabajador1 = trabajador;
            return true;
        }
        if (trabajador2 == null) {
            trabajador1 = trabajador;
            return true;
        }
        if (trabajador3 == null) {
            trabajador1 = trabajador;
            return true;
        }
        return false;
    }

    //toString
    @Override
    public String toString() {
        return "Admin{" + "nombre=" + nombre + ", clave=" + clave + ", email= " + email + '}';
    }
}