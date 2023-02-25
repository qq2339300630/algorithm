package cjj.algorithm.minstack155;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stack1 = new Stack<>();

    public MinStack() {

    }

    public void push(int val) {
        stack.push(val);
        if (stack1.isEmpty()) {
            stack1.push(val);
        } else {
            int min = stack1.peek();
            stack1.push(Math.min(min, val));
        }
    }

    public void pop() {
        stack1.pop();
        stack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return stack1.peek();
    }
}
