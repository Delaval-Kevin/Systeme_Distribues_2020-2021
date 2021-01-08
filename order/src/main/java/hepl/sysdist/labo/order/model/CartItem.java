package hepl.sysdist.labo.order.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CartItem {

    private int idArticle;
    private int quantity;
    private TypeTVA typeTVA;
    private float finalPrice;


    public CartItem() { }

    public TypeTVA getTypeTVA() {
        return typeTVA;
    }

    public void setTypeTVA(TypeTVA typeTVA) {
        this.typeTVA = typeTVA;
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
}
