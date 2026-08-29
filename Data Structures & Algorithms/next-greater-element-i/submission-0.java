class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int result[] = new int[len1];
        Arrays.fill(result, -1);

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len1; i++) {
            map.putIfAbsent(nums1[i], i);
        }

        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                int topElement = stack.pop();
                int index = (int) map.get(topElement);
                result[index] = nums2[i];
            }

            if (map.containsKey(nums2[i]))
                stack.push(nums2[i]);
        }

        return result;
    }
}