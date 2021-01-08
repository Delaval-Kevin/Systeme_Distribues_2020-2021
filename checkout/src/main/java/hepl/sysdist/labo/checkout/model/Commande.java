package hepl.sysdist.labo.checkout.model;

public class Commande
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int id;
    private int clientId;
    private float total;
    private boolean express;

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

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public boolean isExpress() {
        return express;
    }

    public void setExpress(boolean express) {
        this.express = express;
    }
}