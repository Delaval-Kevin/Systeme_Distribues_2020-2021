package hepl.sysdist.labo.order.model;

import java.util.ArrayList;

public class Cart
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int clientId;
    private ArrayList<CartItem> cartItems;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Cart() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
