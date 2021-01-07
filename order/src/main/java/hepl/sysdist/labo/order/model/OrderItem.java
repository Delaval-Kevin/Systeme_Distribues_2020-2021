package hepl.sysdist.labo.order.model;


import javax.persistence.*;


@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int idArticle;
    public int quantity;

    public OrderItem() {
    }
}
