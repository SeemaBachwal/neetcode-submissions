class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int result[] = new int[2];
        int n = grid.length;
        int totalSum = 0, actualSum = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= n * n; i++) {
            totalSum += i;
            set.add(i);
        }

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (set.contains(grid[j][k])) {
                    actualSum += grid[j][k];
                    set.remove(grid[j][k]);

                } else {
                    result[0] = grid[j][k];
                }
            }
        }

        result[1] = totalSum - actualSum;

        return result;
    }
}