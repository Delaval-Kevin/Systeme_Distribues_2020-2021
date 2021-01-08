package hepl.sysdist.labo.api.models.Cart;

import java.util.ArrayList;

public class Cart {

    private ArrayList<CartItem> cartItems;

    public Cart() {
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
