package edu.fullerton.ecs.reversepolishnotation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by justin on 10/1/17.
 */

public class CalculatorStack {
    private Deque<String> stack;

    public CalculatorStack() {
        stack = new ArrayDeque<String>();
    }

    public void input(float x) {
        stack.addLast(Float.toString(x));
    }

    public float evaluateOperation(String op) {
        float val1 = Float.parseFloat(stack.pollLast());
        float val2 = Float.parseFloat(stack.pollLast());
        float result = 0;
        switch (op) {
            case "+":
                result = val1 + val2;
            break;
            case "-":
                result = val1 - val2;
            break;
            case "*":
                result = val1 * val2;
            break;
            case "/":
                result = val1 / val2;
            break;
            default: break;
        }
        return result;
    }
}
