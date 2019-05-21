package Oefenopdracht4;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {

    private String generatedName;
    private String[] names;
    private PropertyChangeSupport pcs;

    protected Model() {
        pcs = new PropertyChangeSupport(this);
        generatedName = "";
        names = new String[]{"Leopold", "Malachi", "Maximus", "Napoleon", "Nathaniel"};
    }

    protected void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    protected void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

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

}
