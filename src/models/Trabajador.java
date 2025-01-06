package models;

public class Trabajador {

    //Atributos
    private String nombre;
    private String email;
    private String clave;
    private int telefono;
    private Pedido p1;
    private Pedido p2;
    private int contador = 0;

    //private cont?
    //private pese...?
    //No los veo bien en el UML, cosa que deberíamos desarrollar más en profundidad antes de continuar (creo)

    //Constructor
    public Trabajador(String nombre, String email, String clave, int telefono) {
        this.nombre = nombre;
        this.email = email;
        this.clave = clave;
        this.telefono = telefono;
        this.p1 = null;
        this.p2 = null;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Pedido getP1() {
        return p1;
    }

    public void setP1(Pedido p1) {
        this.p1 = p1;
    }

    public Pedido getP2() {
        return p2;
    }

    public void setP2(Pedido p2) {
        this.p2 = p2;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //Otros métodos

    public boolean puedeAceptarPedido() {
        return p1 == null || p2 == null;
    }

    public boolean asignarPedido(Pedido pedido) {
        if (p1 == null) {
            p1 = pedido;
            pedido.setTrabajador(this);
            return true;
        } else if (p2 == null) {
            p2 = pedido;
            pedido.setTrabajador(this);
            return true;
        }
        return false;
    }

    // Método para verificar si el trabajador tiene menos pedidos que otro trabajador
public boolean tieneMenosPedidosQue(Trabajador otroTrabajador) {
    return this.contador < otroTrabajador.getContador();
}

    // Metodo para contar los pedidos asignados al trabajador
    public int contarPedidos() {
        int count = 0;
        if (p1 != null) count++;
        if (p2 != null) count++;
        return count;
    }

    // Método para verificar si el trabajador está completo (tiene 2 pedidos)
    public boolean estaCompleto() {
        return contador == 2;
    }

    //Login para trabajadores con email y contraseña
    public boolean loginTrabajador(String email, String clave) {
        return this.email.equals(email) && this.clave.equals(clave);
    }

    // Método para verificar si el trabajador tiene pedidos asignados
    public boolean tienePedidosAsignados() {
        return p1 != null || p2 != null;
    }

    // Método para consultar los pedidos asignados al trabajador
    public String consultarPedidosAsignados() {
        String resultado = "";
        resultado += (p1 != null) ? "1. " + p1.toString() : "";
        resultado += "\n";
        resultado += (p2 != null) ? "2. " + p2.toString() : "";
        return resultado;
    }

    public void modificarDatos(String nuevoNombre, String nuevaClave, int nuevoTelefono) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevaClave != null && !nuevaClave.isEmpty()) {
            this.clave = nuevaClave;
        }
        if (nuevoTelefono != 0) {
            this.telefono = nuevoTelefono;
        }
    }

    public String verPerfil() {
        return String.format("""
                ==========================
                PERFIL DEL TRABAJADOR
                ==========================
                Nombre: %s
                Email: %s
                Teléfono: %s
                ==========================
                """, this.nombre, this.email, this.telefono);
    }

    // Metodo toString para representar el trabajador como una cadena de texto
    @Override
    public String toString() {
        return "Trabajador{" +
                "nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }


}