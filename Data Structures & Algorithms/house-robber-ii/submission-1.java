class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];


        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int ans1 = helper(nums, 0, nums.length - 1);
        int ans2 = helper(nums, 1, nums.length);

        return Math.max(ans1, ans2);
        
    }

    public int helper(int[] nums, int start, int end){


        int a = nums[start];
        int b = Math.max(nums[start], nums[start+1]);

        for (int idx = start + 2; idx < end; idx++) {
            int sum = Math.max(b, nums[idx] + a);
            a = b;
            b = sum;
        }

        return b;
    }
}
