package hepl.sysdist.labo.checkout.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CartItem
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int itemId;
    private int quantity;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CartItem() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
