import java.util.Scanner;

public class programmers직사각형별찍기 {
    class Solution {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int i = 0; i < b; i++) {
                for (int j = 0; j < a; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }

            System.out.println(sb.toString());
        }
    }
}
