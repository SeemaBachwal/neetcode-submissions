class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int start = 0, end = ch.length - 1;

        while (start < end) {
            
            while (start < end && !isAlphaNumber(ch[start])) {
                start++;
            }

            while (end > start && !isAlphaNumber(ch[end])) {
                end--;
            }

            if (Character.toLowerCase(ch[start]) != Character.toLowerCase(ch[end])) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public boolean isAlphaNumber(char c) {
        if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9') {
            return true;
        }

        return false;
    }
}
