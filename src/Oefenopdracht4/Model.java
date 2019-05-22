package Oefenopdracht4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/*
 * Model
 * The model is responsible for the operations.
 */

public class Model {

    private String generatedName;
    private String[] names;
    private PropertyChangeSupport pcs;


    /*
     * The constructor is responsible for creating a new 'subscriber' notificator, it sets the default
     * value for a generated name, which is empty. It also initializes the array with names.
     */
    protected Model() {
        pcs = new PropertyChangeSupport(this);
        generatedName = "";
        names = new String[]{"Leopold", "Malachi", "Maximus", "Napoleon", "Nathaniel"};
    }

    /*
     * Method for adding a PropertyChangeListener. The controller uses this method to subscribe itself to the Model.
     */
    protected void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    /*
     * Method for removing a PropertyChangeListener. Using this method will remove the listener from the given object.
     */
    protected void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    /*
     * Method for generating a random name. A name can never be equal to the previous name, it also updates the
     * listeners.
     */
    protected void generateRandName() {
        String prevGeneratedName = generatedName;
        // loop that prevents picking the same name
        while (true) {
            generatedName = names[(int) (Math.random() * (4-0))];
            if (!generatedName.equals(prevGeneratedName)) {
                break;
            }
        }
        this.pcs.firePropertyChange("name", prevGeneratedName, generatedName);
    }

    /*
     * Method that retrieves the generated name.
     */
    protected String getName() {
        return generatedName;
    }

}
