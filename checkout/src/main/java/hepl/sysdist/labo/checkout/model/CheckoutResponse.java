package hepl.sysdist.labo.checkout.model;

import java.util.ArrayList;

public class CheckoutResponse
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int id;
    private Cart cart;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CheckoutResponse() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
