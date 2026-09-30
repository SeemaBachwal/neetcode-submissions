class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, new StringBuilder(), 0, 0);
        return res;
    }

    public void helper(int n, StringBuilder sb, int open, int close) {
        if (open == n && close == n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            helper(n, sb.append("("), open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            helper(n, sb.append(")"), open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
