package Eindopdracht;

public class Calculator {

    private double answer;

    public void add(double first, double second) {
        answer = first + second;
    }

    public void subtract(double first, double second) {
        answer = first + second;
    }

    public void multiply(double first, double second) {
        answer = first * second;
    }

    public void divide(double first, double second) {
        answer = first / second;
    }

    public double getAnswer() {
        previousAnswer = answer;
        return answer;
    }
}
