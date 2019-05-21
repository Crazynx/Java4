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
        generatedName = names[(int) (Math.random() * (4-0))];
        System.out.println(generatedName);
        this.pcs.firePropertyChange("name", prevGeneratedName, generatedName);
    }

}
