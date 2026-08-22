class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        // Detect cycle
        while (true) {
            slow = nums[slow]; // index
            fast = nums[nums[fast]]; // 2 step
            if (slow == fast)
                break;
        }

        // start of cycle
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
