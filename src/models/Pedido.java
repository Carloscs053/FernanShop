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
    private Trabajador trabajador;
    private Cliente cliente;

    //Atributo Estático
    private static final int SHIPPING_DAYS = 5;
    private static int contadorCodigo = 0;
    //Constructor

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

    //Trabajador y cliente quitados de parámetros para que no salten fallos, temporal
    public Pedido(Producto p1, Producto p2, Producto p3, String comentario, String estado, int diasRetraso, Cliente cliente) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.comentario = "";
        this.estado = "Recibido";
        this.diasRetraso = diasRetraso;
        this.cliente = cliente;
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

    public Trabajador getTrabajador() {
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
    }

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
        double total = 0.0;
        if (p1 != null) {
            total += p1.getPrecio();
        }
        if (p2 != null) {
            total += p2.getPrecio();
        }
        if (p3 != null) {
            total += p3.getPrecio();
        }
        return total;
    }

    public int getCantidadProductos(){
        int cantidad = 0;
        if (p1 != null) {
            cantidad += 1;
        }
        if (p2 != null) {
            cantidad += 1;
        }
        if (p3 != null) {
            cantidad += 1;
        }
        return cantidad;
    }

    // Metodo para generar un código único
    private String generarCodigoAleatorio() {
        // Incrementar el contador estático
        contadorCodigo++;

        // Obtener las iniciales del cliente
        String inicialesCliente = cliente.getNombre().substring(0, 1) + cliente.getApellido().substring(0, 1);

        // Obtener las primeras tres letras de la localidad en mayúsculas
        String localidad = cliente.getLocalidad().substring(0, Math.min(3, cliente.getLocalidad().length())).toUpperCase();

        // Obtener los últimos tres dígitos del teléfono del cliente
        String telefono = String.valueOf(cliente.getTelefono());
        String numerosTelefono = telefono.substring(Math.max(0, telefono.length() - 3));

        // Generar un código alfanumérico de 7 caracteres
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String codigoAlfanumerico = "";
        int longitudCodigo = 7; // Longitud del código alfanumérico

        for (int i = 0; i < longitudCodigo; i++) {
            int indice = (contadorCodigo * (i + 1) + i) % caracteres.length();
            codigoAlfanumerico += caracteres.charAt(indice);
        }

        // Concatenar todas las partes para formar el código final
        return inicialesCliente + localidad + numerosTelefono + codigoAlfanumerico;
    }

    // Metodo para obtener la cantidad total de productos
    //public int getCantidadTotalProductos() {
    //    return p1.getCantidad() + p2.getCantidad() + p3.getCantidad();
    //}

    

    // Representar el pedido como una cadena de texto
    @Override
    public String toString() {
        return String.format("Pedido %s: %s %s, %d productos, Total: %.2f, Comentario: %s, Estado: %s, Fecha: %s",
                codigo,
                cliente.getNombre(),
                cliente.getApellido(),
                //getCantidadTotalProductos(),
                getTotal(),
                comentario,
                estado,
                fechaPedido.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }
}
