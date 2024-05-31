import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1244 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] switches = new int[n + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            switches[i] = Integer.parseInt(st.nextToken());
        }
        int s = Integer.parseInt(reader.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(reader.readLine());
            int g = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (g == 1) {
                for (int j = 1; j <= n; j++) {
                    if (j % num == 0) {
                        if (switches[j] == 1) {
                            switches[j] = 0;
                        } else {
                            switches[j] = 1;
                        }
                    }
                }
            } else {
                if (switches[num] == 1) {
                    switches[num] = 0;
                } else {
                    switches[num] = 1;
                }
                for (int j = 1; j <= n; j++) {
                    if ((num - (1 * j) > 0) && (num + (1 * j) <= n)) {
                        if (switches[(num - (1 * j))] == switches[(num + (1 * j))]) {
                            if (switches[num - (1 * j)] == 1) {
                                switches[num - (1 * j)] = 0;
                                switches[num + (1 * j)] = 0;
                            } else {
                                switches[num - (1 * j)] = 1;
                                switches[num + (1 * j)] = 1;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(switches[i] + " ");
            if (n > 20 && i % 20 == 0) {
                System.out.println();
            }
        }
    }
}
