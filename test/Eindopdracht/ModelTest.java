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
        model.setNumber(1);
        model.setNumber(0);
        model.setSeparator();
        model.setNumber(5);
        model.setOperator('x');
        model.setNumber(1);
        model.setNumber(0);
        model.setNumber(0);
        model.setAnswer();
        System.out.println(model.getAnswer());
    }

    @Test
    void setSeparator() {
    }

    @Test
    void setOperator() {
    }
}