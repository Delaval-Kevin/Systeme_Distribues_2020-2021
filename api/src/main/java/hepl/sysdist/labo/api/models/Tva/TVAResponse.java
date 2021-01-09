package hepl.sysdist.labo.api.models.Tva;

public class TVAResponse
{
    /********************************/
    /*           Variables          */
    /********************************/
    private String name;
    private double tax;

    /********************************/
    /*         Constructeurs        */
    /********************************/
    public TVAResponse() { }

    public TVAResponse(String name, double tax)
    {
        this.tax = tax;
        this.name = name;
    }

    /********************************/
    /*       Getters & Setters      */
    /********************************/
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
