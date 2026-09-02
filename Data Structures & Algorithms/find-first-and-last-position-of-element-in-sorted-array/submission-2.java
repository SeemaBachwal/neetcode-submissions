class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx = findIndex(nums, target, true);
        int lastIdx = findIndex(nums, target, false);

        return new int[] {firstIdx, lastIdx};
    }

    public int findIndex(int[] nums, int target, boolean leftIdx) {
        int low = 0, high = nums.length - 1;

        int idx = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;

            } else if (target < nums[mid]) {
                high = mid - 1;
            }

            else {
                idx = mid;

                if (leftIdx) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return idx;
    }
}