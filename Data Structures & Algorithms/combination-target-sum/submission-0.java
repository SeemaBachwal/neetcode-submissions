class Solution {
    List<List<Integer>> combos = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(0, nums, new ArrayList<Integer>(), target);

        return combos;
    }

    public void helper(int start, int[] nums, List<Integer> initialCombos, int target) {
        // base condition
        if (target == 0) {
            combos.add(new ArrayList<>(initialCombos));
        }

        if (target < 0)
            return;

        for (int i = start; i < nums.length; i++) {
            initialCombos.add(nums[i]);

            if (target - nums[i] >= 0) {
                helper(i, nums, initialCombos, target - nums[i]);
            }

            initialCombos.remove(initialCombos.size() - 1);
        }
    }
}
