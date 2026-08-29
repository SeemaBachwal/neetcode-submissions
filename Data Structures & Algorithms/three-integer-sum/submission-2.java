class Solution {
    List<List<Integer>> ansList = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                break; // all numbers are positive, no outcome

            if (i > 0 && nums[i] == nums[i - 1])
                continue; // skip duplicates

            int left = i + 1, right = nums.length - 1;

            while (left < right) {
                int val2 = nums[left];
                int val3 = nums[right];

                int sum = nums[i] + val2 + val3;

                if (sum == 0) {
                    ansList.add(Arrays.asList(nums[i], val2, val3));
                    left++;
                    right--;

                    // to skip any further duplicates
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }

                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }

        return ansList;
    }
}
