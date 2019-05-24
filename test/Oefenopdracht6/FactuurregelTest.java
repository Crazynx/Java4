package Oefenopdracht6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactuurregelTest {

    @Test
    void setFactuurregel() {
        // Setup
        Factuurregel factuurregel = new Factuurregel();
        Product product = new Product();
        product.setPrijs(10);
        product.setOmschrijving("houten hamer");
        // Kijk of er in ieder geval iets is veranderd, de regel mag niet leeg zijn
        assertNotEquals("", factuurregel.getFactuurregel());
    }

    @Test
    void getFactuurregel() {
        Factuurregel factuurregel = new Factuurregel();
        Product product = new Product();

        product.setPrijs(10.00);
        product.setBelasting(21.0);
        product.setOmschrijving("houten hamer");

        factuurregel.setFactuurregel(2, product);

        String verwachteUitkomst = 2 + " | " + "houten hamer" +
                "\nPer stuk: €" + 10.00 + " Excl. BTW (" + 21.0 + ")" +
                "\nTotaal: €" + 24.20 + " Incl. BTW (" + 21.0 + ")";
        assertEquals(verwachteUitkomst, factuurregel.getFactuurregel());
    }

}