package models;

public class Producto {

    //Atributos
    private String codigo;
    private String nombre;
    private int stock;
    private double precio;

    //Constructor
    public Producto(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    //Constructor copia
    public Producto(Producto producto) {
        codigo = producto.codigo;
        nombre = producto.nombre;
        stock = producto.stock;
        precio = producto.precio;
    }

    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    //Otros métodos
    public boolean reducirStock(int cantidad) {
        if (cantidad < 0 || cantidad > stock) return false;
        stock -= cantidad;
        return true;
    }

    public boolean aumentarStock(int cantidad) {
        if (cantidad < 0) return false;
        stock += cantidad;
        return true;
    }

    //pintar un producto
    public String pintaProducto() {
        return nombre + String.format("\n%.2f", precio) + " Euros\n";
    }

    //Modificar un producto
    public void modificarProducto(String nuevoNombre, Double nuevoPrecio, Integer nuevoStock) {
        if (nuevoNombre != null && !nuevoNombre.isEmpty()) {
            this.nombre = nuevoNombre;
        }
        if (nuevoPrecio != null) {
            this.precio = nuevoPrecio;
        }
        if (nuevoStock != null) {
            this.stock = nuevoStock;
        }
    }

    //toString
    @Override
    public String toString() {
        return "Producto{" +
                "nombre ='" + nombre + '\'' +
                ", stock =" + stock +
                ", precio =" + precio +
                '}';
    }
}