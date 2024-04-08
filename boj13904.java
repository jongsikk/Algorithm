import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj13904 {
    static int n;
    static Assignment[] assignments;
    static PriorityQueue<Integer> days;
    static int result;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        days = new PriorityQueue<>(Collections.reverseOrder());
        n = Integer.parseInt(reader.readLine());
        assignments = new Assignment[n];
        result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            assignments[i] = new Assignment(day, score);
            days.add(day);
        }
        boolean[] end = new boolean[assignments.length];
        int day = days.poll();

        while (day > 0) {
            int max = 0;
            int maxIndex = 0;
            for (int i = 0; i < n; i++) {
                if (day <= assignments[i].day && !end[i]) {
                    if (assignments[i].score > max) {
                        max = assignments[i].score;
                        maxIndex = i;
                    }
                }
            }
            if (max != 0) {
                result += max;
                end[maxIndex] = true;
            }
            day--;
        }
        System.out.println(result);
    }

    static class Assignment {
        int day;
        int score;

        Assignment(int day, int score) {
            this.day = day;
            this.score = score;
        }
    }
}
