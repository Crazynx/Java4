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

        // Test if generated name is one of the following:
        model.generateRandName();
        assertTrue(model.getName().equals("Leopold") || model.getName().equals("Malachi")
                || model.getName().equals("Maximus") || model.getName().equals("Napoleon")
                || model.getName().equals("Nathaniel"));

        // Test if generated name isn't empty:
        model.generateRandName();
        assertNotEquals(model.getName(), "");

        // Test if generated name isn't equal to previous name:
        model.generateRandName();
        String previousName = model.getName();
        model.generateRandName();
        assertNotEquals(previousName, model.getName());
    }

    @Test
    void getName() {
    }
}