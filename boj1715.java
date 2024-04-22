import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> (i1 - i2));
        for (int i = 0; i < n; i++) {
            queue.add(Integer.parseInt(reader.readLine()));
        }
        int sum = 0;
        while (queue.size() != 1) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            sum = sum + n1 + n2;
            queue.add(n1 + n2);
        }
        System.out.println(sum);
    }
}
