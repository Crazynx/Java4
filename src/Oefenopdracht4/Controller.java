package Oefenopdracht4;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/*
 * Controller
 * The controller handles the user input.
 */
public class Controller extends BorderPane implements PropertyChangeListener {

    View view;
    Model model;
    Button button;

    /*
     * The constructor initializes properties when an instance of this class is created.
     * It creates a new view and model. It 'subscribes' itself to the model, which ensures the view
     * gets updated on a new change. It also places the view on the top-position from the borderpane. At last
     * it initializes the button.
     */
    protected Controller () {
        view = new View();
        model = new Model();
        model.addPropertyChangeListener(this);
        this.setTop(view);
        initButton();
    }

    /*
     * Creates a new button with the text 'Generate!', adds an action handler, in this case it triggers
     * a method responsible for generating a random name in the Model class. And finally, it puts the button
     * in the center of the borderpane.
     */
    private void initButton() {
        button = new Button("Generate!");
        button.setOnAction(event ->
            model.generateRandName()
        );
        this.setCenter(button);
    }

    /*
     * Gets activated when it notifies a change. If the change matches the name 'name', it sets the new
     * value to the view.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("name")) {
            view.setLabelText(evt.getNewValue().toString());
        }
    }
}
