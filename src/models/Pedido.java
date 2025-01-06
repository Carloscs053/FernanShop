package models;

import data.ProductosData;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {
    // Atributos
    private Producto p1;
    private Producto p2;
    private Producto p3;
    private String codigo;
    private LocalDate fechaPedido;
    private String comentario;
    private String estado;
    private int diasRetraso;
    private Trabajador trabajador;
    private Cliente cliente;

    // Atributo Estático
    private static final int SHIPPING_DAYS = 5;
    private static int contadorCodigo = 0;

    // Constructor por defecto
    public Pedido() {
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.codigo = generarCodigoAleatorio();
        this.fechaPedido = LocalDate.now();
        this.comentario = "";
        this.estado = "Recibido";
        this.diasRetraso = 0;
    }

    // Constructor para un solo producto
    public Pedido(Producto p1, String comentario, String estado, int diasRetraso, Cliente cliente) {
        this.p1 = p1;
        this.p2 = null;
        this.p3 = null;
        this.comentario = comentario != null ? comentario : "";
        this.estado = estado != null ? estado : "Recibido";
        this.diasRetraso = diasRetraso;
        this.cliente = cliente;
        this.fechaPedido = LocalDate.now();
        this.codigo = generarCodigoAleatorio();
    }

    // Constructor para dos productos
    public Pedido(Producto p1, Producto p2, String comentario, String estado, int diasRetraso, Cliente cliente) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = null;
        this.comentario = comentario != null ? comentario : "";
        this.estado = estado != null ? estado : "Recibido";
        this.diasRetraso = diasRetraso;
        this.cliente = cliente;
        this.fechaPedido = LocalDate.now();
        this.codigo = generarCodigoAleatorio();
    }

    // Constructor para tres productos
    public Pedido(Producto p1, Producto p2, Producto p3, String comentario, String estado, int diasRetraso, Cliente cliente) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.comentario = comentario != null ? comentario : "";
        this.estado = estado != null ? estado : "Recibido";
        this.diasRetraso = diasRetraso;
        this.cliente = cliente;
        this.fechaPedido = LocalDate.now();
        this.codigo = generarCodigoAleatorio();
    }

    // Getters y Setters
    public Producto getP1() { return p1; }
    public void setP1(Producto p1) { this.p1 = p1; }
    public Producto getP2() { return p2; }
    public void setP2(Producto p2) { this.p2 = p2; }
    public Producto getP3() { return p3; }
    public void setP3(Producto p3) { this.p3 = p3; }
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public LocalDate getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDate fechaPedido) { this.fechaPedido = fechaPedido; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
    public int getDiasRetraso() { return diasRetraso; }
    public void setDiasRetraso(int diasRetraso) { this.diasRetraso = diasRetraso; }
    public Trabajador getTrabajador() { return trabajador; }
    public void setTrabajador(Trabajador trabajador) { this.trabajador = trabajador; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    // Otros métodos
    public boolean isEmpty() {
        return p1 == null && p2 == null && p3 == null;
    }

    public boolean isFull() {
        return p1 != null && p2 != null && p3 != null;
    }

    public LocalDate calculateDays() {
        return fechaPedido.plusDays(SHIPPING_DAYS + diasRetraso);
    }

    public void agregaProducto(Producto producto) {
        if (p1 == null) {
            p1 = producto;
            return;
        }
        if (p2 == null) {
            p2 = producto;
            return;
        }
        if (p3 == null) {
            p3 = producto;
        }
    }

    public void anadeProducto(String opProducto) {
        switch (opProducto) {
            case "1":
                agregaProducto(ProductosData.Producto1);
                return;
            case "2":
                agregaProducto(ProductosData.Producto2);
                return;
            case "3":
                agregaProducto(ProductosData.Producto3);
                return;
            case "4":
                agregaProducto(ProductosData.Producto4);
                return;
            case "5":
                agregaProducto(ProductosData.Producto5);
                return;
            default:
        }
    }

    public double getTotal() {
        double total = 0.0;
        if (p1 != null) total += p1.getPrecio();
        if (p2 != null) total += p2.getPrecio();
        if (p3 != null) total += p3.getPrecio();
        return total;
    }

    public int getCantidadProductos() {
        int cantidad = 0;
        if (p1 != null) cantidad++;
        if (p2 != null) cantidad++;
        if (p3 != null) cantidad++;
        return cantidad;
    }

    private String generarCodigoAleatorio() {
        contadorCodigo++;
        String inicialesCliente = cliente.getNombre().charAt(0) + cliente.getApellido().charAt(0) + "";
        String localidad = cliente.getLocalidad().substring(0, Math.min(3, cliente.getLocalidad().length())).toUpperCase();
        String telefono = String.valueOf(cliente.getTelefono());
        String numerosTelefono = telefono.substring(Math.max(0, telefono.length() - 3));
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder codigoAlfanumerico = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            int indice = (contadorCodigo * (i + 1) + i) % caracteres.length();
            codigoAlfanumerico.append(caracteres.charAt(indice));
        }
        return inicialesCliente + localidad + numerosTelefono + codigoAlfanumerico;
    }

    @Override
    public String toString() {
        return String.format("Pedido %s: %s %s, %d productos, Total: %.2f, Comentario: %s, Estado: %s, Fecha: %s",
                codigo,
                cliente.getNombre(),
                cliente.getApellido(),
                getCantidadProductos(),
                getTotal(),
                comentario,
                estado,
                fechaPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}