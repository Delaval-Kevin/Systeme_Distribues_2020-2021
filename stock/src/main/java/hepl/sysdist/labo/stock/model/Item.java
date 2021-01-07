//Auteur : HENDRICK Samuel                                                                                              
//Projet : stock                               
//Date de la création : 07/01/2021

package hepl.sysdist.labo.stock.model;

public class Item {

    public Integer id;
    public String name;
    public int quantity;
    public float price;
    public String categroy;

    public Item(Integer id, String name, int quantity, float price, String categroy) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.categroy = categroy;
    }
}
