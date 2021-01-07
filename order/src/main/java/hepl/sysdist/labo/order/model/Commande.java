package hepl.sysdist.labo.order.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public int clientId;
    public OrderStatus status;
    public double total;

    @OneToMany(cascade = CascadeType.ALL)
    public List<OrderItem> items;

    public Commande() {
    }
}
