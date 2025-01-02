package models;

import data.ProductosData;
import data.TrabajadoresData;

public class Tienda {
    //Es cierto el contralador es tienda y no el pedido.

    //Atributos
    private Cliente cliente1;
    private Cliente cliente2;
    //Admin se encarga de gestionar los trabajadores, tienda gestiona los clientes
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;


    //Constructor
    public Tienda() {
        this.cliente1 = null;
        this.cliente2 = null;
        this.trabajador1 = null;
        this.trabajador2 = null;
        this.trabajador3 = null;
    }
    

    //Getters y Setters
    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Cliente getCliente2() {
        return cliente2;
    }

    public void setCliente2(Cliente cliente2) {
        this.cliente2 = cliente2;
    }

    public Trabajador getTrabajador1() {
        return trabajador1;
    }

    public void setTrabajador1(Trabajador trabajador1) {
        this.trabajador1 = trabajador1;
    }

    public Trabajador getTrabajador2() {
        return trabajador2;
    }

    public void setTrabajador2(Trabajador trabajador2) {
        this.trabajador2 = trabajador2;
    }

    public Trabajador getTrabajador3() {
        return trabajador3;
    }

    public void setTrabajador3(Trabajador trabajador3) {
        this.trabajador3 = trabajador3;
    }


    //Otros métodos
    public boolean altaCliente(Cliente cliente) {
        if (cliente1 == null) {
            this.cliente1 = cliente;
            return true;
        }
        if (cliente2 == null) {
            this.cliente1 = cliente;
            return true;
        }
        return false;
    }

    //En vez de poner en el login el nombre podria el email o un username o incluso que ambas opciones sean validad username y email
    public boolean loginCliente(String nombre, String contrasenia) {
        if (cliente1 != null && (nombre.equals(cliente1.getNombre()) && contrasenia.equals(cliente1.getContrasenia()))) return true;
        return cliente2 != null && (nombre.equals(cliente2.getNombre()) && contrasenia.equals(cliente2.getContrasenia()));
    }

    //login del trabajador
    public boolean loginTrabajador(String email, String contrasena) {
        if (TrabajadoresData.trabajador1.getEmail().equals(email) && TrabajadoresData.trabajador1.getContrasena().equals(contrasena)) {
            return true;
        } else if (TrabajadoresData.trabajador2.getEmail().equals(email) && TrabajadoresData.trabajador2.getContrasena().equals(contrasena)) {
            return true;
        } else return TrabajadoresData.trabajador3.getEmail().equals(email) && TrabajadoresData.trabajador3.getContrasena().equals(contrasena);
    }

    public static Trabajador getTrabajadorByEmail(String email) {
        if (TrabajadoresData.trabajador1.getEmail().equals(email)) {
            return TrabajadoresData.trabajador1;
        } else if (TrabajadoresData.trabajador2.getEmail().equals(email)) {
            return TrabajadoresData.trabajador2;
        } else if (TrabajadoresData.trabajador3.getEmail().equals(email)) {
            return TrabajadoresData.trabajador3;
        } else {
            return null;
        }
    }

    // Método para generar el catálogo de productos
    public String verCatalogo(ProductosData productosData) {
        String catalogo = "";
        catalogo += ((ProductosData.Producto1 != null) ? ProductosData.Producto1.pintaProducto() : "") + "\n";
        catalogo += ((ProductosData.Producto2 != null) ? ProductosData.Producto2.pintaProducto() : "") + "\n";
        catalogo += ((ProductosData.Producto3 != null) ? ProductosData.Producto3.pintaProducto() : "") + "\n";
        catalogo += ((ProductosData.Producto4 != null) ? ProductosData.Producto4.pintaProducto() : "") + "\n";
        catalogo += ((ProductosData.Producto5 != null) ? ProductosData.Producto5.pintaProducto() : "") + "\n";
        return catalogo;
    }

    public boolean existeCodigoProducto(String codigo, ProductosData productosData) {
        if (ProductosData.Producto1 != null && ProductosData.Producto1.getCodigo().equalsIgnoreCase(codigo)) {
            return true;
        }
        if (ProductosData.Producto2 != null && ProductosData.Producto2.getCodigo().equalsIgnoreCase(codigo)) {
            return true;
        }
        if (ProductosData.Producto3 != null && ProductosData.Producto3.getCodigo().equalsIgnoreCase(codigo)) {
            return true;
        }
        if (ProductosData.Producto4 != null && ProductosData.Producto4.getCodigo().equalsIgnoreCase(codigo)) {
            return true;
        }
        return ProductosData.Producto5 != null && ProductosData.Producto5.getCodigo().equalsIgnoreCase(codigo);
    }

    //toString
    @Override
    public String toString() {
        return "Tienda{" +
                "cliente1=" + cliente1 +
                ", cliente2=" + cliente2 +
                /*", trabajador1=" + trabajador1 +
                ", trabajador2=" + trabajador2 +
                ", trabajador3=" + trabajador3 +*/
                '}';
    }
}