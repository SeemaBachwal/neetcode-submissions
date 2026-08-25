class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            switch (str) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;

                case "-":
                    int minus = stack.pop();
                    stack.push(stack.pop() - minus);
                    break;

                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;

                case "/":
                    int divisor = stack.pop();
                    stack.push(stack.pop() / divisor);
                    break;

                default:
                    stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();
    }
}
