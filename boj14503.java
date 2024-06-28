import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503 {
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static int[] backX = { 1, 0, -1, 0 };
    static int[] backY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        st = new StringTokenizer(reader.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());
        if (dir == 1) {
            dir = 3;
        } else if (dir == 3) {
            dir = 1;
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        while (true) {
            if (map[startX][startY] == 0) {
                map[startX][startY] = -1;
                answer++;
            } else {
                boolean back = true;
                for (int i = 0; i < 4; i++) {
                    if (startX + dx[i] > 0 && startY + dy[i] > 0 && startX + dx[i] < n && startY + dy[i] < m
                            && map[startX + dx[i]][startY + dy[i]] == 0) {
                        back = false;
                        break;
                    }
                }
                if (back) {
                    if (startX + backX[dir] >= 0 && startY + backY[dir] >= 0 && startX + backX[dir] < n
                            && startY + backY[dir] < m) {
                        startX += backX[dir];
                        startY += backY[dir];
                        if (map[startX][startY] == 1) {
                            break;
                        }
                    }
                } else {
                    dir++;
                    if (dir == 4) {
                        dir = 0;
                    }
                    if (startX + dx[dir] > 0 && startY + dy[dir] > 0 && startX + dx[dir] < n && startY + dy[dir] < m
                            && map[startX + dx[dir]][startY + dy[dir]] == 0) {
                        startX += dx[dir];
                        startY += dy[dir];
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
