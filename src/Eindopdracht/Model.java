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
            double oldValue = firstNumber;
            if (addSeparator) { // if setSeperator has been called
                firstNumber = Double.parseDouble((int)firstNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) { // if firstNumber contains a '.'
                firstNumber = Double.parseDouble(firstNumber + "" + number);
            } else { // if firstNumber doesn't contain a '.'
                firstNumber = Double.parseDouble((int)firstNumber + "" + number);
            }
            this.propertyChangeSupport.firePropertyChange("number", oldValue, firstNumber);
        } else { // second number
            double oldValue = secondNumber;
            if (addSeparator) { // if setSeperator has been called
                secondNumber = Double.parseDouble((int)secondNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) { // if secondNumber contains a '.'
                secondNumber = Double.parseDouble(secondNumber + "" + number);
            } else { // if secondNumber doesn't contain a '.'
                containsSeparator = false;
                secondNumber = Double.parseDouble((int)secondNumber + "" + number);
            }
            this.propertyChangeSupport.firePropertyChange("number", oldValue, secondNumber);
        }
    }

    public void setSeparator() { // set the decimal point, '.'
        containsSeparator = true;
        addSeparator = true;
    }

    public void setOperator(char operator) { // set operator and adjust variables
        char oldValue = this.operator;
        this.operator = operator;
        this.propertyChangeSupport.firePropertyChange("operator",
                String.valueOf(oldValue), String.valueOf(this.operator));
        operatorIsSelected = true;
        containsSeparator = false;
        addSeparator = false;
    }

    public void setAnswer() { // calculate answer and reset variables to default value
        calculate(firstNumber, secondNumber, operator);
        firstNumber = 0;
        secondNumber = 0;
        operatorIsSelected = false;
        containsSeparator = false;
        addSeparator = false;
    }

    public void calculate(double first, double second, char operator) { // calculate answer and set new change
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
