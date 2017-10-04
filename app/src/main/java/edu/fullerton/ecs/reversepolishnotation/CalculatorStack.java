package edu.fullerton.ecs.reversepolishnotation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

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

    public String[] getTopFour() {
        String[] list = new String[] {"0", "0", "0", "0"};
        Iterator<String> it = stack.descendingIterator();
        for(int i = 0; i < 4 && it.hasNext() ; i ++)
        {
            list[i] = it.next();
        }
        return list;
    }

    public void evaluateOperation(String op) {
        float val2 = Float.parseFloat(stack.pollLast());
        float val1 = Float.parseFloat(stack.pollLast());
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
        input(result);
    }
}
