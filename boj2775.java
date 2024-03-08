import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class boj2775 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] list = new int[15][15];
        for (int i = 0; i < 15; i++) {
            list[0][i] = i;
        }
        for (int i = 1; i < 15; i++) {
            for (int j = 1; j < 15; j++) {
                list[i][j] = list[i][j - 1] + list[i - 1][j];
            }
        }

        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int k = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(list[k][n]);
        }
    }

}
