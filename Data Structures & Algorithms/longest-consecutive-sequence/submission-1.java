class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxLen = 1, seqCount = 1;

        for (int right = 1; right < nums.length; right++) {

            int curr = nums[right];
            int prev = nums[right - 1];

            if (curr == prev){
                continue;
            }

            if (curr == prev + 1) {
                seqCount++;
            }
            else{
                seqCount = 1;
                maxLen = Math.max(maxLen, seqCount);
            }

            maxLen = Math.max(maxLen, seqCount);
            
        }

        return maxLen;
    }
}
