import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1713 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Point> list = new ArrayList<>();
        int count = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Point[] points = new Point[101];
        for (int i = 0; i < count; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (points[num] == null) {
                points[num] = new Point(num, 0, 0, false);
            }
            if (points[num].post) {
                points[num].count++;
            } else {
                if (list.size() == n) {
                    list.sort((p1, p2) -> {
                        return p1.count == p2.count ? p1.time - p2.time : p1.count - p2.count;
                    });
                    list.get(0).post = false;
                    list.remove(0);
                }
                points[num].count = 1;
                points[num].time = i;
                points[num].post = true;
                list.add(points[num]);
            }
        }
        list.sort((p1, p2) -> {
            return p1.num - p2.num;
        });

        for (Point point : list) {
            System.out.print(point.num + " ");
        }
    }

    static class Point {
        int num;
        int time;
        int count;
        boolean post;

        Point(int num, int time, int count, boolean point) {
            this.num = num;
            this.time = time;
            this.count = count;
            this.post = post;
        }

    }
}
