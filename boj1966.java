import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj1966 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(reader.readLine());

        for (int i = 0; i < t; i++) {
            int count = 0;
            LinkedList<Doc> queue = new LinkedList<>();
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                int w = Integer.parseInt(st.nextToken());
                queue.add(new Doc(j, w));
            }
            while (!queue.isEmpty()) {
                Doc first = queue.poll();
                boolean max = true;
                for (int j = 0; j < queue.size(); j++) {
                    if (first.w < queue.get(j).w) {
                        queue.add(first);
                        for (int k = 0; k < j; k++) {
                            queue.add(queue.poll());
                        }
                        max = false;
                        break;
                    }
                }
                if (!max) {
                    continue;
                }
                count++;
                if (first.i == m) {
                    break;
                }
            }
            System.out.println(count);
        }
    }

    static class Doc {
        int i;
        int w;

        Doc(int i, int w) {
            this.i = i;
            this.w = w;
        }
    }
}
