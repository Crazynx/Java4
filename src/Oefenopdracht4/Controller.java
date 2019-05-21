package Oefenopdracht4;

import javafx.beans.property.Property;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller extends BorderPane implements PropertyChangeListener {

    View view;
    Model model;
    Button button;

    protected Controller () {
        view = new View();
        model = new Model();

        model.addPropertyChangeListener(this);
        this.setTop(view);
        initButtons();
    }

    private void initButtons() {
        button = new Button("Generate!");
        button.setOnAction(event ->
            model.generateRandName()
        );
        this.setCenter(button);
    }

//    protected Scene getView() {
//        return new Scene(view, 300, 300);
//    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("name")) {
            view.setLabelText(evt.getNewValue().toString());
        }
    }
}
