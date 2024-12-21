package utils;

import java.util.Scanner;

public class Utils {
    //TODO estoy tocando cosas relativamente insignificantes y eso que nos vamos ahorrando en tiempo de desarrollo
    public static void pressToContinue() {
        var s  = new Scanner(System.in);
        System.out.println("Pulse cualquier tecla para continuar...");
        s.nextLine();
    }
}
