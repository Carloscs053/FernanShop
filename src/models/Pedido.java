package models;

import data.ProductosData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
    private boolean realizado;
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
        this.realizado = false;
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

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    public static int getContadorCodigo() {
        return contadorCodigo;
    }

    public static void setContadorCodigo(int contadorCodigo) {
        Pedido.contadorCodigo = contadorCodigo;
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

    public boolean anadeProducto(String opProducto, int cantidad) {
        if (p3 != null) {
            System.out.println("No se pueden agregar más productos al carrito");
        } else if (p1 == null) {
            switch (opProducto) {
                case "1" -> {
                    if (ProductosData.Producto1.reducirStock(cantidad)) {
                        p1 = ProductosData.Producto1;
                        return true;
                    }
                    return false;
                }
                case "2" -> {
                    if (ProductosData.Producto2.reducirStock(cantidad)) {
                        p1 = ProductosData.Producto2;
                        return true;
                    }
                    return false;
                }
                case "3" -> {
                    if (ProductosData.Producto3.reducirStock(cantidad)) {
                        p1 = ProductosData.Producto3;
                        return true;
                    }
                    return false;
                }
                case "4" -> {
                    if (ProductosData.Producto4.reducirStock(cantidad)) {
                        p1 = ProductosData.Producto4;
                        return true;
                    }
                    return false;
                }
                case "5" -> {
                    if (ProductosData.Producto5.reducirStock(cantidad)) {
                        p1 = ProductosData.Producto5;
                        return true;
                    }
                    return false;
                }
            }
        } else if (p1 != null && p2 == null) {
            switch (opProducto) {
                case "1" -> {
                    if (ProductosData.Producto1.reducirStock(cantidad)) {
                        p2 = ProductosData.Producto1;
                        return true;
                    }
                    return false;
                }
                case "2" -> {
                    if (ProductosData.Producto2.reducirStock(cantidad)) {
                        p2 = ProductosData.Producto2;
                        return true;
                    }
                    return false;
                }
                case "3" -> {
                    if (ProductosData.Producto3.reducirStock(cantidad)) {
                        p2 = ProductosData.Producto3;
                        return true;
                    }
                    return false;
                }
                case "4" -> {
                    if (ProductosData.Producto4.reducirStock(cantidad)) {
                        p2 = ProductosData.Producto4;
                        return true;
                    }
                    return false;
                }
                case "5" -> {
                    if (ProductosData.Producto5.reducirStock(cantidad)) {
                        p2 = ProductosData.Producto5;
                        return true;
                    }
                    return false;
                }
            }
        } else if (p1 != null && p2 != null & p3 == null) {
            switch (opProducto) {
                case "1" -> {
                    if (ProductosData.Producto1.reducirStock(cantidad)) {
                        p3 = ProductosData.Producto1;
                        return true;
                    }
                    return false;
                }
                case "2" -> {
                    if (ProductosData.Producto2.reducirStock(cantidad)) {
                        p3 = ProductosData.Producto2;
                        return true;
                    }
                    return false;
                }
                case "3" -> {
                    if (ProductosData.Producto3.reducirStock(cantidad)) {
                        p3 = ProductosData.Producto3;
                        return true;
                    }
                    return false;
                }
                case "4" -> {
                    if (ProductosData.Producto4.reducirStock(cantidad)) {
                        p3 = ProductosData.Producto4;
                        return true;
                    }
                    return false;
                }
                case "5" -> {
                    if (ProductosData.Producto5.reducirStock(cantidad)) {
                        p3 = ProductosData.Producto5;
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
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

    //Admin asigna un trabajador
    // Metodo para asignar un trabajador automáticamente
    public boolean asignarAutomaticamente(Tienda tienda) {
        Trabajador trabajador1 = tienda.getTrabajador1();
        Trabajador trabajador2 = tienda.getTrabajador2();
        Trabajador trabajador3 = tienda.getTrabajador3();
    
        if (trabajador1 != null && trabajador1.puedeAceptarPedido() &&
            trabajador2 != null && trabajador2.puedeAceptarPedido() &&
            trabajador3 != null && trabajador3.puedeAceptarPedido()) {
    
            Trabajador trabajadorMenosPedidos = obtenerTrabajadorConMenosPedidos(trabajador1, trabajador2, trabajador3);
    
            if (trabajadorMenosPedidos != null) {
                this.setTrabajador(trabajadorMenosPedidos);
                trabajadorMenosPedidos.asignarPedido(this);
                return true;
            }
        }
    
        return false;
    }

    // Metodo para asignar un trabajador manualmente
    public boolean asignarManualmente(Tienda tienda, int seleccionTrabajador) {
        Trabajador trabajadorSeleccionado = null;
        
        switch (seleccionTrabajador) {
            case 1:
                trabajadorSeleccionado = tienda.getTrabajador1();
                break;
            case 2:
                trabajadorSeleccionado = tienda.getTrabajador2();
                break;
            case 3:
                trabajadorSeleccionado = tienda.getTrabajador3();
                break;
            default:
                return false;
        }
    
        if (trabajadorSeleccionado != null && trabajadorSeleccionado.puedeAceptarPedido()) {
            this.setTrabajador(trabajadorSeleccionado);
            trabajadorSeleccionado.asignarPedido(this);
            trabajadorSeleccionado.setContador(trabajadorSeleccionado.contarPedidos());
            return true;
        }
        return false;
    }

    // Metodo para asignar pedidos automáticamente
    public static void asignarPedidosAutomaticamente(Tienda tienda) {
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();

        if ((t1 != null && t2 != null && t3 == null) || (t1 == null && t2 != null && t3 != null) || (t1 != null && t2 == null && t3 != null)) {
            boolean asignado;
            do {
                asignado = asignarSiguientePedidoAutomaticamente(tienda);
            } while (asignado);
        } else if (t1 != null && t2 != null && t3 != null) {
            while (true) {
                int pedidosT1 = t1.contarPedidos();
                int pedidosT2 = t2.contarPedidos();
                int pedidosT3 = t3.contarPedidos();

                if (pedidosT1 == pedidosT2 && pedidosT2 == pedidosT3) {
                    asignarPedidoManualmente(tienda);
                    break;
                } else if ((pedidosT1 == pedidosT2 && pedidosT1 < pedidosT3) || 
                           (pedidosT1 == pedidosT3 && pedidosT1 < pedidosT2) || 
                           (pedidosT2 == pedidosT3 && pedidosT2 < pedidosT1)) {
                    asignarPedidoManualmente(tienda);
                    break;
                } else {
                    Trabajador trabajadorMenosPedidos = obtenerTrabajadorConMenosPedidos(t1, t2, t3);
                    if ((trabajadorMenosPedidos == t1 && pedidosT1 < pedidosT2 && pedidosT1 < pedidosT3) ||
                        (trabajadorMenosPedidos == t2 && pedidosT2 < pedidosT1 && pedidosT2 < pedidosT3) ||
                        (trabajadorMenosPedidos == t3 && pedidosT3 < pedidosT1 && pedidosT3 < pedidosT2)) {
                        boolean asignado = asignarSiguientePedidoAutomaticamente(tienda);
                        if (!asignado) {
                            break;
                        }
                    } else {
                        asignarPedidoManualmente(tienda);
                        break;
                    }
                }
            }
        }
    }

    // Metodo para obtener el trabajador con menos pedidos
    private static Trabajador obtenerTrabajadorConMenosPedidos(Trabajador t1, Trabajador t2, Trabajador t3) {
        int pedidosT1 = t1.contarPedidos();
        int pedidosT2 = t2.contarPedidos();
        int pedidosT3 = t3.contarPedidos();

        if ((pedidosT1 == pedidosT2 && pedidosT1 < pedidosT3) ||
            (pedidosT1 == pedidosT3 && pedidosT1 < pedidosT2) ||
            (pedidosT2 == pedidosT3 && pedidosT2 < pedidosT1)) {
            return null;
        }

        if (pedidosT1 < pedidosT2 && pedidosT1 < pedidosT3) {
            return t1;
        } else if (pedidosT2 < pedidosT1 && pedidosT2 < pedidosT3) {
            return t2;
        } else if (pedidosT3 < pedidosT1 && pedidosT3 < pedidosT2) {
            return t3;
        }

        return null;
    }

    // Metodo para asignar el siguiente pedido automáticamente

    public static boolean asignarSiguientePedidoAutomaticamente(Tienda tienda) {
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();
        Trabajador trabajadorMenosPedidos = null;

        // Contar cuántos trabajadores pueden aceptar pedidos
        int contadorTrabajadoresActivos = 0;

        // Verificar cada trabajador
        if (t1 != null && t1.puedeAceptarPedido()) {
            contadorTrabajadoresActivos++;
            trabajadorMenosPedidos = t1; // Inicialmente, asignamos el primero que puede aceptar
        }
        if (t2 != null && t2.puedeAceptarPedido()) {
            contadorTrabajadoresActivos++;
            if (trabajadorMenosPedidos == null || t2.contarPedidos() < trabajadorMenosPedidos.contarPedidos()) {
                trabajadorMenosPedidos = t2;
            }
        }
        if (t3 != null && t3.puedeAceptarPedido()) {
            contadorTrabajadoresActivos++;
            if (trabajadorMenosPedidos == null || t3.contarPedidos() < trabajadorMenosPedidos.contarPedidos()) {
                trabajadorMenosPedidos = t3;
            }
        }

        // Si solo hay un trabajador activo, asignarle el pedido hasta su límite
        if (trabajadorMenosPedidos != null) {
            if (contadorTrabajadoresActivos == 1) {
                // Asignar hasta que alcance su límite de 2 pedidos
                if (trabajadorMenosPedidos.contarPedidos() < 2) {
                    Pedido siguientePedido = Pedido.obtenerSiguientePedidoSinAsignar(tienda);
                    if (siguientePedido != null) {
                        trabajadorMenosPedidos.asignarPedido(siguientePedido);
                        return true;
                    }
                }
                return false; // Ya alcanzó su límite de pedidos
            }

            // Si hay más de un trabajador, verificar quién tiene menos pedidos
            int pedidosMenos = trabajadorMenosPedidos.contarPedidos();
            boolean esMenosQueT1 = (t1 != null && pedidosMenos < t1.contarPedidos());
            boolean esMenosQueT2 = (t2 != null && pedidosMenos < t2.contarPedidos());
            boolean esMenosQueT3 = (t3 != null && pedidosMenos < t3.contarPedidos());

            if ((trabajadorMenosPedidos == t1 && esMenosQueT2 && esMenosQueT3) ||
                    (trabajadorMenosPedidos == t2 && esMenosQueT1 && esMenosQueT3) ||
                    (trabajadorMenosPedidos == t3 && esMenosQueT1 && esMenosQueT2)) {
                // Asignar automáticamente el siguiente pedido al trabajador con menos pedidos
                Pedido siguientePedido = Pedido.obtenerSiguientePedidoSinAsignar(tienda);
                if (siguientePedido != null) {
                    trabajadorMenosPedidos.asignarPedido(siguientePedido);
                    return true;
                }
            }
        }
        return false;
    }

    // Metodo para obtener el siguiente pedido sin asignar
    public static Pedido obtenerSiguientePedidoSinAsignar(Tienda tienda) {
        if (tienda.getPedido1() != null && tienda.getPedido1().getTrabajador() == null) {
            return tienda.getPedido1();
        }
        if (tienda.getPedido2() != null && tienda.getPedido2().getTrabajador() == null) {
            return tienda.getPedido2();
        }
        if (tienda.getPedido3() != null && tienda.getPedido3().getTrabajador() == null) {
            return tienda.getPedido3();
        }
        if (tienda.getPedido4() != null && tienda.getPedido4().getTrabajador() == null) {
            return tienda.getPedido4();
        }
        return null;
    }

    // Metodo para asignar un pedido manualmente
    private static void asignarPedidoManualmente(Tienda tienda) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Seleccione el trabajador (1 para Carlos, 2 para Eduardo, 3 para JL): ");
        int seleccionTrabajador = scanner.nextInt();
        Trabajador trabajadorSeleccionado = null;

        switch (seleccionTrabajador) {
            case 1:
                trabajadorSeleccionado = tienda.getTrabajador1();
                break;
            case 2:
                trabajadorSeleccionado = tienda.getTrabajador2();
                break;
            case 3:
                trabajadorSeleccionado = tienda.getTrabajador3();
                break;
            default:
                return;
        }

        if (trabajadorSeleccionado != null && trabajadorSeleccionado.puedeAceptarPedido()) {
            Pedido siguientePedido = obtenerSiguientePedidoSinAsignar(tienda);
            if (siguientePedido != null) {
                trabajadorSeleccionado.asignarPedido(siguientePedido);
                siguientePedido.setTrabajador(trabajadorSeleccionado);
                trabajadorSeleccionado.setContador(trabajadorSeleccionado.contarPedidos());
            }
        }
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

    public String pintaPedido(Cliente cliente) {
        String salida = "=================== PEDIDO " + codigo + " ===================\n";
        salida += "- Destinatario: " + cliente.getNombre() + " " + cliente.getApellido() + "\n";
        salida += "- Lista de productos: \n";
        salida += (p1 != null) ? "\t- " + p1.pintaProducto() : "";
        salida += (p1 != null) ? "  \t" + p1.getCantidadPedido() + " unidades\n" : "\n";
        salida += (p2 != null) ? "\t- " + p2.pintaProducto() : "";
        salida += (p2 != null) ? "  \t" + p2.getCantidadPedido() + " unidades\n" : "\n";
        salida += (p3 != null) ? "\t- " + p3.pintaProducto() : "";
        salida += (p3 != null) ? "  \t" + p3.getCantidadPedido() + " unidades\n" : "\n";
        return salida;
    }
}