package models;

public class Client {

    //Atributos
    private String name;
    private String surnames;
    private String address;
    private String locality;
    private String province;
    private String phoneNumber;
    private String email;
    private String password;

    //Atributos de la clase
    private static int orderCount = 0;


    //Constructor

    public Client(String name, String surnames, String address, String locality, String province,
                  String phoneNumber, String email, String password) {
        this.name = name;
        this.surnames = surnames;
        this.address = address;
        this.locality = locality;
        this.province = province;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.password = password;
        //TODO ¿cada vez que se crea un cliente se aumenta en 1 el pedido? quizás haya que cambiarlo de lugar
        //TODO probablemente sea más eficiente crear objetos de productos en esta clase y comprobar nulls
        orderCount++;
    }


    //Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static void setOrderCount(int orderCount) {
        Client.orderCount = orderCount;
    }

    //Otros métodos
    public boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.length() == 9;
    }

    //TODO borrador, pensar qué más cosas meter o cómo modificarlo
    public boolean validateEmail() {
        if (email.isEmpty()) return false;
        if (!email.contains("@") && !(email.contains(".com") || email.contains(".es"))) return false;
        return true;
    }

    //TODO
    public void makeOrder() {

    }



    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surnames='" + surnames + '\'' +
                ", address='" + address + '\'' +
                ", locality='" + locality + '\'' +
                ", province='" + province + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", orderCount=" + orderCount +
                '}';
    }
}
