package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pedido {

    //Atributos
    private Producto p1;
    private Producto p2;
    private Producto p3;
    private String codigo;
    private LocalDate fechaPedido;
    private String comentario;
    private String estado;
    private int diasRetraso;
    //TODO Bajo revisión
    //un pepdido lo gestiona un trabajador y un pedido lo realiza un cliente cliente
    /*private Trabajador trabajador;
    private Cliente cliente;*/

    //Atributo Estático
    public static final int SHIPPING_DAYS = 5;

    //Constructor
    //Trabajador y cliente quitados de parámetros para que no salten fallos, temporal
    public Pedido(Producto p1, Producto p2, Producto p3, /*String comentario, String estado,*/ int diasRetraso) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.comentario = "";
        this.estado = "En proceso";
        this.diasRetraso = diasRetraso;
        /*this.trabajador = trabajador;
        this.cliente = cliente;*/
        this.fechaPedido = LocalDate.now();
        this.codigo = generarCodigoAleatorio();
    }

    //Getters y Setters
    public Producto getP1() {
        return p1;
    }

    public void setP1(Producto p1) {
        this.p1 = p1;
    }

    public Producto getP2() {
        return p2;
    }

    public void setP2(Producto p2) {
        this.p2 = p2;
    }

    public Producto getP3() {
        return p3;
    }

    public void setP3(Producto p3) {
        this.p3 = p3;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getDiasRetraso() {
        return diasRetraso;
    }

    public void setDiasRetraso(int diasRetraso) {
        this.diasRetraso = diasRetraso;
    }

    /*public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }*/

    //Otros métodos

    // Verificar si el pedido está vacío
    public boolean isEmpty() {
        return p1 == null && p2 == null && p3 == null;
    }

    // Verificar si el pedido está lleno
    public boolean isFull() {
        return p1 != null && p2 != null && p3 != null;
    }

    /*TODO mirar cómo cambiar el retraso | si el pedido se retrasa como calculo la nueva fecha sin saber cuantos dias se retrasa ni la fecha de entrega estimada*/
    // Calcular la fecha de entrega considerando los días de retraso
    public LocalDate calculateDays() {
        return fechaPedido.plusDays(SHIPPING_DAYS + diasRetraso); //(SHIPPING_DAYS + Atributo de días de retraso) para calcular los días de retraso
    }

    //Método que agrega productos al pedido
    //Lo pongo como boolean para que en el main se le de feedback al cliente de si se ha hecho o no
    public boolean agragaProducto(Producto producto) {
        if (p1 == null) {
            p1 = producto;
            return true;
        }
        if (p2 == null) {
            p2 = producto;
            return true;
        }
        if (p3 == null) {
            p3 = producto;
            return true;
        }
        return false;
    }

    // Obtener el total del pedido sumando los precios de los productos
    public double getTotal() {
        return p1.getPrecio() + p2.getPrecio() + p3.getPrecio();
    }

    // Generar un código aleatorio utilizando números del 0 al 9, la fecha de pedido y las iniciales del cliente
    public String generarCodigoAleatorio() {
        String fecha = fechaPedido.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String iniciales = cliente.getNombre().substring(0, 1) + cliente.getApellido().substring(0, 1);
        int numeroAleatorio = (int) (Math.random() * 10000); // Generar un número aleatorio de 4 dígitos
        return this.codigo = iniciales + fecha + String.format("%04d", numeroAleatorio);
    }

    // Representar el pedido como una cadena de texto
    @Override
    public String toString() {
        return "Pedido{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", codigo='" + codigo + '\'' +
                ", fecha Pedido=" + fechaPedido +
                ", comentario='" + comentario + '\'' +
                ", estado='" + estado + '\'' +
                ", trabajador=" + trabajador +
                ", cliente=" + cliente +
                '}';
    }
}
