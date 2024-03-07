import java.util.Scanner;

public class boj7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        int[] h = new int[n];
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((w[i] < w[j]) && (h[i] < h[j])) {
                    result[i]++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + 1 + " ");
        }
    }
}
