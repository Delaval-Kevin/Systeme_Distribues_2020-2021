package hepl.sysdist.labo.checkout.model;


import javax.persistence.*;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @OneToOne
    public Client client;

    public Paiement() {
    }

}
