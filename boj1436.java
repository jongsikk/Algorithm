import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class boj1436 {
    public static void main(String[] args) throws IOException {
        int result = 666;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int count = 1;
        while (count != n) {
            result++;
            if (String.valueOf(result).contains("666")) {
                count++;
            }
        }
        System.out.println(result);
    }
}
