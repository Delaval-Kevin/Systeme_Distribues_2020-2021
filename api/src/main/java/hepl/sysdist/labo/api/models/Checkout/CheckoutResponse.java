package hepl.sysdist.labo.api.models.Checkout;

public class CheckoutResponse
{
    /********************************/
    /*           Variables          */
    /********************************/
    private Client client;
    private float totalCheckout;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public CheckoutResponse() { }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public float getTotalCheckout() {
        return totalCheckout;
    }

    public void setTotalCheckout(float totalCheckout) {
        this.totalCheckout = totalCheckout;
    }
}
