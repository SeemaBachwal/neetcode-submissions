class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] bucket = new List[nums.length + 1];

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Integer key : map.keySet()) {
            int freqValue = map.get(key);

            if (bucket[freqValue] == null) {
                bucket[freqValue] = new ArrayList<>();
            }

            bucket[freqValue].add(key);
        }

        int[] result = new int[k];
        int count = 0;

        for (int pos = bucket.length - 1; pos > 0 && count < k; pos--) {
            if (bucket[pos] != null) {
                for (Integer element : bucket[pos]) {
                    result[count++] = element;
                }
            }
        }

        return result;
    }
}
