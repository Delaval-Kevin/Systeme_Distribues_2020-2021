package hepl.sysdist.labo.cart.model;

import java.util.ArrayList;

public class Cart
{
    /********************************/
    /*           Variables          */
    /********************************/
    private ArrayList<CartItem> cartItems;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Cart() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
