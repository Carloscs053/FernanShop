package utils;

import java.util.Scanner;

import models.Admin;
import models.Cliente;
import models.Pedido;
import models.Trabajador;

public class Menus {

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

    // Menú para el trabajador
    public static void menuTrabajador(Trabajador trabajador) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opTrabajador;
        System.out.printf("""
                FERNANSHOP
                Bienvenido %s. Tienes 3 pedidos que gestionar
                1.- Consultar los pedidos que tengo asignados
                2.- Modificar el estado de un pedido
                3.- Consultar el catálogo de productos
                4.- Modificar un producto del catálogo
                5.- Ver mi perfil
                6.- Modificar mis datos personales
                7.- Cerrar sesión
                \n
                Seleccione una opcion:\s""", trabajador.getNombre());
                opTrabajador = s.nextLine();
                switch (opTrabajador) {
                    case "1":
                        //pedidosTrabajador();
                        break;
                    case "2":
                        //menuEstado();
                        break;
                    case "3":
                        //verCatalogo();
                        break;
                    case "4":
                        //modificarProducto();
                        break;
                    case "5":
                        //verPerfil();
                        break;
                    case "6":
                        //modificarDatos();
                        break;
                    case "7":
                        break;
                    default:
                        break;
                }
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
                Seleccione una opcion:\s""", admin.getNombre() );
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

    // Menú para actualizar el estado de un pedido
    public static void menuEstado(Pedido pedido) {
        Utils.limpiaPantalla();
        var s = new Scanner(System.in);
        String opEstado;
        boolean recibido = false;
        boolean enPreparacion = false;
        boolean cancelado = false;
        while (true) {
            System.out.printf("""
                    ==== Actualización del pedido %d ====
                    Estado del pedido: %s
                    Nuevo estado:
                    \t1. Recibido
                    \t2. En Preparación
                    \t3. Retrasado
                    \t4. Cancelado
                    \t5. Enviado
                    Seleccione el nuevo estado:\s""", pedido.getCodigo(), pedido.getEstado());
            opEstado = s.nextLine();
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
                        continue;
                    }
                    break;
                case "3":
                    if (enPreparacion) {
                        pedido.setEstado("Retrasado");
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción.");
                        continue;
                    }
                    break;
                case "4":
                    pedido.setEstado("Cancelado");
                    cancelado = true;
                    break;
                case "5":
                    if (enPreparacion && !cancelado) {
                        pedido.setEstado("Enviado");
                    } else {
                        System.out.println("Debe seleccionar 'En Preparación' antes de seleccionar esta opción y no puede estar 'Cancelado'.");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }
            break;
        }
    }

    // Mostrar el estado de un pedido
    /*public void estadoPedido(Pedido pedido) {
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
                Total pedido: %f""", pedido.getCodigo(), pedido.getEstado(), Cliente. , pedido.getCliente().getApellido(), pedido.getCliente().getDireccion(), pedido.getCliente().getLocalidad(), pedido.getCliente().getTelefono(), pedido.getCliente().getEmail(), pedido.getFechaPedido(), pedido.calculateDays(), pedido.getComentario(), pedido.getP1(), pedido.getP2(), pedido.getTotal());
    }

    // Menú para mostrar los pedidos asignados a un trabajador
    public void pedidosTrabajador(Pedido pedido) {
        System.out.printf("""
                ==== Asiganción de trabajadores a pedidos ====
                1. %d - %s - %d prodcutos - %f
                2. %d - %s - %d prodcutos - %f
                Seleccione el pedido a asignar :\s""", pedido.getCodigo(), pedido.getCliente().getNombre(), pedido.getTotal(), pedido.getCodigo(), pedido.getCliente().getNombre(), pedido.getTotal());
    }

    // Menú para asignar un pedido a un trabajador
    public void menuAsignaPedido(Pedido pedido) {
        System.out.printf("""
                ==== Asignación del pedido %d  ====
                1. %s - %d pedido en proceso
                2. %s - %d pedidos en proceso
                Seleccione el trabajador:\s""", pedido.getCodigo(), pedido.getTrabajador().getNombre(), pedido.getTrabajador().getContador(), pedido.getTrabajador().getNombre(), pedido.getTrabajador().getContador());
    }*/
}