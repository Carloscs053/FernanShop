package utils;

import models.Admin;
import models.Cliente;
import models.Pedido;
import models.Trabajador;

public class Menus {

    // Menú para el cliente
    public void menuCliente(Cliente cliente) {
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
    public void menuTrabajador(Trabajador trabajador) {
        System.out.printf("""
                FERNANSHOP
                Bienvenido %s. Tienes %d pedidos que gestionar
                1.- Consultar los pedidos que tengo asignados
                2.- Modificar el estado de un pedido
                3.- Consultar el catálogo de productos
                4.- Modificar un producto del catálogo
                5.- Ver mi perfil
                6.- Modificar mis datos personales
                7.- Cerrar sesión
                \n
                Seleccione una opcion:\s""", trabajador.getNombre());
    }

    // Menú para el administrador
    public static void menuAdmin(String nombre/*, Pedido pedido*/) {
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
                Seleccione una opcion:\s""", nombre);
    }

    // Menú para actualizar el estado de un pedido
    public void menuEstado(Pedido pedido) {
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