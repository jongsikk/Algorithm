import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String line2 = line + line;
        int aCount = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a')
                aCount++;
        }
        int min = 0;
        for (int i = 0; i < aCount; i++) {
            if (line2.charAt(i) == 'b')
                min++;
        }
        int count = min;
        for (int i = aCount; i < line.length() + aCount; i++) {
            if (line2.charAt(i - aCount) == 'b')
                count--;
            if (line2.charAt(i) == 'b')
                count++;
            min = Math.min(count, min);
        }
        System.out.println(min);
    }
}
