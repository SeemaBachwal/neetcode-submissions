class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0, curr = 0;

        int left = 0, right = heights.length - 1;

        while (left < right) {
            if (heights[left] <= heights[right]) {
                curr = (right - left) * heights[left];
                left++;

            } else {
                curr = (right - left) * heights[right];
                right--;
            }

            maxWater = Math.max(maxWater, curr);
        }

        return maxWater;
    }
}
