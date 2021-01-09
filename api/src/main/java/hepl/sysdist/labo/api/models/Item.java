//Auteur : HENDRICK Samuel                                                                                              
//Projet : stock                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.api.models;

public class Item {

    public Integer id;
    public String name;
    public int quantity;
    public float price;
    public String category;

    public Item(Integer id, String name, int quantity, float price, String category) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public Item() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String categroy) {
        this.category = categroy;
    }
}
