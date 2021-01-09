package hepl.sysdist.labo.order.model;

import java.util.ArrayList;

public class OrderResponse
{
    /********************************/
    /*           Variables          */
    /********************************/
    private ArrayList<Commande> commandes;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public OrderResponse() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public ArrayList<Commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<Commande> commandes) {
        this.commandes = commandes;
    }
}
