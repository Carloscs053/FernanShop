package view;

import java.util.Scanner;

import data.ClientesData;
import data.TrabajadoresData;
import models.Admin;
import models.Cliente;
import models.Tienda;
import models.Trabajador;
import utils.Utils;

public class MainFernanShop {
    public static void main(String[] args) {
        var s = new Scanner(System.in);

        Tienda tienda = new Tienda();
        Cliente cliente1 = ClientesData.cliente1;
        Cliente cliente2 = ClientesData.cliente2;
        Trabajador trabajador1 = TrabajadoresData.trabajador1;
        Trabajador trabajador2 = TrabajadoresData.trabajador2;
        Trabajador trabajador3 = TrabajadoresData.trabajador3;
        //TODO IMPORTANTE BALANCES Y REAJUSTES NO SE NOS VAYA A PASAR ESTO JAJAJAJAAJAJAJ
        Admin admin = new Admin("Manuel", "goticasCulonas");
        String op = "";
        boolean logueado = true;

        do {
            System.out.println("""
                    
                    ███████╗███████╗██████╗ ███╗   ██╗ █████╗ ███╗   ██╗███████╗██╗  ██╗ ██████╗ ██████╗\s
                    ██╔════╝██╔════╝██╔══██╗████╗  ██║██╔══██╗████╗  ██║██╔════╝██║  ██║██╔═══██╗██╔══██╗
                    █████╗  █████╗  ██████╔╝██╔██╗ ██║███████║██╔██╗ ██║███████╗███████║██║   ██║██████╔╝
                    ██╔══╝  ██╔══╝  ██╔══██╗██║╚██╗██║██╔══██║██║╚██╗██║╚════██║██╔══██║██║   ██║██╔═══╝\s
                    ██║     ███████╗██║  ██║██║ ╚████║██║  ██║██║ ╚████║███████║██║  ██║╚██████╔╝██║    \s
                    ╚═╝     ╚══════╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝ ╚═════╝ ╚═╝    \s
                                                                                                        \s
                    """);
            do {
                //¿Metemos registros?
                System.out.println("""
                        1. Iniciar Sesión.
                        2. Cerrar programa""");
                op = s.nextLine();

                switch (op) {
                    case "1":
                        System.out.println("Nombre: ");
                        String nombre = s.nextLine();
                        System.out.println("Contraseña: ");
                        String contrasenia = s.nextLine();

                        if (admin.loginAdmin(nombre, contrasenia)) {
                            logueado = true;
                            //Hay que poner cosas, es un "boceto"
                            System.out.println("Bienvenido" + admin.getNombre());
                        } else if (Trabajador.(nombre, contrasenia)) { //Hay que echar un ojo, mirar en fernanelf, me tengo que ir
                            logueado = true;
                            System.out.println("Bienvenido" + /*¿?*/);
                        }
                        break;
                    case "2":
                        break;
                    default:
                        System.out.println("Opción no válida");
                        System.out.println("Pulse para continuar...");
                        Utils.pulseParaContinuar();
                        Utils.limpiaPantalla();
                        break;
                }
            } while (!op.equals("2"));
        } while (!logueado);
    }
}
