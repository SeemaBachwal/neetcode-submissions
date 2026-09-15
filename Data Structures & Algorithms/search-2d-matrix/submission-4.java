class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int targetRow = 0;

        // identify the row where target might exists

        for (int row = 0; row < m; row++) {
            if (target >= matrix[row][0] && target <= matrix[row][n - 1]) {
                targetRow = row;
            }
        }

        // use binary search on the targetRow

        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (target < matrix[targetRow][mid]) {
                high = mid - 1;
            } else if (target > matrix[targetRow][mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
