class Solution {
    private int ROWS, COLS;

    Set<String> pair = new HashSet<>();

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if (i == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(i)
            || pair.contains(r + "," + c)) {
            return false;
        }

        pair.add(r + "," + c);

        boolean ans = dfs(board, word, r + 1, c, i + 1) || dfs(board, word, r - 1, c, i + 1)
            || dfs(board, word, r, c + 1, i + 1) || dfs(board, word, r, c - 1, i + 1);

        pair.remove(r + "," + c);

        return ans;
    }
}
