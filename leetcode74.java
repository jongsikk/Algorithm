public class leetcode74 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rowStart = 0;
            int rowEnd = matrix.length - 1;
            int row = 0;
            while (rowStart <= rowEnd) {
                int mid = (rowStart + rowEnd) / 2;
                if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length - 1] >= target) {
                    row = mid;
                    break;
                } else if (matrix[mid][0] > target) {
                    rowEnd = mid - 1;
                } else {
                    rowStart = mid + 1;
                }
            }

            int start = 0;
            int end = matrix[row].length - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (matrix[row][mid] < target) {
                    start = mid + 1;
                } else if (matrix[row][mid] > target) {
                    end = mid - 1;
                } else {
                    return true;
                }
            }

            return false;

        }
    }
}
