class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        char ch[] = s.toCharArray();

        int left = 0, maxLen = 0;

        for (int right = 0; right < ch.length; right++) {
            while (set.contains(ch[right])) {
                set.remove(ch[left]);
                left++;
            }

            set.add(ch[right]);

            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}
