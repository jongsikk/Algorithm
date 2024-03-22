public class programmers정수삼각형 {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] result = new int[triangle.length][triangle.length];

        result[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    result[i][j] = result[i - 1][j] + triangle[i][j];
                } else {
                    result[i][j] = Math.max(result[i - 1][j - 1] + triangle[i][j], result[i - 1][j] + triangle[i][j]);
                }
                answer = Math.max(result[i][j], answer);
            }
        }
        return answer;
    }
}
