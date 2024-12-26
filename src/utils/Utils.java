package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    //TODO estoy tocando cosas relativamente insignificantes y eso que nos vamos ahorrando en tiempo de desarrollo
    public static void presionaContinuar() {
        var s  = new Scanner(System.in);
        System.out.println("Pulse cualquier tecla para continuar...");
        s.nextLine();
    }

    // Método para limpiar la pantalla imprimiendo varias líneas en blanco
    public static void limpiaPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    // Método para validar un email utilizando una expresión regular
    //he buscado validar email en internet y con ayuda de mni hermano lo he puesto asi
    public static boolean validaEmail (String email) {
        return Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(email).matches();
    }

    // Método para validar una clave con ciertas condiciones
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

    // Método para validar una contraseña que tenga al menos 5 caracteres, una mayúscula y un número
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

    // Método para validar un correo de trabajador que debe tener el dominio "@fernanshop.com"
    public static boolean validaCorreoTrabajador(String correo) {
        if (correo == null || correo.isEmpty()) {
            return false;
        }
        String dominio = "@fernanshop.com";
        return correo.endsWith(dominio);
    }
}
