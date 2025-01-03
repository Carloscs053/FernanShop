package models;

public class Cliente {
    private String nombre;
    private String apellido;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private String email;
    private String clave;
    private Pedido pedido1;
    private Pedido pedido2;
    private int cuentaPedido;

    //Constructor

    public Cliente(String nombre, String apellido, String direccion, String localidad, String provincia, int telefono, String email, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.clave = clave;
        pedido1 = null;
        pedido2 = null;
        cuentaPedido = 0;
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
        clave = cliente.clave;
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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
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
    //Dice si el login es correcto o no
    public boolean loginCliente(String email, String clave) {
        return this.email.equals(email) && this.clave.equals(clave);
    }

    //Cuenta los pedidos que tiene el cliente
    public void cuentaPedido() {
        cuentaPedido = 0;
        if (pedido1 != null) cuentaPedido++;
        if (pedido2 != null) cuentaPedido++;
    }



    public String verCliente() {
        String salida = "==========================\n";
        salida += "PERFIL DEL CLIENTE\n";
        salida += "==========================\n";
        salida += "Nombre: " + nombre + apellido + "\n";
        salida += "Email: " + email + "\n";
        salida += "Teléfono: " + email + "\n";
        salida += "==========================\n";
        return salida;
    }


    //toString
    @Override
    public String toString() {
        return "Cliente: " + nombre + "\nEmail: " + email + "\nDirección: " + direccion +
                "\nTeléfono: " + telefono;
    }
}
