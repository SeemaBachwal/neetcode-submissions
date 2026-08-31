class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;

        int left = 0, right = heights.length - 1;

        while (left < right) {
            int width = right - left;
            int height = Math.min(heights[left], heights[right]);

            maxWater = Math.max(maxWater, width * height);

            if (heights[left] <= heights[right]) {
                left++;

            } else {
                right--;
            }
        }

        return maxWater;
    }
}
