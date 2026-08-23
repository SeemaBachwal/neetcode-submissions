class Solution {
    List<List<Integer>> combos = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        helper(0, candidates, new ArrayList<Integer>(), target);

        return combos;
    }

    public void helper(int start, int[] nums, List<Integer> initialCombos, int target) {
        // base condition
        if (target == 0) {
            combos.add(new ArrayList<>(initialCombos));
        }

        for (int i = start ; i < nums.length;) {
            initialCombos.add(nums[i]);

            if (target - nums[i] >= 0) {
                helper(i + 1, nums, initialCombos, target - nums[i]);
            }

            initialCombos.remove(initialCombos.size() - 1);
            i++;
            while(i < nums.length && nums[i-1] == nums[i]){
                i++;
            }
            
        }
    }
}
