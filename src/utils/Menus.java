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
    }

    public static void modificaCliente() {
        System.out.println("""
                ¿Qué campo desea modificar?
                1. Nombre
                2. Apellido
                3. Email
                4. Teléfono
                5. Dirección
                6. Volver al menú principal""");
    }

    // Menú para el trabajador
    public static void menuTrabajador(Trabajador trabajador, ProductosData productosData, Tienda tienda) {
        var s = new Scanner(System.in);
        String opTrabajador;
        Utils.cargandoPantalla();
        Utils.limpiaPantalla();
        do {
            // Mostrar el menú del trabajador
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
                    
                    Seleccione una opción:\s""", trabajador.getNombre(), trabajador.contarPedidos());
            opTrabajador = s.nextLine();
            switch (opTrabajador) {
                case "1":
                    // Consultar los pedidos asignados al trabajador
                    pedidosTrabajador(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "2":
                    // Modificar el estado de un pedido
                    menuEstado(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "3":
                    // Consultar el catálogo de productos
                    String catalogo = tienda.verCatalogo(productosData);
                    System.out.println(catalogo);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "4":
                    // Modificar un producto del catálogo
                    modificarProducto(trabajador, productosData);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "5":
                    // Ver el perfil del trabajador
                    System.out.println(trabajador.verPerfil());
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "6":
                    // Modificar los datos personales del trabajador
                    modificarDatosTrabajador(trabajador);
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                case "7":
                    // Cerrar sesión
                    System.out.println("Cerrando sesión...");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
            }
        } while (!opTrabajador.equals("7"));
    }

    private static Pedido obtenerPedidoPorCodigo(Trabajador trabajador, String codigo) {
        if (trabajador.getP1() != null && trabajador.getP1().getCodigo().equalsIgnoreCase(codigo)) {
            return trabajador.getP1();
        }
        if (trabajador.getP2() != null && trabajador.getP2().getCodigo().equalsIgnoreCase(codigo)) {
            return trabajador.getP2();
        }
        return null;
    }

    // Menú para actualizar el estado de un pedido
    public static void menuEstado(Trabajador trabajador) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el código del pedido que desea modificar:");
        String codigoPedido = s.nextLine();
        String confirmacion = "Estado actualizado correctamente.";
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
                    // Cambiar el estado del pedido a "Recibido"
                    pedido.setEstado("Recibido");
                    System.out.println(confirmacion);
                    recibido = true;
                    break;
                case "2":
                    // Cambiar el estado del pedido a "En Preparación" si ya está "Recibido"
                    if (recibido) {
                        pedido.setEstado("En Preparación");
                        System.out.println(confirmacion);
                        enPreparacion = true;
                    } else {
                        System.out.println("Debe seleccionar 'Recibido' antes de seleccionar esta opción.");
                    }
                    break;
                case "3":
                    // Cambiar el estado del pedido a "Retrasado" si ya está "En Preparación"
                    if (enPreparacion) {
                        pedido.setEstado("Retrasado");
                        System.out.println(confirmacion);
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción.");
                    }
                    break;
                case "4":
                    // Cambiar el estado del pedido a "Cancelado"
                    pedido.setEstado("Cancelado");
                    System.out.println(confirmacion);
                    cancelado = true;
                    break;
                case "5":
                    // Cambiar el estado del pedido a "Enviado" si ya está "En Preparación" y no está "Cancelado"
                    if (enPreparacion && !cancelado) {
                        pedido.setEstado("Enviado");
                        System.out.println(confirmacion);
                        // Restar 1 al contador de pedidos del trabajador
                        trabajador.setContador(trabajador.getContador() - 1);
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción y no puede estar 'Cancelado'.");
                    }
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
            cambiarFechaEntrega(pedido);
            aniadirComentario(pedido);
            break;
        }
    }

    public static void cambiarFechaEntrega(Pedido pedido) {
        Scanner s = new Scanner(System.in);
        System.out.print("¿Desea cambiar la fecha de entrega del pedido? (S/N):");
        String respuesta = s.nextLine().trim().toUpperCase();

        if (respuesta.equals("S")) {
            System.out.print("Ingrese la cantidad de días de retraso:");
            String diaRetraso = s.nextLine();

            // Validar que el valor introducido sea un dígito
            if (esDigito(diaRetraso)) {
                int diasRetraso = Integer.parseInt(diaRetraso);
                pedido.setDiasRetraso(diasRetraso);
                System.out.print("La fecha de entrega del pedido ha sido actualizada con " + diasRetraso + " días de retraso.");
            } else {
                System.out.print("Valor no válido. Debe ingresar un número.");
            }
        } else {
            System.out.print("No se ha cambiado la fecha de entrega del pedido.");
        }
    }

    // Método auxiliar para verificar si una cadena contiene solo dígitos
    private static boolean esDigito(String diaRetraso) {
        for (int i = 0; i < diaRetraso.length(); i++) {
            char c = diaRetraso.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static void aniadirComentario(Pedido pedido) {
        Scanner s = new Scanner(System.in);
        System.out.println("¿Desea añadir un comentario al pedido? (S/N):");
        String respuesta = s.nextLine();

        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el comentario:");
            String comentario = s.nextLine().toLowerCase();
            pedido.setComentario(comentario);
            System.out.println("Comentario añadido correctamente.");
        } else {
            System.out.println("No se ha añadido ningún comentario al pedido.");
        }
    }

    // Consultar los pedidos asignados al trabajador
    public static void pedidosTrabajador(Trabajador trabajador) {
        System.out.println("==== Pedidos asignados al trabajador ====");
        if (trabajador.getP1() != null) {
            System.out.printf("""  
                            1. %s - %s %s (%s) - %s  - %.2f
                            """,
                    trabajador.getP1().getCodigo(),
                    trabajador.getP1().getCliente().getNombre(),
                    trabajador.getP1().getCliente().getApellido(),
                    trabajador.getP1().getCliente().getProvincia(),
                    (trabajador.getP1().getCantidadProductos() < 2) ?
                            trabajador.getP1().getCantidadProductos() + " Producto"
                            : trabajador.getP1().getCantidadProductos() + " Productos",
                    trabajador.getP1().getTotal());
        } else {
            System.out.println("No hay pedido 1 asignado.");
        }
        if (trabajador.getP2() != null) {
            System.out.printf("""
                            2. %s - %s %s (%s) - %s - %.2f
                            """,
                    trabajador.getP2().getCodigo(),
                    trabajador.getP2().getCliente().getNombre(),
                    trabajador.getP2().getCliente().getApellido(),
                    trabajador.getP2().getCliente().getProvincia(),
                    (trabajador.getP2().getCantidadProductos() < 2) ?
                            trabajador.getP1().getCantidadProductos() + " Producto"
                            : trabajador.getP1().getCantidadProductos() + " Productos",
                    trabajador.getP2().getTotal());
            consultarPedido();
        } else {
            System.out.println("No hay pedido 2 asignado.");
        }
    }

    private static void consultarPedido() {
        var s = new Scanner(System.in);

    }

    // Obtener un producto por su código
    private static Producto obtenerProducto(Trabajador trabajador, ProductosData productosData) {
        Scanner s = new Scanner(System.in);
        System.out.print("Ingrese el código del producto que desea modificar: ");
        String codigoProducto = s.nextLine();
//Esto lo logico seria hacerlo en su clase correspondiente
        if (ProductosData.Producto1 != null && ProductosData.Producto1.getCodigo().equals(codigoProducto)) {
            return ProductosData.Producto1;
        }
        if (ProductosData.Producto2 != null && ProductosData.Producto2.getCodigo().equals(codigoProducto)) {
            return ProductosData.Producto2;
        }
        if (ProductosData.Producto3 != null && ProductosData.Producto3.getCodigo().equals(codigoProducto)) {
            return ProductosData.Producto3;
        }
        if (ProductosData.Producto4 != null && ProductosData.Producto4.getCodigo().equals(codigoProducto)) {
            return ProductosData.Producto4;
        }
        if (ProductosData.Producto5 != null && ProductosData.Producto5.getCodigo().equals(codigoProducto)) {
            return ProductosData.Producto5;
        }

        System.out.println("Producto no encontrado.");
        return null;
    }

    // Modificar un producto
    public static void modificarProducto(Trabajador trabajador, ProductosData productosData) {
        Scanner s = new Scanner(System.in);
        Producto producto = obtenerProducto(trabajador, productosData);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        System.out.printf("""
                ==========================
                    MODIFICAR PRODUCTO
                ==========================
                    Producto actual:
                    %s
                ==========================""", producto.pintaProducto());

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
                =========================================
                    Producto modificado exitosamente.
                =========================================""");
    }

    // Modificar los datos personales del trabajador
    public static void modificarDatosTrabajador(Trabajador trabajador) {
        Scanner s = new Scanner(System.in);
        System.out.print("Introduzca el nombre para actualizarlo (deje en blanco para mantener el valor actual): ");
        String nuevoNombre = s.nextLine();
        System.out.print("Ingrese la nueva contraseña (deje en blanco para mantener el valor actual): ");
        String nuevaClave = s.nextLine();
        System.out.print("Ingrese el numero de telefono (deje en blanco para mantener el valor actual): ");
        int nuevoTelefono = Integer.parseInt(s.nextLine());

        trabajador.modificarDatos(nuevoNombre, nuevaClave, nuevoTelefono);

        System.out.println("Datos del trabajador modificados exitosamente.");
    }

    // Menú para el registro de usuarios
    public static void menuRegistro() {
        // Aquí se le pedirá al usuario que introduzca los datos para registrarse siempre que no exista ya y haya hueco entre los clientes
    }

    // Menú para el administrador
    public static void menuAdmin(Tienda tienda) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opAdmin;
        // Mostrar el menú del administrador
        do {
            System.out.printf("""
                    FERNANSHOP
                    Bienvenido %s. Tiene %d pedido por asignar.
                    1.- Asignar un pedido a un trabajador
                    2.- Modificar el estad de un pedido
                    3.- Dar de alta un trabajador
                    4.- Ver todos los pedidos
                    5.- Ver todos los clientes
                    6.- Ver todos los trabajadores
                    7.- Cerrar sesión
                    \n
                    Seleccione una opcion:\s""", tienda.getAdmin().getNombre(), tienda.calcularPedidosNoAsignados());
            opAdmin = s.nextLine();
            switch (opAdmin) {
                case "1":
                    menuAsignaPedido(tienda);
                    break;
                case "2":
                    //menuEstado(admin);
                    break;
                case "3":
                    altaTrabajador(tienda.getAdmin());
                    break;
                case "4":
                    // verPedidos();
                    break;
                case "5":
                    // verClientes();
                    break;
                case "6":
                    // verTrabajadores();
                    break;
                case "7":
                    // Cerrar sesión
                    System.out.println("Cerrando sesión...");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
                    break;
                default:
                    // Opción no válida
                    System.out.println("Opción no válida. Intente de nuevo.");
                    Utils.pulseParaContinuar();
                    Utils.limpiaPantalla();
            }
        } while (!opAdmin.equals("7"));
    }

    // Menú para asignar un pedido a un trabajador
    public static void menuAsignaPedido(Tienda tienda) {
        Scanner s = new Scanner(System.in);

        // Listar todos los pedidos y mostrar si están asignados o no
        System.out.println("==== Pedidos ====");
        mostrarPedido(tienda, 1);
        mostrarPedido(tienda, 2);
        mostrarPedido(tienda, 3);
        mostrarPedido(tienda, 4);

        // Pedir al administrador que seleccione un pedido
        System.out.print("Seleccione el número del pedido que desea asignar: ");
        int seleccionPedido = s.nextInt();
        s.nextLine(); // Consumir el salto de línea

        Pedido pedidoSeleccionado = null;
        switch (seleccionPedido) {
            case 1:
                pedidoSeleccionado = tienda.getPedido1();
                break;
            case 2:
                pedidoSeleccionado = tienda.getPedido2();
                break;
            case 3:
                pedidoSeleccionado = tienda.getPedido3();
                break;
            case 4:
                pedidoSeleccionado = tienda.getPedido4();
                break;
            default:
                System.out.println("Selección no válida.");
                return;
        }

        if (pedidoSeleccionado == null) {
            System.out.println("Selección no válida.");
            return;
        }

        if (pedidoSeleccionado.getTrabajador() != null) {
            System.out.println("El pedido ya está asignado al trabajador: " + pedidoSeleccionado.getTrabajador().getNombre());
            return;
        }

        // Verificar si todos los trabajadores tienen el mismo número de pedidos
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();

        if (t1 != null && t2 != null && t3 != null) {
            if (t1.contarPedidos() == t2.contarPedidos() && t2.contarPedidos() == t3.contarPedidos()) {
                // Asignación manual
                System.out.println("Todos los trabajadores tienen el mismo número de pedidos. Seleccione manualmente el trabajador.");
                asignarPedidoManualmente(tienda, pedidoSeleccionado);
            } else {
                // Intentar asignación automática
                boolean asignado = pedidoSeleccionado.asignarAutomaticamente(tienda);
                if (asignado) {
                    System.out.println("Pedido asignado automáticamente.");
                } else {
                    asignarPedidoManualmente(tienda, pedidoSeleccionado);
                }
            }
        } else {
            // Asignación manual
            asignarPedidoManualmente(tienda, pedidoSeleccionado);
        }

        // Verificar si hay un trabajador con menos pedidos que los demás y asignar automáticamente el siguiente pedido
        boolean siguienteAsignado = Pedido.asignarSiguientePedidoAutomaticamente(tienda);
        if (siguienteAsignado) {
            System.out.println("El siguiente pedido ha sido asignado automáticamente al trabajador con menos pedidos.");
        }
    }

    private static void asignarPedidoManualmente(Tienda tienda, Pedido pedido) {
        Scanner s = new Scanner(System.in);
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();

        if (t1 != null && t2 != null && t3 != null) {
            System.out.printf("Seleccione el trabajador (1 para %s, 2 para %s, 3 para %s): ", t1.getNombre(), t2.getNombre(), t3.getNombre());
            int seleccionTrabajador = s.nextInt();

            boolean asignado = pedido.asignarManualmente(tienda, seleccionTrabajador);
            if (asignado) {
                System.out.println("Pedido asignado correctamente al trabajador.");
            } else {
                System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
            }
        } else if (t1 != null && t2 != null) {
            System.out.printf("Seleccione el trabajador (1 para %s, 2 para %s): ", t1.getNombre(), t2.getNombre());
            int seleccionTrabajador = s.nextInt();

            boolean asignado = pedido.asignarManualmente(tienda, seleccionTrabajador);
            if (asignado) {
                System.out.println("Pedido asignado correctamente al trabajador.");
            } else {
                System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
            }
        } else if (t1 != null) {
            System.out.printf("Seleccione el trabajador (1 para %s): ", t1.getNombre());
            int seleccionTrabajador = s.nextInt();

            boolean asignado = pedido.asignarManualmente(tienda, 1);
            if (asignado) {
                System.out.println("Pedido asignado correctamente al trabajador: " + t1.getNombre());
            } else {
                System.out.println("El trabajador no puede aceptar más pedidos.");
            }
        } else if (t2 != null) {
            System.out.printf("Seleccione el trabajador (2 para %s): ", t2.getNombre());
            int seleccionTrabajador = s.nextInt();

            boolean asignado = pedido.asignarManualmente(tienda, 2);
            if (asignado) {
                System.out.println("Pedido asignado correctamente al trabajador: " + t2.getNombre());
            } else {
                System.out.println("El trabajador no puede aceptar más pedidos.");
            }
        } else if (t3 != null) {
            System.out.printf("Seleccione el trabajador (3 para %s): ", t3.getNombre());
            int seleccionTrabajador = s.nextInt();

            boolean asignado = pedido.asignarManualmente(tienda, 3);
            if (asignado) {
                System.out.println("Pedido asignado correctamente al trabajador: " + t3.getNombre());
            } else {
                System.out.println("El trabajador no puede aceptar más pedidos.");
            }
        } else {
            System.out.println("No hay trabajadores disponibles para asignar el pedido.");
        }
    }

    private static void mostrarPedido(Tienda tienda, int numero) {
        Pedido pedido = switch (numero) {
            case 1 -> tienda.getPedido1();
            case 2 -> tienda.getPedido2();
            case 3 -> tienda.getPedido3();
            case 4 -> tienda.getPedido4();
            default -> null;
        };

        if (pedido != null) {
            if (pedido.getTrabajador() == null) {
                System.out.printf("%d. %s - %s %s (%s) - %s - %.2f\n",
                        numero,
                        pedido.getCodigo(),
                        pedido.getCliente().getNombre(),
                        pedido.getCliente().getApellido(),
                        pedido.getCliente().getProvincia(),
                        (pedido.getCantidadProductos() < 2) ?
                                pedido.getCantidadProductos() + " Producto"
                                : pedido.getCantidadProductos() + " Productos",
                        pedido.getTotal());
            } else {
                System.out.printf("%d. %s - %s %s (%s) - %s - %.2f - Asignado a: %s\n",
                        numero,
                        pedido.getCodigo(),
                        pedido.getCliente().getNombre(),
                        pedido.getCliente().getApellido(),
                        pedido.getCliente().getProvincia(),
                        (pedido.getCantidadProductos() < 2) ?
                                pedido.getCantidadProductos() + " Producto"
                                : pedido.getCantidadProductos() + " Productos",
                        pedido.getTotal(),
                        pedido.getTrabajador().getNombre());
            }
        }
    }

    // Metodo para dar de alta un trabajador
    public static void altaTrabajador(Admin admin) {
        Scanner s = new Scanner(System.in);

        // Solicitar datos del nuevo trabajador
        System.out.print("Ingrese el nombre del nuevo trabajador: ");
        String nombre = s.nextLine();

        System.out.print("Ingrese el email del nuevo trabajador: ");
        String email = s.nextLine();

        System.out.print("Ingrese la contraseña del nuevo trabajador: ");
        String clave = s.nextLine();

        System.out.print("Ingrese el número de teléfono del nuevo trabajador: ");
        int telefono = Integer.parseInt(s.nextLine());

        // Crear una nueva instancia de Trabajador
        Trabajador nuevoTrabajador = new Trabajador(nombre, email, clave, telefono);

        // Verificar si hay algún trabajador disponible y añadir el nuevo trabajador
        System.out.println(admin.altaTrabajador(nuevoTrabajador) ?
                "Nuevo trabajador dado de alta exitosamente." :
                "No se pudo dar de alta al trabajador. Todos los puestos están ocupados.");
    }
}