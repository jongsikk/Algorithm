import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj11721 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = reader.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (i % 10 == 0 && i > 0) {
                writer.write("\n");
            }
            writer.write(s.charAt(i) + "");
        }
        writer.flush();
        writer.close();
    }
}
