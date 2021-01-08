package hepl.sysdist.labo.checkout.model;


import javax.persistence.*;

@Entity
public class Paiement
{
    /********************************/
    /*           Variables          */
    /********************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idCommande;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public Paiement() { }

    public Paiement(int idCommande) {
        this.idCommande = idCommande;
    }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }
}
