package hepl.sysdist.labo.api.models.Order;

public class OrderItem
{
    /********************************/
    /*           Variables          */
    /********************************/

    private int id;
    private int idArticle;
    private int quantity;
    private TypeTVA typeTVA;
    private float price;
    private String name = "article tmp";

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
