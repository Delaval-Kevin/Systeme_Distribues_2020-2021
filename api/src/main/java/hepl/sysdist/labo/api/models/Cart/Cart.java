package hepl.sysdist.labo.api.models.Cart;

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

    /********************************/
    /*           Methodes           */
    /********************************/
    public boolean isSufficient()
    {
        if(cartItems == null || cartItems.size() == 0)
            return false;

        for(CartItem item : cartItems)
        {
            if(!item.isSufficient())
                return false;
        }
        return true;
    }
}
