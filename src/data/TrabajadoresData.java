package data;

import models.Trabajador;

public class TrabajadoresData {
    public static Trabajador trabajador1 = new Trabajador("Carlos", "carlos@fernando3martos.com", "El3gancia", 543678329);
    public static Trabajador trabajador2 = new Trabajador("Eduardo", "user", "1234", 923548346);
    public static Trabajador trabajador3 = new Trabajador("JL", "JLrEsHUloN@fernando3martos.com", "Huelga?", 943568235);
    
    public static Trabajador getTrabajadorByEmail(String email) {
        if (trabajador1.getEmail().equals(email)) {
            return trabajador1;
        } else if (trabajador2.getEmail().equals(email)) {
            return trabajador2;
        } else if (trabajador3.getEmail().equals(email)) {
            return trabajador3;
        } else {
            return null;
        }
    }
}
