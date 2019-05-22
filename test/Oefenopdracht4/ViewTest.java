package Oefenopdracht4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {

    @Test
    void setLabelText() {
        // Prevent JavaFX not initialized error
        com.sun.javafx.application.PlatformImpl.startup(()->{});

        View view = new View();

        // Test if set text actually sets text:
        view.setLabelText("TesttEstteSttestT");
        assertEquals("TesttEstteSttestT", view.getLabelText());
    }
}