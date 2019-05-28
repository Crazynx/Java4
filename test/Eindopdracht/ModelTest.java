package Eindopdracht;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {


    Model model;
    View view;

    @BeforeEach
    void setup() {
        model = new Model();
    }

    @Test
    void setNumber() {
        // check first number
        model.setNumber(1);
        assertEquals(1.0, model.getFirstNumber());
        assertNotEquals(2, model.getFirstNumber());
        model.setSeparator();
        model.setNumber(1);
        assertEquals(1.1, model.getFirstNumber());
        assertNotEquals(11, model.getSecondNumber());
        // set operator to go to second number
        model.setOperator('-');
        // check second number
        model.setNumber(1);
        assertEquals(1.0, model.getSecondNumber());
        assertNotEquals(2, model.getSecondNumber());
        model.setSeparator();
        model.setNumber(1);
        assertEquals(1.1, model.getSecondNumber());
        assertNotEquals(11, model.getSecondNumber());
    }

    @Test
    void setSeparator() {
        model.setNumber(1);
        model.setSeparator();
        model.setNumber(1);
        // check if number contains separator (dot)
        assertTrue(String.valueOf(model.getFirstNumber()).indexOf('.') != -1);
    }

    @Test
    void setOperator() {
        model.setOperator('-');
        assertTrue(model.getOperator() == '-');
        model.setOperator('+');
        assertTrue(model.getOperator() == '+');
        model.setOperator('x');
        assertTrue(model.getOperator() == 'x');
        model.setOperator('/');
        assertTrue(model.getOperator() == '/');
    }
}