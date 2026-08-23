class Solution {
    String[] letterDict = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> combos = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return combos;

        helper(0, digits, new StringBuilder());
        return combos;
    }

    public void helper(int index, String digits, StringBuilder sb) {
        if (index == digits.length()) {
            combos.add(sb.toString());
            return;
        }

        String letters = letterDict[digits.charAt(index) - '2'];

        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));

            helper(index + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
