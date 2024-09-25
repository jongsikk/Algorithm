import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Time[] times = new Time[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        Arrays.sort(times, (t1, t2) -> {
            return t1.end - t2.end;
        });
        int end = 0;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (end < times[i].start) {
                answer++;
                end = times[i].end;
            }
        }
        System.out.println(answer);
    }

    static class Time {
        int start;
        int end;

        Time(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}