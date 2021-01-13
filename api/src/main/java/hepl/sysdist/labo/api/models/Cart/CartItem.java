package hepl.sysdist.labo.api.models.Cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



public class CartItem
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int itemId;
    private int quantity;
    private boolean sufficient;
    private String name;
    private float price;
    private String category;
    private float tva;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CartItem() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isSufficient() {
        return sufficient;
    }

    public void setSufficient(boolean sufficient) {
        this.sufficient = sufficient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getFinalPrice()
    {
        return price + (price * tva);
    }
}
