package at.campus02.swe.logic;


import at.campus02.swe.Calculator;
import at.campus02.swe.CalculatorException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class CalculatorImpl implements Calculator {

    private Stack<Double> stack_ = new Stack<Double>();

    private Random random;

    public Store store;


    public CalculatorImpl(int seed) {
        this.random = new Random(seed);
        store = new Store();
    }

    public CalculatorImpl() {
        this.random = new Random();
        store = new Store();
    }

    @Override
    public double perform(Operation op) throws CalculatorException {

        if (op == Operation.skalar)
            return calculateSkalar();

        double b = pop();
        double a = pop();

        switch (op) {
            case add:
                return a + b;
            case sub:
                return a - b;
            case div:
                double c = a / b;
                if (Double.isInfinite(c))
                    throw new CalculatorException("Division by zero");
                return c;
            case mod:
                double d = a % b;
                if (b == 0)
                    throw new CalculatorException("Division by zero");
                return d;
            case mul:
                return a * b;
            case sin:
                return Math.sin(Math.toRadians(a));
            case cos:
                return Math.cos(Math.toRadians(a));
            case random:
                return returnRandom(a, b);

        }

        return 0;
    }

    @Override
    public double pop() throws CalculatorException {
        if (stack_.isEmpty())
            throw new CalculatorException();
        return stack_.pop();

    }

    @Override
    public void push(double v) {
        stack_.push(v);
    }

    @Override
    public void clear() {
        stack_.clear();
    }


    public int calculateSkalar() {
        int anzVektor = stack_.pop().intValue();
        int result = 0;
        ArrayList<Integer> vektor1 = new ArrayList<>();
        ArrayList<Integer> vektor2 = new ArrayList<>();

        for (int i = 0; i < anzVektor * 2; i++) {
            if (i < anzVektor) {
                vektor1.add(stack_.pop().intValue());
            } else {
                vektor2.add(stack_.pop().intValue());
            }
        }
        for (int i = 0; i < anzVektor; i++) {
            result += vektor1.get(i) * vektor2.get(i);
        }

        return result;

    }

    public double returnRandom(double a, double b) {
        int min;
        int max;
        // zwei Zahlen auf Stack pushen
        if (a < b) {
            min = (int) a;
            max = (int) b;
        } else if (a > b) {
            max = (int) a;
            min = (int) b;
        } else return (double) a;


        int randomNr = random.nextInt(min, max);
        return (double) randomNr;


        // eine Randomzahl zwischen den 2 Zahlen generieren lassen
    }

    public Store getStore() {
        return store;
    }
}


