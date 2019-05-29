package Eindopdracht;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Controller extends VBox implements PropertyChangeListener {

    private Model model;
    private View view;
    HBox firstRow;
    HBox secondRow;
    HBox thirdRow;
    HBox fourthRow;

    public Controller() {
        model = new Model();
        model.addPropertyChangeListener(this);
        view = new View();
        this.getChildren().add(view);
        initRows();
        initNumberButtons();
        initOtherButtons();
        initOperatorButtons();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
            view.setText(evt.getNewValue().toString());
    }

    private void initRows() { // create and add new rows to controller
        this.getChildren().add(firstRow = new HBox());
        this.getChildren().add(secondRow = new HBox());
        this.getChildren().add(thirdRow = new HBox());
        this.getChildren().add(fourthRow = new HBox());
    }

    private void initNumberButtons() {
        HBox[] rows = {firstRow, secondRow, thirdRow, fourthRow};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        int index = 0;
        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 3; y++) {
                if (index < 10) {
                    Button button = new Button(numbers[index]);
                    button.setPrefWidth(75);
                    button.setPrefHeight(75);
                    int finalIndex = index;
                    button.setOnAction(event ->
                            model.setNumber(Integer.parseInt(numbers[finalIndex]))
                    );
                    rows[x].getChildren().add(button);
                    index++;
                }
            }
        }
    }

    private void initOperatorButtons() {
        char[] operators = {'/', 'x', '-', '+'};
        HBox[] rows = {firstRow, secondRow, thirdRow, fourthRow};
        for (int x = 0; x < 4; x++) {
            Button button = new Button(String.valueOf(operators[x]));
            button.setPrefWidth(75);
            button.setPrefHeight(75);
            int finalX = x;
            button.setOnAction(event ->
                model.setOperator(operators[finalX])
            );
            rows[x].getChildren().add(button);
        }

    }

    private void initOtherButtons() {
        char[] others = {'.', '='};
        // '.' button
        Button button = new Button(String.valueOf(others[0]));
        button.setPrefWidth(75);
        button.setPrefHeight(75);
        button.setOnAction(event -> {
            model.setSeparator();
        });
        fourthRow.getChildren().add(button);

        // '=' button
        button = new Button(String.valueOf(others[1]));
        button.setPrefWidth(75);
        button.setPrefHeight(75);
        button.setOnAction(event -> {
            model.setAnswer();
        });
        fourthRow.getChildren().add(button);
    }
}
