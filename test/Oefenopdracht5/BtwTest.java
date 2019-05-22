package Oefenopdracht5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BtwTest {

    @Test
    void getPrijsInclusiefBtw() {
        Btw btw = new Btw();
        // Test with 21% tax
        btw.setBtw(21);
        btw.setPrijs(0.99);
        assertEquals("1,20", btw.getPrijsInclusiefBtw());

        // Test with 9% tax
        btw.setBtw(9);
        btw.setPrijs(0.99);
        assertEquals("1,08", btw.getPrijsInclusiefBtw());
    }
}