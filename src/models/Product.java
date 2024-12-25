package models;

public class Product {

    //Atributos
    private String codigo;
    private String nombre;
    private int stock;
    private double precio;


    //Constructor
    public Product(String codigo, String nombre, int stock, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public Product(Product product) {
        this.codigo = product.codigo;
        this.nombre = product.nombre;
        this.precio = product.precio;
    }

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
    public boolean quitaStock(int cantidad) {
        if (cantidad < 0 || cantidad > stock) return false;
        stock -= cantidad;
        return true;
    }

    public boolean aumentaStock(int cantidad) {
        if (cantidad < 0) return false;
        stock += cantidad;
        return true;
    }

    /*Para printar un producto yo creo que lo más lógico es solo poner el nombre y precio*/
    public String pintaproducto(){
        String salida = "";
        salida += "Nombre: " + nombre + "\n"
                + "Precio: " + precio;

        return salida;
    }

    //toString
    @Override
    public String toString() {
        return "Product{" +
                "name='" + nombre + '\'' +
                ", stock=" + stock +
                ", price=" + precio +
                '}';
    }
}
