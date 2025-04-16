public class leetcode1232 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            int dx = coordinates[1][0] - coordinates[0][0];
            int dy = coordinates[1][1] - coordinates[0][1];

            for (int i = 2; i < coordinates.length; i++) {
                int dxx = coordinates[i][0] - coordinates[0][0];
                int dyy = coordinates[i][1] - coordinates[0][1];
                if (dxx * dy != dyy * dx) {
                    return false;
                }
            }

            return true;
        }
    }
}
