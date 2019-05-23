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
        assertNotEquals("", product.getFactuurregel);
    }

    @Test
    void getFactuurregel() {
        Factuurregel factuurregel = new Factuurregel();
        Product product = new Product();

        product.setPrijs(10.00);
        product.setOmschrijving("houten hamer");

        factuurregel.setFactuurregel(2, product);

        String verwachteOutput = "2 | houten hamer | Prijs: €10.00 excl. BTW";
        assertEquals(verwachteOutput, factuurregel.getFactuurregel);
    }

}