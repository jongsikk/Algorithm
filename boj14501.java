import java.util.Scanner;

public class boj14501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        int[] total = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        for (int i = 1; i < n + 1; i++) {
            if (i + t[i] <= n + 1) {
                total[t[i] + i] = total[t[i] + i] > total[i] + p[i] ? total[t[i] + i] : total[i] + p[i];
            }
            total[i + 1] = total[i + 1] > total[i] ? total[i + 1] : total[i];
        }
        int result = -1;
        for (int i = 1; i < n + 2; i++) {
            result = total[i] > result ? total[i] : result;
        }
        System.out.println(result);
    }
}
