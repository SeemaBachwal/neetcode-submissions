class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty())
            return "";
        Map<Character, Integer> tCount = new HashMap<>();
        Map<Character, Integer> currWindow = new HashMap<>();

        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = tCount.size(), left = 0, resLen = Integer.MAX_VALUE;

        int[] res = new int[2]; // to maintain shortest substring indices

        for (int right = 0; right < s.length(); right++) {
            
            char rightChar = s.charAt(right);

            currWindow.put(rightChar, currWindow.getOrDefault(rightChar, 0) + 1);

            if (tCount.containsKey(rightChar)
                && currWindow.get(rightChar).equals(tCount.get(rightChar))) {
                have++;
            }

            while (have == need) {
                if ((right - left + 1) < resLen) {
                    resLen = right - left + 1;

                    res[0] = left;
                    res[1] = right;
                }

                char leftChar = s.charAt(left);

                currWindow.put(leftChar, currWindow.get(leftChar) - 1);

                if (tCount.containsKey(leftChar)
                    && currWindow.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }

                left++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
