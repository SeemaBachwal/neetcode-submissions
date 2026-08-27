class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqArr = new int[26];

        int left = 0, maxFreq = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            freqArr[rightChar - 'A']++;

            maxFreq = Math.max(maxFreq, freqArr[rightChar - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, (right - left + 1));
        }

        return maxLen;
    }
}
