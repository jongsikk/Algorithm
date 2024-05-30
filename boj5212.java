import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj5212 {
    static String[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new String[r + 2][c + 2];
        String[][] result = new String[r + 2][c + 2];
        for (String[] i : map) {
            Arrays.fill(i, ".");
        }
        for (String[] i : result) {
            Arrays.fill(i, ".");
        }
        for (int i = 1; i <= r; i++) {
            String line = reader.readLine();
            for (int j = 1; j <= c; j++) {
                map[i][j] = line.charAt(j - 1) + "";
                result[i][j] = line.charAt(j - 1) + "";
            }
        }

        int minR = r + 1;
        int maxR = 0;
        int minC = c + 1;
        int maxC = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (map[i][j].equals("X")) {
                    if (check(i, j)) {
                        result[i][j] = ".";
                    }
                }
            }
        }
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <= c; j++) {
                if (result[i][j].equals("X")) {
                    minR = Math.min(i, minR);
                    maxR = Math.max(i, maxR);
                    minC = Math.min(j, minC);
                    maxC = Math.max(j, maxC);
                }
            }
        }
        for (int i = minR; i <= maxR; i++) {
            for (int j = minC; j <= maxC; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    static boolean check(int i, int j) {
        int count = 0;
        if (map[i - 1][j].equals(".")) {
            count++;
        }
        if (map[i + 1][j].equals(".")) {
            count++;
        }
        if (map[i][j - 1].equals(".")) {
            count++;
        }
        if (map[i][j + 1].equals(".")) {
            count++;
        }
        if (count == 4 || count == 3) {
            return true;
        }
        return false;
    }
}
