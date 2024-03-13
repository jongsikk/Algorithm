import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        System.out.println(n % 2 == 0 ? "CY" : "SK");
    }
}
