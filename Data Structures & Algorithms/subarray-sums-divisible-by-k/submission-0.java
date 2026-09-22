class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int countSubArrays = 0, sum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num : nums) {
            sum += num;

            int rem = sum % k;

            if (rem < 0) {
                rem += k;
            }

            countSubArrays += map.getOrDefault(rem, 0);

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return countSubArrays;
    }
}