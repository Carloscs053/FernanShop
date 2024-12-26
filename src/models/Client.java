package models;

public class Client {

    //Atributos
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private String provincia;
    //TODO cambiaría a int y metería validación
    private String telefono;
    private String email;
    private String contrasenia;
    private Order p1;
    private Order p2;

    //Atributos de la clase
    private static int contadorPedidos = 0;


    //Constructor

    public Client(String nombre, String apellidos, String direccion, String localidad, String provincia,
                  String telefono, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.email = email;
        this.contrasenia = contrasenia;
        //TODO ¿cada vez que se crea un cliente se aumenta en 1 el pedido? quizás haya que cambiarlo de lugar
        //TODO probablemente sea más eficiente crear objetos de productos en esta clase y comprobar nulls
        //contadorPedidos++;  TODO Esto es cierto que va en el metodo de crear pedido
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Order getP1() {
        return p1;
    }

    public void setP1(Order p1) {
        this.p1 = p1;
    }

    public Order getP2() {
        return p2;
    }

    public void setP2(Order p2) {
        this.p2 = p2;
    }

    public static int getOrderCount() {
        return contadorPedidos;
    }

    public static void setContadorPedidos(int contadorPedidos) {
        Client.contadorPedidos = contadorPedidos;
    }

    //Otros métodos
    //TODO meter validación de que sean dígitos
    public boolean validaTelefono(String phoneNumber) {
        return phoneNumber.length() == 9;
    }

    //TODO borrador, pensar qué más cosas meter o cómo modificarlo
    public boolean validaEmail(String email) {
        if (email.isEmpty()) return false;
        return !email.startsWith("@") && email.contains("@") && (email.endsWith(".com") || email.endsWith(".es"));
    }

    /*
    Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);*/

    //TODO
    public void makeOrder() {

    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + nombre + '\'' +
                ", surnames='" + apellidos + '\'' +
                ", address='" + direccion + '\'' +
                ", locality='" + localidad + '\'' +
                ", province='" + provincia + '\'' +
                ", phoneNumber='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", password='" + contrasenia + '\'' +
                ", orderCount=" + contadorPedidos +
                '}';
    }
}
