import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj1038 {
    static List<Long> list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        list = new ArrayList<>();
        if (n <= 10) {
            System.out.println(n);
        } else if (n >= 1023) {
            System.out.println(-1);
        } else {
            for (int i = 0; i <= 9; i++) {
                dfs(i);
            }

            Collections.sort(list);
            System.out.println(list.get(n));
        }
    }

    static void dfs(long num) {
        list.add(num);

        long n1 = num % 10;
        for (long i = n1 - 1; i >= 0; i--) {
            dfs(num * 10 + i);
        }
    }
}