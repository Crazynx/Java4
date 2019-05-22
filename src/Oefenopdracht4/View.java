package Oefenopdracht4;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/*
 * View
 * The view is responsible for the non-clickable items on the user interface.
 */
public class View extends BorderPane {

    private Label label;

    /*
     * The constructor is responsible for initializing the 'screen'. Which is just a Label.
     */
    protected View() {
        initScreen();
    }

    /*
     * Method for initializing the 'screen'. It created a new label, sets a font color and size. Also sets the
     * default text to the label and centers it on the borderpane.
     */
    private void initScreen() {
        label = new Label("Click on the button to generate a name");
        label.setTextFill(Color.web("#0076a3"));
        label.setFont(new Font(25));
//        label.setText("Click on the button to generate a name");
        this.setCenter(label);
    }

    /*
     * Method for setting text to label.
     */
    protected void setLabelText(String text) {
        label.setText(text);
    }

    /*
     * Method that retrieves current text on label.
     */
    protected String getLabelText() {
        return label.getText();
    }



}
