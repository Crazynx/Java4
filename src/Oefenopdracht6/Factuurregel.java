package Oefenopdracht6;

public class Factuurregel {

    String factuurregel;

    public void setFactuurregel(int aantal, Product product) {
        factuurregel = aantal + " | " + product.getOmschrijving() +
                "\nPer stuk: €" + product.getPrijs() + " Excl. BTW (" + product.getBelasting() + ")" +
                "\nTotaal: €" + product.getPrijs() * aantal * (product.getBelasting()/100 + 1) +
                " Incl. BTW (" + product.getBelasting() + ")";
    }

    public String getFactuurregel() {
        return factuurregel;
    }
}
