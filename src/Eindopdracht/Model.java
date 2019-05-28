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
        answerIsGiven = false;
        operatorIsSelected = false;
        addSeparator = false;
        containsSeparator = false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void setNumber(int number) {
        if (!operatorIsSelected) {
            if (addSeparator) {
                containsSeparator = true;
                firstNumber = Double.parseDouble((int)firstNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) {
                firstNumber = Double.parseDouble(firstNumber + "" + number);
            } else {
                firstNumber = Double.parseDouble((int)firstNumber + "" + number);
            }
        } else {
            if (addSeparator) {
                secondNumber = Double.parseDouble((int)firstNumber + "." + number);
                addSeparator = false;
            } else if (containsSeparator) {
                firstNumber = Double.parseDouble(firstNumber + "" + number);
            } else {
                containsSeparator = false;
                secondNumber = Double.parseDouble((int)firstNumber + "" + number);
            }
        }
    }

    public void setSeparator() {
        addSeparator = true;
    }

    public void setOperator(char operator) {
        operatorIsSelected = true;
        this.operator = operator;
    }

    public void setAnswer() {
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


}
