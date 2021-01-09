//Auteur : HENDRICK Samuel                                                                                              
//Projet : stock                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.stock.model;

public class Item
{
    /********************************/
    /*           Variables          */
    /********************************/
    private Integer id;
    private String name;
    private int quantity;
    private float price;
    private String category;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Item() { }

    public Item(Integer id, String name, int quantity, float price, String category)
    {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
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
