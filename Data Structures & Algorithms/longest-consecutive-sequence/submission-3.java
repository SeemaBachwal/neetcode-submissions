class Solution {
    public int longestConsecutive(int[] nums) {
        int maxLen = 0;

        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int element : numSet) {
            if (!numSet.contains(element - 1)) {
                int seqCount = 1;

                while (numSet.contains(element + seqCount)) {
                    seqCount++;
                }
                maxLen = Math.max(maxLen, seqCount);
            }
        }

        return maxLen;
    }
}
