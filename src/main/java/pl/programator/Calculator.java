package pl.programator;

public class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public double divide(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException();
        }
        return ((double) a) / ((double) b);
    }
}
