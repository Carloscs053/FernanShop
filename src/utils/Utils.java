package utils;

import java.util.Scanner;

public class Utils {
    //TODO estoy tocando cosas relativamente insignificantes y eso que nos vamos ahorrando en tiempo de desarrollo
    public static void pulseParaContinuar() {
        var s = new Scanner(System.in);
        System.out.print("Pulse cualquier tecla para continuar...");
        s.nextLine();
    }

    // Metodo para limpiar la pantalla imprimiendo varias líneas en blanco
    public static void limpiaPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void cargandoPantalla() {
        System.out.print("\tCargando pantalla");
        for (int i = 0; i <= 3; i++) {
            System.out.print((i != 3) ? "." : "\n");
            try {
                Thread.sleep(350);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // Metodo para validar una clave con ciertas condiciones
    //he rescatado esta validacion de un ejercicio ya hecho en clase
    public static boolean validaClave(String clave) {
        //primero validamos la longitud
        if (clave.length() < 6 || clave.length() > 10) return false;
        //validación de las letras Mays o mínus
        if (clave.equals(clave.toUpperCase()) || clave.equals(clave.toLowerCase())) return false;
        //validación de un numero como mínimo
        boolean claveValide = false;
        for (int i = 0; i < clave.length(); i++) {
            if (Character.isDigit(clave.charAt(i))) {
                claveValide = true;
                //Rompemos bucle
                i = clave.length();
            }
        }
        if (!claveValide) return false;
        //Comprobamos si hay un character especial
        claveValide = clave.contains(".") || clave.contains("-") || clave.contains("+") || clave.contains("*");
        if (!claveValide) return false;
        return true;
    }

    // Metodo para validar una contraseña que tenga al menos 5 caracteres, una mayúscula y un número
    public static boolean validaContrasenia(String contrasenia) {
        boolean tieneMayuscula = false;
        boolean tieneNumero = false;
        if (contrasenia.length() < 5) {
            return false;
        }
        int i = 0;
        while (i < contrasenia.length()) {
            char c = contrasenia.charAt(i);
            if (Character.isUpperCase(c)) {
                tieneMayuscula = true;
            }
            if (Character.isDigit(c)) {
                tieneNumero = true;
            }
            i++;
        }
        return tieneMayuscula && tieneNumero;
    }

    // Metodo para validar un correo de trabajador que debe tener el dominio "@fernanshop.com"
    public static boolean validaCorreoTrabajador(String correo) {
        if (correo == null || correo.isEmpty()) {
            return false;
        }
        String dominio = "@fernanshop.com";
        return correo.endsWith(dominio);
    }
}