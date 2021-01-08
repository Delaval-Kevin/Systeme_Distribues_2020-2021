package hepl.sysdist.labo.order.model;

import java.util.ArrayList;

public class OrderResponse
{
    /********************************/
    /*           Variables          */
    /********************************/
    private ArrayList<CartItem> cartItems;
    private boolean status;
    private int id;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public OrderResponse() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
