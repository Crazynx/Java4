package Oefenopdracht4;

import javafx.geometry.Pos;
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
        System.out.println("called setLabelText");
        label.setText(text);
    }

    private void initScreen() {
        label = new Label();
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(new Font(25));
        label.setText("Click on the button to generate a name");

//        this.getChildren().add(label); // set label to borderpane
        this.setCenter(label);
    }


}
