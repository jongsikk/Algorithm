import java.util.*;

class programmers단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);

        for (int i = 0; i < routes.length; i++) {
            if (routes[i][0] > max) {
                max = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
