class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int a = nums[0];
        int b = Math.max(nums[0], nums[1]);

        for (int idx = 2; idx < nums.length; idx++) {
            int sum = Math.max(b, nums[idx] + a);
            a = b;
            b = sum;
        }

        return b;
    }
}
