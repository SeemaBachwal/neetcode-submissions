class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int result[] = new int[2];
        int n = grid.length;

        Set<Integer> set = new HashSet<>();

        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (set.contains(grid[j][k])) {
                    result[0] = grid[j][k];

                } else {
                    set.add(grid[j][k]);
                }
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (!set.contains(i)) {
                result[1] = i;
            }
        }

        return result;
    }
}