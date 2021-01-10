package hepl.sysdist.labo.api.models.Checkout;

public class Paiement
{
    /********************************/
    /*           Variables          */
    /********************************/
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
