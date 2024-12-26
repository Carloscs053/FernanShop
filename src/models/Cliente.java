package models;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private String email;
    private String contrasenia;
    private Pedido pedido1;
    private Pedido pedido2;

    //Constructor

    public Cliente(String nombre, String apellido, String direccion, String localidad, String provincia, int telefono, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.contrasenia = contrasenia;
        pedido1 = null;
        pedido2 = null;
    }

    //Constructor copia

    public Cliente(Cliente cliente) {
        nombre = cliente.nombre;
        apellido = cliente.apellido;
        direccion = cliente.direccion;
        localidad = cliente.localidad;
        provincia = cliente.provincia;
        telefono = cliente.telefono;
        email = cliente.email;
        contrasenia = cliente.contrasenia;
        pedido1 = cliente.pedido1;
        pedido2 = cliente.pedido2;
    }

    //getter y setter

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
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

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    //Otros métodos



    //toString
    @Override
    public String toString() {
        return "Cliente: " + nombre + "\nEmail: " + email + "\nDirección: " + direccion +
                "\nTeléfono: " + telefono;
    }
}
