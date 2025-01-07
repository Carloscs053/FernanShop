package utils;

import java.util.List;
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
        Utils.limpiaPantalla();
        
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
    
}

    public static Pedido obtenerPedidoPorCodigo(Tienda tienda, String codigoPedido) {
        // Busca en cada pedido de la tienda
        if (tienda.getPedido1() != null && tienda.getPedido1().getCodigo().equalsIgnoreCase(codigoPedido)) {
            return tienda.getPedido1();
        }
        if (tienda.getPedido2() != null && tienda.getPedido2().getCodigo().equalsIgnoreCase(codigoPedido)) {
            return tienda.getPedido2();
        }
        if (tienda.getPedido3() != null && tienda.getPedido3().getCodigo().equalsIgnoreCase(codigoPedido)) {
            return tienda.getPedido3();
        }
        if (tienda.getPedido4() != null && tienda.getPedido4().getCodigo().equalsIgnoreCase(codigoPedido)) {
            return tienda.getPedido4();
        }
        return null; // Si no se encuentra el pedido
    }

    // Menú para actualizar el estado de un pedido
    public static void menuEstado(Tienda tienda) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese el código del pedido que desea modificar:");
        String codigoPedido = s.nextLine();
        String confirmacion = "Estado actualizado correctamente.";

        // Supongamos que tienes un método en Tienda para obtener un Pedido por su código
        Pedido pedido = obtenerPedidoPorCodigo(tienda, codigoPedido);
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
                    System.out.println(confirmacion);
                    recibido = true;
                    break;
                case "2":
                    if (recibido) {
                        pedido.setEstado("En Preparación");
                        System.out.println(confirmacion);
                        enPreparacion = true;
                    } else {
                        System.out.println("Debe seleccionar 'Recibido' antes de seleccionar esta opción.");
                    }
                    break;
                case "3":
                    if (enPreparacion) {
                        pedido.setEstado("Retrasado");
                        System.out.println(confirmacion);
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción.");
                    }
                    break;
                case "4":
                    pedido.setEstado("Cancelado");
                    System.out.println(confirmacion);
                    cancelado = true;
                    break;
                case "5":
                    if (enPreparacion && !cancelado) {
                        pedido.setEstado("Enviado");
                        System.out.println(confirmacion);
                        // Puedes acceder al contador de trabajadores desde la tienda si es necesario
                        // e.g., tienda.decrementarContadorTrabajadores();
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción y no puede estar 'Cancelado'.");
                    }
                    break;
                default:
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
    public static boolean esDigito(String diaRetraso) {
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
        } else {
            System.out.println("No hay pedido 2 asignado.");
        }
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

    // Menú para el registro de un cliente
    public static void menuRegistro(Tienda tienda) {
        Scanner s = new Scanner(System.in);
        System.out.println("==== Registro de un nuevo cliente ====");

        // Comprobar si hay espacio para un nuevo cliente
        if (tienda.getCliente1() != null && tienda.getCliente2() != null) {
            System.out.println("Error: No se puede registrar un nuevo cliente. La tienda ya tiene el máximo de clientes. en próximas actualizaciones solucionaremos este error");
            return;
        }

        System.out.print("Ingrese su nombre: ");
        String nombre = s.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = s.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccion = s.nextLine();
        System.out.print("Ingrese su ciudad: ");
        String ciudad = s.nextLine();
        System.out.print("Ingrese su provincia: ");
        String provincia = s.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = s.nextLine();
        System.out.print("Ingrese su email: ");
        String email = s.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String clave = s.nextLine();

        // Verificar si alguno de los datos está vacío
        if (nombre.isEmpty() || apellido.isEmpty() || direccion.isEmpty() || ciudad.isEmpty() || provincia.isEmpty() || telefono.isEmpty() || email.isEmpty() || clave.isEmpty()) {
            System.out.println("Error: No se ha añadido porque no hay datos.");
            return;
        }

        // Validar la contraseña
        if (!Utils.validaContrasenia(clave)) {
            System.out.println("Error: La contraseña no cumple con los requisitos.");
            return;
        }

        // Verificar si el cliente ya existe por el email o teléfono
        if ((tienda.getCliente1() != null && (tienda.getCliente1().getEmail().equals(email) || tienda.getCliente1().getTelefono().equals(telefono))) ||
            (tienda.getCliente2() != null && (tienda.getCliente2().getEmail().equals(email) || tienda.getCliente2().getTelefono().equals(telefono)))) {
            System.out.println("Error: Ya existe un cliente con ese email o teléfono.");
            return;
        }

        // Crear una nueva instancia de Cliente
        Cliente cliente = new Cliente(nombre, apellido, direccion, ciudad, provincia, telefono, email, clave);

        // Añadir el cliente a la tienda
        if (tienda.altaCliente(cliente)) {
            System.out.println("Cliente registrado exitosamente.");
        } else {
            System.out.println("Error: No se pudo registrar el cliente. La tienda ya tiene el máximo de clientes.");
        }
    }
    

    // Menú para el administrador
    public static void menuAdmin(Tienda tienda) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opAdmin;
        // Mostrar el menú del administrador
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
    }
    
    // Verifica que se esta añadiendo los pedidos antes de que se asignePedido automaticamente
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
    
        // Verificar si solo hay un trabajador disponible
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();
    
        if ((t1 != null && t2 == null && t3 == null) || (t1 == null && t2 != null && t3 == null) || (t1 == null && t2 == null && t3 != null)) {
            // Asignar automáticamente al único trabajador disponible
            boolean asignado = Pedido.asignarSiguientePedidoAutomaticamente(tienda);
            if (asignado) {
                System.out.println("Pedido asignado automáticamente al único trabajador disponible.");
            } else {
                System.out.println("No se pudo asignar el pedido automáticamente.");
            }
        } else {
            // Asignación manual o automática según el número de pedidos
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
        }
    }

    public static void asignarPedidoManualmente(Tienda tienda, Pedido pedido) {
        Scanner s = new Scanner(System.in);
        Trabajador t1 = tienda.getTrabajador1();
        Trabajador t2 = tienda.getTrabajador2();
        Trabajador t3 = tienda.getTrabajador3();
    
        // Check available workers and prompt for selection
        if (t1 != null && t2 != null && t3 != null) {
            System.out.printf("Seleccione el trabajador (1 para %s, 2 para %s, 3 para %s): ", t1.getNombre(), t2.getNombre(), t3.getNombre());
            int seleccionTrabajador = s.nextInt();
    
            // Check if the selected worker can accept more orders
            if (seleccionTrabajador == 1 && t1.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 1);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t1.getNombre());
                    t1.setContador(t1.contarPedidos());
                } else {
                    System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
                }
            } else if (seleccionTrabajador == 2 && t2.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 2);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t2.getNombre());
                    t2.setContador(t2.contarPedidos());
                } else {
                    System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
                }
            } else if (seleccionTrabajador == 3 && t3.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 3);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t3.getNombre());
                    t3.setContador(t3.contarPedidos());
                } else {
                    System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
                }
            } else {
                System.out.println("El trabajador ha alcanzado su límite de pedidos o la selección es no válida.");
            }
        } else if (t1 != null && t2 != null ) {
            System.out.printf("Seleccione el trabajador (1 para %s, 2 para %s): ", t1.getNombre(), t2.getNombre());
            int seleccionTrabajador = s.nextInt();
    
            // Check for selected worker
            if (seleccionTrabajador == 1 && t1.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 1);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t1.getNombre());
                    t1.setContador(t1.contarPedidos());
                } else {
                    System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
                }
            } else if (seleccionTrabajador == 2 && t2.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 2);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t2.getNombre());
                    t2.setContador(t2.contarPedidos());
                } else {
                    System.out.println("Selección no válida o el trabajador no puede aceptar más pedidos.");
                }
            } else {
                System.out.println("El trabajador ha alcanzado su límite de pedidos o la selección es no válida.");
            }
        } else if (t1 != null) {
            System.out.printf("Seleccione el trabajador (1 para %s): ", t1.getNombre());
            int seleccionTrabajador = s.nextInt();
    
            if (seleccionTrabajador == 1 && t1.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 1);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t1.getNombre());
                    t1.setContador(t1.contarPedidos());
                } else {
                    System.out.println("El trabajador no puede aceptar más pedidos.");
                }
            } else {
                System.out.println("El trabajador ha alcanzado su límite de pedidos o la selección es no válida.");
            }
        } else if (t2 != null) {
            System.out.printf("Seleccione el trabajador (2 para %s): ", t2.getNombre());
            int seleccionTrabajador = s.nextInt();
    
            if (seleccionTrabajador == 2 && t2.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 2);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t2.getNombre());
                    t2.setContador(t2.contarPedidos());
                } else {
                    System.out.println("El trabajador no puede aceptar más pedidos.");
                }
            } else {
                System.out.println("El trabajador ha alcanzado su límite de pedidos o la selección es no válida.");
            }
        } else if (t3 != null) {
            System.out.printf("Seleccione el trabajador (3 para %s): ", t3.getNombre());
            int seleccionTrabajador = s.nextInt();
    
            if (seleccionTrabajador == 3 && t3.contarPedidos() < 2) {
                boolean asignado = pedido.asignarManualmente(tienda, 3);
                if (asignado) {
                    System.out.println("Pedido asignado correctamente al trabajador: " + t3.getNombre());
                    t3.setContador(t3.contarPedidos());
                } else {
                    System.out.println("El trabajador no puede aceptar más pedidos.");
                }
            } else {
                System.out.println("El trabajador ha alcanzado su límite de pedidos o la selección es no válida.");
            }
        } else {
            System.out.println("No hay trabajadores disponibles para asignar el pedido.");
        }
    
        // Intentar asignar el siguiente pedido automáticamente
        boolean asignadoAutomaticamente = Pedido.asignarSiguientePedidoAutomaticamente(tienda);
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
        String numero = s.nextLine();
        // Crear una nueva instancia de Trabajador
        if (nombre.isEmpty() || email.isEmpty() || clave.isEmpty() || numero.isEmpty()) {
            System.out.println("\nNo se se ha añadido faltan datos importantes");
        } else {
            int telefono = Integer.parseInt(numero);
            Trabajador nuevoTrabajador = new Trabajador(nombre, email, clave, telefono);
            // Verificar si hay algún trabajador disponible y añadir el nuevo trabajador
            System.out.println(admin.altaTrabajador(nuevoTrabajador) ?
                    "\nNuevo trabajador dado de alta exitosamente." :
                    "\nNo se pudo dar de alta al trabajador. Todos los puestos están ocupados.");
        }
        Utils.pulseParaContinuar();
    }


}