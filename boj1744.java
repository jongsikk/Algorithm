import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj1744 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> mQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(reader.readLine());
            if (a > 0) {
                pQueue.add(a);
            } else {
                mQueue.add(a);
            }
        }

        int sum = 0;
        while (!mQueue.isEmpty()) {
            if (mQueue.size() == 1) {
                sum += mQueue.poll();
            } else {
                int m = mQueue.poll();
                int k = mQueue.poll();
                if (m >= m * k) {
                    sum += m;
                    mQueue.add(k);
                } else {
                    sum += m * k;
                }
            }
        }
        while (!pQueue.isEmpty()) {
            if (pQueue.size() == 1) {
                sum += pQueue.poll();
            } else {
                int m = pQueue.poll();
                int k = pQueue.poll();
                if (m >= m * k) {
                    sum += m;
                    pQueue.add(k);
                } else {
                    sum += m * k;
                }
            }
        }
        System.out.println(sum);
    }
}
