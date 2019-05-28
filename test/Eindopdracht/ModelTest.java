package Eindopdracht;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    Model model;

    @BeforeEach
    void setup() {
        model = new Model();
    }

    @Test
    void setNumber() {
        model.setNumber(1);
        model.setNumber(2);
        model.setSeparator();
        model.setNumber(3);
        model.setNumber(5);
        assertEquals(12.35, model.getFirstNumber());

    }

    @Test
    void setSeparator() {
    }

    @Test
    void setOperator() {
    }
}