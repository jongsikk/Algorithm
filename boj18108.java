import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj18108 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(reader.readLine());
        System.out.println(y - 543);
    }
}
