import java.util.Scanner;

public class boj1018 {

    private static boolean[][] array;
    private static int min = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        array = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                array[i][j] = line.charAt(j) == 'W' ? true : false;
            }
        }
        for (int i = 0; i < n - 7; i++) {
            for (int j = 0; j < m - 7; j++) {
                chess(i, j);
            }
        }

        System.out.println(min);
    }

    private static void chess(int n, int m) {
        int count = 0;
        boolean first = array[n][m];

        for (int i = n; i < n + 8; i++) {
            for (int j = m; j < m + 8; j++) {
                if (array[i][j] != first) {
                    count++;
                }
                first = !first;
            }
            first = !first;
        }
        count = count > 64 - count ? 64 - count : count;
        min = min > count ? count : min;
    }
}