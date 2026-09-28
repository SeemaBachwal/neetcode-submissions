class Solution {
    int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;

        int numberOfIslands = 0;

        int rows = grid.length, cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1') {
                    dfs(row, col, grid);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    public void dfs(int row, int col, char[][] grid) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length
            || grid[row][col] == '0')
            return;

        grid[row][col] = '0';

        for (int dir[] : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            dfs(newRow, newCol, grid);
        }
    }
}
