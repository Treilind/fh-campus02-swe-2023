package at.campus02.swe;

public interface Calculator {

    enum Operation {
        add, sub, mul, div, mod, sin, cos, skalar
    };

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    public int calculateSkalar ();

    void clear();
}