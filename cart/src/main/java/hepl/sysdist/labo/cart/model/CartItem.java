package hepl.sysdist.labo.cart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@JsonIgnoreProperties({"id", "clientId"})
public class CartItem
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int clientId;
    private int itemId;
    private int quantity;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CartItem() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int item_id) {
        this.itemId = item_id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int client_id) {
        this.clientId = client_id;
    }
}
