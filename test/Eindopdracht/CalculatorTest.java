package Eindopdracht;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void add() { // test if add gets correct result and doesn't round the decimals
        calculator.add(1.1, 1.1);
        assertEquals(2.2, calculator.getAnswer());
        assertNotEquals(2, calculator.getAnswer());
    }

    @Test
    void subtract() { // test if subtract gets correct result and doesn't round the decimals
        calculator.subtract(10.1, 5);
        assertEquals(5.1, calculator.getAnswer());
        assertNotEquals(5, calculator.getAnswer());

    }

    @Test
    void multiply() { // test if multiply gets correct result and doesn't round the decimals
        calculator.multiply(10.1, 10.5);
        assertEquals(106.05, calculator.getAnswer());
        assertNotEquals(106.1, calculator.getAnswer());
    }

    @Test
    void divide() { // test if divide gets correct result and doesn't round the decimals
        calculator.divide(100.1, 50.05);
        assertEquals(2, calculator.getAnswer());
    }
}