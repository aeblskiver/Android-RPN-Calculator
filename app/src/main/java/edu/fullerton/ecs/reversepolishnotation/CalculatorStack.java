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
    public Deque<String> getStack() {
        return stack;
    }


    private Deque<String> stack;

    public CalculatorStack() {
        stack = new ArrayDeque<String>();
    }

    public void input(String num) {
        stack.addLast(num);
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
        float val2 = pop();
        float val1 = pop();
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
        input(Float.toString(result));
    }

    private float pop() {
        if (stack.isEmpty())
            return 0f;
        return Float.parseFloat(stack.pollLast());
    }
}
