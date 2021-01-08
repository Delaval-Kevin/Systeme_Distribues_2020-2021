package hepl.sysdist.labo.checkout.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private double balance;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Paiement> paiements;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Client() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}
