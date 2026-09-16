class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        // identify the row where target might exists
        int top = 0, bottom = rowNum - 1;

        while (top <= bottom) {
            int midRow = top + (bottom - top) / 2;

            if (target > matrix[midRow][colNum - 1]) {
                top = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                bottom = midRow - 1;
            } else {
                break;
            }
        }
        
        if (!(top <= bottom))
            return false;

        

        // use binary search on the targetRow
        int left = 0, right = colNum - 1;
        int targetRow = (top + bottom) / 2;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < matrix[targetRow][mid]) {
                right = mid - 1;
            } else if (target > matrix[targetRow][mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
