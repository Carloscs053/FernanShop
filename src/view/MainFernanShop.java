package view;

import data.ClientesData;
import data.ProductosData;
import data.TrabajadoresData;
import models.*;
import utils.Menus;
import utils.Utils;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

public class MainFernanShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String op;
        boolean logueado = false;
        ProductosData productosData = new ProductosData();
        Tienda tienda = new Tienda();
        //Creo que en el main solo se invoca a tienda, que es el controlador y maneja los users
        Cliente cliente1 = ClientesData.cliente1;
        Cliente cliente2 = ClientesData.cliente2;
        Trabajador trabajador1 = TrabajadoresData.trabajador1;
        Trabajador trabajador2 = TrabajadoresData.trabajador2;
        Trabajador trabajador3 = TrabajadoresData.trabajador3;
        //Creo que esto se crea en el controlador, al igual que todos los users
        Admin admin = new Admin("admin", "admin@fernanshop.com", "1234");
        //Pedido pedido1 = new Pedido(ProductosData.Producto1, ProductosData.Producto2, ProductosData.Producto3, "Comentario del pedido", "Recibido", 0, cliente1);
        Pedido pedido2 = new Pedido(ProductosData.Producto4, ProductosData.Producto3, "", "Recibido", 0, cliente1);
        //trabajador2.setP1(pedido1);
        trabajador2.setP2(pedido2);
        trabajador2.cuentaPedidos();

        tienda.mock();

        System.out.println("""
                ███████╗███████╗██████╗ ███╗   ██╗ █████╗ ███╗   ██╗███████╗██╗  ██╗ ██████╗ ██████╗
                ██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗████╗  ██║██╔════╝██║  ██║██╔═══██╗██╔══██╗
                █████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██╔██╗ ██║███████╗███████║██║   ██║██████╔╝
                ██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║╚██╗██║╚════██║██╔══██║██║   ██║██╔═══╝
                ██║     ███████╗██║  ██║██║ ╚████║██║  ██║██║ ╚████║███████║██║  ██║╚██████╔╝██║
                ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝
                                
                """);
        while (true) {
            // Solicitar al usuario que seleccione una opción
            System.out.print("""
                    1. Iniciar Sesión.
                    2. Registrarse
                    Seleccione una opción:\s""");
            op = s.nextLine();

            switch (op) {
                case "1":
                    //Reiniciamos el logueado para que al volver a este punto no entre en el perfil anterior
                    logueado = false;
                    // Solicitar nombre y contraseña para iniciar sesión
                    System.out.print("Email: ");
                    String email = s.nextLine();
                    System.out.print("Contraseña: ");
                    String clave = s.nextLine();
                    //Cliente tempCliente = tienda.loginCliente(email, clave);
                    //Trabajador tempTrabajador = tienda.loginTrabajador(email, clave);

                    //Comprueba si es el admin
                    if (admin.loginAdmin(email, clave)) {
                        logueado = true;
                        Utils.limpiaPantalla();
                        //Esto va dentro de un do-while y con un switch
                        Menus.menuAdmin(admin);
                    } else {
                        //Si no, comprueba si es un trabajador
                        Trabajador tempTrabajador = tienda.loginTrabajador(email, clave);
                        if (tempTrabajador != null) {
                            logueado = true;
                            Utils.limpiaPantalla();
                            //Do-while (preguntar por las variables
                            Menus.menuTrabajador(tempTrabajador, productosData, tienda);
                        } else {
                            //Si no lo es, comprueba si es un cliente
                            Cliente tempCliente = tienda.loginCliente(email, clave);
                            if (tempCliente != null) {
                                logueado = true;
                                Utils.limpiaPantalla();
                                //Do-while
                                String opCliente = "", opProducto = "";
                                do {
                                    Menus.menuCliente(tempCliente);
                                    opCliente = s.nextLine();

                                    switch (opCliente) {
                                        case "1":
                                            //Aquí pinta el catálogo
                                            System.out.println(tienda.pintaCatalogo());
                                            Utils.pulseParaContinuar();
                                            break;
                                        case "2":
                                            //Aquí puede realizar el pedido
                                            System.out.println(tienda.pintaCatalogo());
                                            System.out.println();
                                            System.out.println("6. Realizar pedido");
                                            System.out.println("7. Cancelar pedido");
                                            do {
                                                switch (opProducto) {

                                                }
                                            } while (!opProducto.equals("7"));

                                            //realizaPedido();
                                            break;
                                        case "3":
                                            //Aquí comprueba los pedidos del usuario
                                            //verPedidos();
                                            break;
                                        case "4":
                                            //Muestra los datos del usuario
                                            //verPerfil();
                                            break;
                                        case "5":
                                            //Modifica los datos del usuario si este así lo quiere
                                            //cliente.modificarDatos();
                                            break;
                                        case "6":
                                            //Sale de la sesión del usuario
                                            System.out.println("Hasta pronto!");
                                            Utils.pulseParaContinuar();
                                            Utils.limpiaPantalla();
                                            break;
                                        default:
                                            System.out.println("Opción no válida");
                                            break;
                                    }
                                } while (!opCliente.equals("6"));
                            } else {
                                //Si no es nada de lo anterior, las credenciales no son correctas
                                System.out.println("Email y/o contraseña incorrectas");
                            }
                        }
                    }
                    break;

                case "2":
                    // Solicitar al usuario que se registre llamando a un metodo
                    Menus.menuRegistro();
                    break;


                default:
                    // Mostrar mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}