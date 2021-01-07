package hepl.sysdist.labo.stock.model;

public class StockResult {

    private Item item;
    private boolean sufficient;

    public StockResult() {
    }

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
