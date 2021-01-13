//Auteur : HENDRICK Samuel                                                                                              
//Projet : api                               
//Date de la création : 08/01/2021

package hepl.sysdist.labo.api.models.Cart;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CartAddRequest
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int id;
    private int quantity;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CartAddRequest(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartAddRequest() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("itemId")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
