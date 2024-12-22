package models;

import java.time.LocalDate;

import models.Product;

public class Order {

    //Atributos
    private Product p1;
    private Product p2;
    private Product p3;
    private String code;
    private LocalDate dateOrder;
    private String comment;
    private String status;
    private int daysLate;
    //TODO Bajo revisión
    //un pepdido lo gestiona un trabajador y un pedido lo realiza un cliente cliente
    private Worker worker;
    private Client client;

    //Atributo Estático
    public static final int SHIPPING_DAYS = 5;

    //revisar los constructores
    //Constructor

    public Order(Product p1, Product p2, Product p3, String code, LocalDate dateOrder, String comment, String status, int daysLate, Worker worker, Client client) {
        this.p1 = null;
        this.p2 = null;
        this.p3 = null;
        this.code = code;
        this.dateOrder = LocalDate.now();
        this.comment = null;
        this.status = status;
        this.daysLate = 0;
        this.worker = worker;
        this.client = client;
    }

    //Constructor copia
    public Order(Product p1, Product p2, Product p3, Client client, String status, String code) {
        this.p1 = new Product(p1);
        this.p2 = new Product(p2);
        this.p3 = new Product(p3);
        this.client = client;
        this.status = status;
        this.code = code;
    }

    //Getters y Setters
    public Product getP1() {
        return p1;
    }

    public void setP1(Product p1) {
        this.p1 = p1;
    }

    public Product getP2() {
        return p2;
    }

    public void setP2(Product p2) {
        this.p2 = p2;
    }

    public Product getP3() {
        return p3;
    }

    public void setP3(Product p3) {
        this.p3 = p3;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(LocalDate dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    //Otros métodos

    public boolean isEmpty() {
        return p1 == null && p2 == null && p3 == null;
    }

    public boolean isFull() {
        return p1 != null && p2 != null && p3 != null;
    }

    /*TODO mirar cómo cambiar el retraso | si el pedido se retrasa como calculo la nueva fecha sin saber cuantos
       dias se retrasa ni la fecha de entrega estimada*/

    public LocalDate calculateDays() {
        return dateOrder.plusDays(SHIPPING_DAYS + daysLate);//(SHIPPING_DAYS + Atributo de días de retraso)
        // para calcular los días de retraso
    }


    public boolean fullProduct(){
        return (p1 != null && p2 != null && p3 != null );
    }

    public boolean emptyProduct(){
        return (p1 == null && p2 == null && p3 == null );
    }


    @Override

    public String toString() {
        return "Order{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", code='" + code + '\'' +
                ", dateOrder=" + dateOrder +
                ", comment='" + comment + '\'' +
                ", status='" + status + '\'' +
                ", worker=" + worker +
                ", client=" + client +
                '}';
    }
}
