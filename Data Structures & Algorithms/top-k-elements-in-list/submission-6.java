class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        System.out.println(map);

        for (int key : map.keySet()) {
            int val = map.get(key);

            minHeap.offer(new int[]{val, key});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];

        for(int i = 0; i < k ; i++){
            result[i] = minHeap.poll()[1];
        }

        return result;
    }
}
