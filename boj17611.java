import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj17611 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            points[i] = new Point(Integer.parseInt(st.nextToken()) + 500000, Integer.parseInt(st.nextToken()) + 500000);
        }
        int[] countX = new int[1000001];
        int[] countY = new int[1000001];
        int x = points[0].x;
        int y = points[0].y;
        for (int i = 1; i < n; i++) {
            if (x != points[i].x) {
                for (int j = Math.min(x, points[i].x); j < Math.max(x, points[i].x); j++) {
                    countX[j]++;
                }
                x = points[i].x;
            }
            if (y != points[i].y) {
                for (int j = Math.min(y, points[i].y); j < Math.max(y, points[i].y); j++) {
                    countY[j]++;
                }
                y = points[i].y;
            }
            if (i == n - 1) {
                for (int j = Math.min(x, points[0].x); j < Math.max(x, points[0].x); j++) {
                    countX[j]++;
                }
                for (int j = Math.min(y, points[0].y); j < Math.max(y, points[0].y); j++) {
                    countY[j]++;
                }
            }
        }
        System.out.println(Math.max(Arrays.stream(countX).max().getAsInt(), Arrays.stream(countY).max().getAsInt()));
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
