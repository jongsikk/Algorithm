import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < 2 * n; i += 2) {
            sum += Integer.parseInt(st.nextToken());
        }

        System.out.println(Integer.toOctalString(sum));
    }
}