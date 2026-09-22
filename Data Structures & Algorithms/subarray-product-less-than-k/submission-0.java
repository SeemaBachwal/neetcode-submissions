class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0)
            return 0;

        int curr = 1, left = 0, count = 0;

        for (int right = 0; right < nums.length; right++) {
            curr = curr * nums[right];

            while (curr >= k && left <= right) {
                curr = curr / nums[left++];
            }

            count += right - left + 1;
        }

        return count;
    }
}