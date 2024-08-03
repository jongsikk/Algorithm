import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj31403 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        String c = reader.readLine();

        System.out.println(Integer.parseInt(a) + Integer.parseInt(b) - Integer.parseInt(c));
        System.out.println(Integer.parseInt(a + b) - Integer.parseInt(c));
    }
}
