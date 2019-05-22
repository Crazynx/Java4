package Oefenopdracht4;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class View extends BorderPane {

    private Label label;

    protected View() {
        initScreen();
    }

    protected void setLabelText(String text) {
        label.setText(text);
    }

    private void initScreen() {
        label = new Label();
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(new Font(25));
        label.setText("Click on the button to generate a name");
        this.setCenter(label);
    }


}
