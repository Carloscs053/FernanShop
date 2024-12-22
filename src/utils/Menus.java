package utils;


public class Menus {
    //TODO investigar cómo printear el nombre necesario aquí
    public void clientMenu(String name) {
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
                Seleccione una opcion:\s""", name);
    }

    //TODO más de lo mismo
    public void workerMenu(String name) {
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
                Seleccione una opcion:\s""", name);//TODO Mirar %d en trabajador y admin
    }

    //TODO same
    public void adminMenu(String name) {
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
                Seleccione una opcion:\s""", name);
    }

    public void name() {//TODO TERMINARLO 22/12
        System.out.printf("""
                 ==== Actualización del pedido %d ====
                 Estado del pedido: %s
                 Nuevo estado:
                \t1. Recibido
                \t2. En Preparación
                \t3. Retrasado
                \t4. Cancelado
                \t5. Enviado
                Seleccione el nuevo estado:\s
                """);
    }

    public void asigancionPedidos() {
        System.out.printf("""
                 ==== Asignación del pedido %d o %s  ====
                 1. %s - %d pedido en proceso
                 2. %s - %d pedidos en proceso
                 Seleccione el trabajador:\s""");
    }
}
