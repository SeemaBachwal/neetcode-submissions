class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2)
            return false;

        int charCount1[] = new int[26];
        int charCount2[] = new int[26];

        for (int i = 0; i < len1; i++) {
            charCount1[s1.charAt(i) - 'a']++;
            charCount2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(charCount1, charCount2))
            return true;

        for (int k = len1; k < len2; k++) {
            charCount2[s2.charAt(k) - 'a']++;
            charCount2[s2.charAt(k - len1) - 'a']--;

            if (Arrays.equals(charCount1, charCount2))
                return true;
        }

        return false;
    }
}
