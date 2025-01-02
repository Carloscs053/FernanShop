package utils;

import java.util.Scanner;

import data.ProductosData;
import models.Admin;
import models.Cliente;
import models.Pedido;
import models.Producto;
import models.Trabajador;
import models.Tienda;

public class Menus {
    Tienda tienda = new Tienda();

    // Menú para el cliente
    public static void menuCliente(Cliente cliente) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opCliente;
        System.out.printf("""
                FERNANSHOP
                Bienvenido %s
                1.- Consultar el catálogo de productos
                2.- Realizar un pedido
                3.- Ver mis pedidos realizados
                4.- Ver mis datos personales
                5.- Modificar mis datos personales
                6.- Cerrar sesión
                \n
                Seleccione una opcion:\s""", cliente.getNombre());
        opCliente = s.nextLine();
        switch (opCliente) {
            case "1":
                //verCatalogo();
                break;
            case "2":
                //realizarPedido();
                break;
            case "3":
                //verPedidos();
                break;
            case "4":
                //verPerfil();
                break;
            case "5":
                //cliente.modificarDatos();
                break;
            case "6":
                break;
            default:
                break;
        }
    }

    // Menú para el trabajador
    public static void menuTrabajador(Trabajador trabajador, ProductosData productosData, Tienda tienda) {
        var s = new Scanner(System.in);
        String opTrabajador;
        do {
            System.out.printf("""
                    FERNANSHOP
                    Bienvenido %s. Tienes %d pedidos asignados.
                    1.- Consultar los pedidos que tengo asignados
                    2.- Modificar el estado de un pedido
                    3.- Consultar el catálogo de productos
                    4.- Modificar un producto del catálogo
                    5.- Ver mi perfil
                    6.- Modificar mis datos personales
                    7.- Cerrar sesión
                    
                    Seleccione una opción:\s""", trabajador.getNombre(), trabajador.getContador());
            opTrabajador = s.nextLine();
            switch (opTrabajador) {
                case "1":
                    pedidosTrabajador(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "2":
                    menuEstado(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "3":
                    String catalogo = tienda.verCatalogo(productosData);
                    System.out.println(catalogo);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "4":
                    modificarProducto(trabajador, productosData);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "5":
                    System.out.println(trabajador.verPerfil());
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "6":
                    //aquí se llama al metodo modificarDatos de la clase Trabajador
                    modificarDatosTrabajador(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "7":
                    System.out.println("Cerrando sesión...");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
            }
        } while (!opTrabajador.equals("7"));
    }

    // cossa del trabajador
// Menú para actualizar el estado de un pedido
    public static void menuEstado(Trabajador trabajador) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el código del pedido que desea modificar:");
        String codigoPedido = s.nextLine();

        Pedido pedido = obtenerPedidoPorCodigo(trabajador, codigoPedido);

        if (pedido == null) {
            System.out.println("Pedido no encontrado.");
            return;
        }

        boolean recibido = pedido.getEstado().equalsIgnoreCase("Recibido");
        boolean enPreparacion = pedido.getEstado().equalsIgnoreCase("En Preparación");
        boolean cancelado = pedido.getEstado().equalsIgnoreCase("Cancelado");

        while (true) {
            System.out.printf("""
                    ==== Actualización del pedido %s ====
                    Estado del pedido: %s
                    Nuevo estado:
                    \t1. Recibido
                    \t2. En Preparación
                    \t3. Retrasado
                    \t4. Cancelado
                    \t5. Enviado
                    Seleccione el nuevo estado:\s""", pedido.getCodigo(), pedido.getEstado());
            String opEstado = s.nextLine();
            switch (opEstado) {
                case "1":
                    pedido.setEstado("Recibido");
                    recibido = true;
                    break;
                case "2":
                    if (recibido) {
                        pedido.setEstado("En Preparación");
                        enPreparacion = true;
                    } else {
                        System.out.println("Debe seleccionar 'Recibido' antes de seleccionar esta opción.");
                    }
                    break;
                case "3":
                    if (enPreparacion) {
                        pedido.setEstado("Retrasado");
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción.");
                    }
                    break;
                case "4":
                    pedido.setEstado("Cancelado");
                    cancelado = true;
                    break;
                case "5":
                    if (enPreparacion && !cancelado) {
                        pedido.setEstado("Enviado");
                        //aqui se le resta 1 al contador de pedidos del trabajador
                        trabajador.setContador(trabajador.getContador() - 1);
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción y no puede estar 'Cancelado'.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            break;
        }
    }

    private static Pedido obtenerPedidoPorCodigo(Trabajador trabajador, String codigo) {
        if (trabajador.getP1() != null && trabajador.getP1().getCodigo().equalsIgnoreCase(codigo)) {
            return trabajador.getP1();
        }
        if (trabajador.getP2() != null && trabajador.getP2().getCodigo().equalsIgnoreCase(codigo)) {
            return trabajador.getP2();
        }
        // Añadir más comprobaciones si hay más pedidos

        return null;
    }

    public static void pedidosTrabajador(Trabajador trabajador) {
        System.out.println("==== Pedidos asignados al trabajador ====");
        if (trabajador.getP1() != null) {
            System.out.printf("""
                    ==== Asignación de trabajadores a pedidos ====
                    1. %s - %s %s - %d productos - %.2f
                    """, trabajador.getP1().getCodigo(), trabajador.getP1().getCliente().getNombre(), trabajador.getP1().getCliente().getApellido(), trabajador.getP1().getCantidadTotalProductos(), trabajador.getP1().getTotal());
        } else {
            System.out.println("No hay pedido 1 asignado.");
        }
        if (trabajador.getP2() != null) {
            System.out.printf("""
                    ==== Asignación de trabajadores a pedidos ====
                    2. %s - %s %s - %d productos - %.2f
                    """, trabajador.getP2().getCodigo(), trabajador.getP2().getCliente().getNombre(), trabajador.getP2().getCliente().getApellido(), trabajador.getP2().getCantidadTotalProductos(), trabajador.getP2().getTotal());
        } else {
            System.out.println("No hay pedido 2 asignado.");
        }
        System.out.print("Seleccione el pedido a asignar : ");
    }

    private static Producto obtenerProducto(Trabajador trabajador, ProductosData productosData) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código del producto que desea modificar: ");
        String codigoProducto = s.nextLine();

        if (ProductosData.Producto1 != null && ProductosData.Producto1.getCodigo().equalsIgnoreCase(codigoProducto)) {
            return ProductosData.Producto1;
        }
        if (ProductosData.Producto2 != null && ProductosData.Producto2.getCodigo().equalsIgnoreCase(codigoProducto)) {
            return ProductosData.Producto2;
        }
        if (ProductosData.Producto3 != null && ProductosData.Producto3.getCodigo().equalsIgnoreCase(codigoProducto)) {
            return ProductosData.Producto3;
        }
        if (ProductosData.Producto4 != null && ProductosData.Producto4.getCodigo().equalsIgnoreCase(codigoProducto)) {
            return ProductosData.Producto4;
        }
        if (ProductosData.Producto5 != null && ProductosData.Producto5.getCodigo().equalsIgnoreCase(codigoProducto)) {
            return ProductosData.Producto5;
        }

        System.out.println("Producto no encontrado.");
        return null;
    }

    public static void modificarProducto(Trabajador trabajador, ProductosData productosData) {
        Scanner s = new Scanner(System.in);
        Producto producto = obtenerProducto(trabajador, productosData);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.printf("""
                =====================================
                          MODIFICAR PRODUCTO
                =====================================
                Producto actual:
                %s
                =====================================""", producto.pintaProducto());

        System.out.print("\nIngrese el nuevo nombre del producto (deje en blanco para mantener el valor actual): ");
        String nuevoNombre = s.nextLine();

        System.out.print("\nIngrese el nuevo precio del producto (deje en blanco para mantener el valor actual): ");
        String precioStr = s.nextLine();
        Double nuevoPrecio = precioStr.isEmpty() ? null : Double.parseDouble(precioStr);

        System.out.print("\nIngrese el nuevo stock del producto (deje en blanco para mantener el valor actual): ");
        String stockStr = s.nextLine();
        Integer nuevoStock = stockStr.isEmpty() ? null : Integer.parseInt(stockStr);

        producto.modificarProducto(nuevoNombre, nuevoPrecio, nuevoStock);

        System.out.println("""
                =====================================
                Producto modificado exitosamente.
                =====================================""");
    }

    public static void modificarDatosTrabajador(Trabajador trabajador) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre del trabajador (deje en blanco para mantener el valor actual):");
        String nuevoNombre = s.nextLine();
        System.out.println("Ingrese la nueva contraseña del trabajador (deje en blanco para mantener el valor actual):");
        String nuevaContrasena = s.nextLine();

        trabajador.modificarDatos(nuevoNombre, nuevaContrasena);

        System.out.println("Datos del trabajador modificados exitosamente.");
    }

    public static void menuRegistro() {
        //aqui se le pedida al usuario que introducza los datos para registrarse siempre que no exista ya y haya hueco entre los clientes

    }

    // Menú para el administrador
    public static void menuAdmin(Admin admin/*, Pedido pedido*/) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opAdmin;
        System.out.printf("""
                FERNANSHOP
                Bienvenido %s. Tiene 2 pedido por asignar.
                1.- Asignar un pedido a un trabajador
                2.- Modificar el estad de un pedido
                3.- Dar de alta un trabajador
                4.- Ver todos los pedidos
                5.- Ver todos los clientes
                6.- Ver todos los trabajadores
                7.- Cerrar sesión
                \n
                Seleccione una opcion:\s""", admin.getNombre());
        opAdmin = s.nextLine();
        switch (opAdmin) {
            case "1":
                //menuAsignaPedido(pedido);
                break;
            case "2":
                //menuEstado(pedido);
                break;
            case "3":
                //altaTrabajador();
                break;
            case "4":
                //verPedidos();
                break;
            case "5":
                //verClientes();
                break;
            case "6":
                //verTrabajadores();
                break;
            case "7":
                break;
            default:
                break;
        }
    }

    // Mostrar el estado de un pedido
    /*public void estadoPedido(Trabajador trabajador) {
        System.out.printf("""
                ===========  Pedido %d ===========
                Estado: %s
                Cliente: %s %s
                Dirección: %s
                Localidad: %s
                Teléfono: %d
                Correo: %s
                Fecha del Pedido: %s
                Fecha de entrega estimada: %s
                Comentario del pedido: %s
                Detalle del pedido
                \t%s
                \t%s
                Total pedido: %f""", trabajador.getP1().getCodigo(), trabajador.getP1().getEstado(), trabajador.getP1().getCliente().getNombre(), trabajador.getP1().getCliente().getApellido(), trabajador.getP1().getCliente().getDireccion(), trabajador.getP1().getCliente().getLocalidad(), trabajador.getP1().getCliente().getTelefono(), trabajador.getP1().getCliente().getEmail(), trabajador.getP1().getFechaPedido(), trabajador.getP1().getFechaEntrega(), trabajador.getP1().getComentario(), trabajador.getP1().getProducto1().pintaProducto(), trabajador.getP1().getProducto2().pintaProducto(), trabajador.getP1().getTotal());
    }*/


// Menú para asignar un pedido a un trabajador
    /*public void menuAsignaPedido(Pedido pedido) {
        System.out.printf("""
                ==== Asignación del pedido %d  ====
                1. %s - %d pedido en proceso
                2. %s - %d pedidos en proceso
                Seleccione el trabajador:\s""", pedido.getCodigo(), pedido.getTrabajador().getNombre(), pedido.getTrabajador().getContador(), pedido.getTrabajador().getNombre(), pedido.getTrabajador().getContador());
    }*/

}