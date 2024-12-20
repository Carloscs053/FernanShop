package models;

import java.time.LocalDate;
import java.util.Date;

public class Order {

    //Atributos
    private Product p1;
    private Product p2;
    private Product p3;
    private String code;
    private LocalDate dateOrder;
    private String comment;
    private String status;
    //TODO Bajo revisión
    private Worker w1;
    private Worker w2;
    private Worker w3;
    private Client c1;
    private Client c2;


    //Constructor
    public Order() {
        p1 = null;
        p2 = null;
        p3 = null;
        code = null;
        dateOrder = LocalDate.now();
        comment = null;
        status = null;
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

    public Worker getW1() {
        return w1;
    }

    public void setW1(Worker w1) {
        this.w1 = w1;
    }

    public Worker getW2() {
        return w2;
    }

    public void setW2(Worker w2) {
        this.w2 = w2;
    }

    public Worker getW3() {
        return w3;
    }

    public void setW3(Worker w3) {
        this.w3 = w3;
    }

    public Client getC1() {
        return c1;
    }

    public void setC1(Client c1) {
        this.c1 = c1;
    }

    public Client getC2() {
        return c2;
    }

    public void setC2(Client c2) {
        this.c2 = c2;
    }


    //Otros métodos

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
                ", w1=" + w1 +
                ", w2=" + w2 +
                ", w3=" + w3 +
                ", c1=" + c1 +
                ", c2=" + c2 +
                '}';
    }


    public boolean isEmpty() {
        return p1 == null && p2 == null && p3 == null;
    }

    public boolean isFull() {
        return p1 != null && p2 != null && p3 != null;
    }

    //TODO mirar cómo cambiar el retraso
    public LocalDate calculateDays() {
        LocalDate esteemedDays = dateOrder.plusDays(5);
        return esteemedDays;
    }


}
