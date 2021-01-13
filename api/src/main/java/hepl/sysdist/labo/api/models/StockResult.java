package hepl.sysdist.labo.api.models;

public class StockResult
{
    /********************************/
    /*           Variables          */
    /********************************/
    private Item item;
    private boolean sufficient;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public StockResult() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSufficient() {
        return sufficient;
    }

    public void setSufficient(boolean sufficient) {
        this.sufficient = sufficient;
    }
}
