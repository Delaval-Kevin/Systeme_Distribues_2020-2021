package hepl.sysdist.labo.tva.model;

public class TVAResponse {

    private String name;
    private double tax;

    public TVAResponse() {
    }

    public TVAResponse(String name, double tax) {
        this.tax = tax;
        this.name = name;
    }

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
