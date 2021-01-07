package hepl.sysdist.labo.checkout.model;

import javax.persistence.*;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;


    public String name;
    public String address;
    public double balance;

    public Client() {
    }



}
