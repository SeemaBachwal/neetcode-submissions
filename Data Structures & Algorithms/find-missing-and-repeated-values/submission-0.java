class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int result[] = new int[2];
        int n = grid.length;
        boolean freq[] = new boolean[(n * n) + 1];

        freq[0] = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (freq[grid[i][j]]) {
                    result[0] = grid[i][j];

                } else {
                    freq[grid[i][j]] = true;
                }
            }
        }

        for (int j = 0; j < freq.length; j++) {
            if (!freq[j]) {
                result[1] = j;
            }
        }

        return result;
    }
}