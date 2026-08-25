class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }

            else {
                if (stack.isEmpty()) {
                    return false;
                }

                char topValue = stack.pop();

                if (topValue != '(' && c == ')' || topValue != '[' && c == ']'
                    || topValue != '{' && c == '}') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
