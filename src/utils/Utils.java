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

    public static void limpiaPantalla() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    //he buscado validar email en internet y con ayuda de mni hermano lo he puesto asi
    public static boolean validaEmail (String email) {
        return Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$").matcher(email).matches();
    }

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
}
