import java.util.*;

class Solution {
    static List<List<Integer>> nodes;
    static boolean[] visit;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        nodes = new ArrayList<>();
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1) {
                    nodes.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                dfs(i);
            }
        }

        return answer;
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i : nodes.get(start)) {
            if (!visit[i]) {
                dfs(i);
            }
        }
    }
}
