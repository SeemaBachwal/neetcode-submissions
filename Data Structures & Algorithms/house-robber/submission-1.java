class Solution {

    public int rob(int[] nums) {

        if(nums.length == 1) return nums[0];

        int[] maxAmount = new int[nums.length];

        maxAmount[0] = nums[0];
        maxAmount[1] = Math.max(nums[0], nums[1]);

        for(int idx = 2; idx < nums.length; idx++){

            maxAmount[idx] = Math.max(maxAmount[idx-1], nums[idx] + maxAmount[idx-2]);
        }

        return maxAmount[nums.length-1];

    }

    
}
