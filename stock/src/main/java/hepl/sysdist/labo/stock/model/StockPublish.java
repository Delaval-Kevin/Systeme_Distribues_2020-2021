package hepl.sysdist.labo.stock.model;

/* Classe de message de la demande du stock */

public class StockPublish
{
    /********************************/
    /*           Variables          */
    /********************************/
    private int idArticle;
    private int quantity;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public StockPublish(){ }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
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
}
