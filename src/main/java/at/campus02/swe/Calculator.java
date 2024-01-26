package at.campus02.swe;

import at.campus02.swe.logic.Store;

public interface Calculator {

    Store store = new Store();

    enum Operation {
        
      add, sub, mul, div, mod, sin, cos, random, skalar,

    };

    void push(double value);

    double pop() throws CalculatorException;

    double perform(Operation op) throws CalculatorException;

    public int calculateSkalar ();

    void clear();

    Store getStore();


}