class MinStack {
    Stack<Integer> data;
    Stack<Integer> minStack;

    int minVal = Integer.MAX_VALUE;

    public MinStack() {
        data = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int val) {
        if (minStack.isEmpty()) {
            minVal = Integer.MAX_VALUE;
        }

        if (val <= minVal) {
            minVal = val;
        }
        minStack.push(minVal);
        data.push(val);
    }

    public void pop() {
        data.pop();
        minStack.pop();
        if (!minStack.isEmpty()) {
            minVal = minStack.peek();
        }
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
