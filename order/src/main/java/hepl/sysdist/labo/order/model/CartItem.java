package hepl.sysdist.labo.order.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CartItem
{
    /********************************/
    /*           Variables          */
    /********************************/
    @JsonProperty("itemId")
    private int idArticle;
    private int quantity;
    private String category;
    private float price;
    private float finalPrice;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CartItem() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public int getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(int idArticle) {
        this.idArticle = idArticle;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
