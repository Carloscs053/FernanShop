package view;

import data.ClientesData;
import data.ProductosData;
import data.TrabajadoresData;
import models.*;
import utils.Menus;
import utils.Utils;

import java.util.Scanner;

public class MainFernanShop {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String op;
        boolean logueado = false;
        ProductosData productosData = new ProductosData();
        Tienda tienda = new Tienda();
        Cliente cliente1 = ClientesData.cliente1;
        Cliente cliente2 = ClientesData.cliente2;
        Trabajador trabajador1 = TrabajadoresData.trabajador1;
        Trabajador trabajador2 = TrabajadoresData.trabajador2;
        Trabajador trabajador3 = TrabajadoresData.trabajador3;
        Admin admin = new Admin("admin", "admin@fernanshop.com", "1234");
        Pedido pedido1 = new Pedido(ProductosData.Producto1, ProductosData.Producto2, ProductosData.Producto3, "Comentario del pedido", "Recibido", 0, cliente1);
        trabajador2.setP1(pedido1);
        trabajador2.cuentaPedidos();

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
                    // Solicitar nombre y contraseña para iniciar sesión
                    System.out.print("Nombre: ");
                    String nombre = s.nextLine();
                    System.out.print("Contraseña: ");
                    String contrasenia = s.nextLine();

                    // Verificar si las credenciales son de un administrador
                    if (admin.loginAdmin(nombre, contrasenia)) {
                        logueado = true;
                        // Mostrar el menú del administrador
                        Utils.limpiaPantalla();
                        Menus.menuAdmin(admin);
                    } else if (tienda.loginTrabajador(nombre, contrasenia)) {
                        // Verificar si las credenciales son de un trabajador
                        logueado = true;
                        Trabajador trabajador = Tienda.getTrabajadorByEmail(nombre);
                        // Mostrar el menú del trabajador
                        Utils.limpiaPantalla();
                        Menus.menuTrabajador(trabajador, productosData, tienda);
                    } else {
                        // Mostrar mensaje de error si las credenciales son incorrectas
                        System.out.println("Usuario o contraseña incorrectos");
                        Utils.pulseParaContinuar();
                        Utils.limpiaPantalla();
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