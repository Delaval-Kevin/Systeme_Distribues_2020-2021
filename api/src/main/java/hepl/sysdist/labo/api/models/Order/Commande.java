package hepl.sysdist.labo.api.models.Order;

import java.util.List;

public class Commande
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int id;
    private int clientId;
    private OrderStatus status;
    private float total;
    private boolean express;

    private List<OrderItem> items;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Commande() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }
}
