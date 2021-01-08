package hepl.sysdist.labo.order.model;


import javax.persistence.*;


@Entity
public class OrderItem
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idArticle;
    private int quantity;
    private TypeTVA typeTVA;
    private float price;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public OrderItem() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public TypeTVA getTypeTVA() {
        return typeTVA;
    }

    public void setTypeTVA(TypeTVA typeTVA) {
        this.typeTVA = typeTVA;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
