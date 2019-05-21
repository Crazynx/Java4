package Oefenopdracht4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void addPropertyChangeListener() {

    }

    @Test
    void removePropertyChangeListener() {
    }

    @Test
    void generateRandName() {

        Model model = new Model();
        model.generateRandName();

        assertTrue(model.getName().equals("Leopold") || model.getName().equals("Malachi")
            || model.getName().equals("Maximus") || model.getName().equals("Napoleon")
            || model.getName().equals("Nathaniel"));

    }

    @Test
    void getName() {
    }
}