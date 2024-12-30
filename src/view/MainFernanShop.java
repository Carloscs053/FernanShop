package view;

import data.ClientesData;
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

        Tienda tienda = new Tienda();
        Cliente cliente1 = ClientesData.cliente1;
        Cliente cliente2 = ClientesData.cliente2;
        Trabajador trabajador1 = TrabajadoresData.trabajador1;
        Trabajador trabajador2 = TrabajadoresData.trabajador2;
        Trabajador trabajador3 = TrabajadoresData.trabajador3;
        Admin admin = new Admin("admin","admin@fernanshop.com","1234");

        System.out.println("""
                ███████╗███████╗██████╗ ███╗   ██╗ █████╗ ███╗   ██╗███████╗██╗  ██╗ ██████╗ ██████╗
                ██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗████╗  ██║██╔════╝██║  ██║██╔═══██╗██╔══██╗
                █████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██╔██╗ ██║███████╗███████║██║   ██║██████╔╝
                ██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║╚██╗██║╚════██║██╔══██║██║   ██║██╔═══╝
                ██║     ███████╗██║  ██║██║ ╚████║██║  ██║██║ ╚████║███████║██║  ██║╚██████╔╝██║    
                ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝    
                                                                                                    
                """);
        do {
            // Solicitar al usuario que seleccione una opción
            System.out.print("""
                    1. Iniciar Sesión.
                    2. Cerrar programa
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
                        Menus.menuAdmin(admin);                
                    } else if (tienda.loginTrabajador(nombre, contrasenia)) {
                        // Verificar si las credenciales son de un trabajador
                        logueado = true;
                        Trabajador trabajador = TrabajadoresData.getTrabajadorByEmail(nombre);
                        // Mostrar el menú del trabajador
                        Menus.menuTrabajador(trabajador);
                    } else {
                        // Mostrar mensaje de error si las credenciales son incorrectas
                        System.out.println("Usuario o contraseña incorrectos");
                        Utils.pulseParaContinuar();
                        Utils.limpiaPantalla();
                    }
                    break;

                case "2":
                    // Cerrar el programa
                    logueado = false;
                    System.out.println("Programa cerrado.");
                    break;

                default:
                    // Mostrar mensaje de error si la opción no es válida
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (!logueado);
    }
}
