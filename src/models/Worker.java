package models;

public class Worker {

    //Atributos
    private String name;
    private String email;
    private int phoneNumber;
    //private cont?
    //private pese...?
    //No los veo bien en el UML, cosa que deberíamos desarrollar más en profundidad antes de continuar (creo)

    //Constructor (por hacer)



    //Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    //Otros métodos


    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
