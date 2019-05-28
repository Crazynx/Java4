package Eindopdracht;

import javafx.scene.control.Button;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {

    private Calculator calculator;
    private PropertyChangeSupport propertyChangeSupport;
    private double firstNumber;
    private double secondNumber;
    private char operator;
    private boolean answerIsGiven;
    private boolean operatorIsSelected;
    private boolean addSeparator;
    private boolean containsSeparator;

    public Model() {
        calculator = new Calculator();
        propertyChangeSupport = new PropertyChangeSupport(this);
        operatorIsSelected = false;
        containsSeparator = false;
        answerIsGiven = false;
        addSeparator = false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void setNumber(int number) {
        if (!operatorIsSelected) { // first number
            if (addSeparator) { // if setSeperator has been called
                firstNumber = Double.parseDouble((int)firstNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) { // if firstNumber contains a '.'
                firstNumber = Double.parseDouble(firstNumber + "" + number);
            } else { // if firstNumber doesn't contain a '.'
                firstNumber = Double.parseDouble((int)firstNumber + "" + number);
            }
        } else { // second number
            if (addSeparator) { // if setSeperator has been called
                secondNumber = Double.parseDouble((int)secondNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) { // if secondNumber contains a '.'
                secondNumber = Double.parseDouble(secondNumber + "" + number);
            } else { // if secondNumber doesn't contain a '.'
                containsSeparator = false;
                secondNumber = Double.parseDouble((int)secondNumber + "" + number);
            }
        }
    }

    public void setSeparator() {
        addSeparator = true;
        containsSeparator = true;
    }

    public void setOperator(char operator) {
        operatorIsSelected = true;
        containsSeparator = false;
        addSeparator = false;
        this.operator = operator;
    }

    public void setAnswer() {
        operatorIsSelected = false;
        containsSeparator = false;
        addSeparator = false;
        calculate(firstNumber, secondNumber, operator);
    }

    public void calculate(double first, double second, char operator) {
        double oldValue = calculator.getAnswer();
        switch (operator) {
            case '-':
                calculator.subtract(first, second);
                break;

            case '+':
                calculator.add(first, second);
                break;

            case 'x':
                calculator.multiply(first, second);
                break;

            case '/':
                calculator.divide(first, second);
                break;
        }

        this.propertyChangeSupport.firePropertyChange("answer", oldValue, calculator.getAnswer());
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public char getOperator() {
        return operator;
    }

    public double getAnswer() {
        return calculator.getAnswer();
    }
}
