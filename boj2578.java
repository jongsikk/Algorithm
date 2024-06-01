import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2578 {
    static List<int[]> bingo;
    static boolean[][] result;
    static int lineCount;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bingo = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            bingo.add(new int[2]);
        }
        result = new boolean[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken()) - 1;
                bingo.get(n)[0] = i;
                bingo.get(n)[1] = j;
            }
        }
        lineCount = 0;
        count = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                int n = Integer.parseInt(st.nextToken()) - 1;
                result[bingo.get(n)[0]][bingo.get(n)[1]] = true;
                count++;
                if (check() >= 3) {
                    break;
                }
            }
            if (check() >= 3) {
                break;
            }
        }
        System.out.println(count);
    }

    static int check() {
        lineCount = 0;
        if (result[0][0] && result[0][1] && result[0][2] && result[0][3] && result[0][4]) {
            lineCount++;
        }
        if (result[1][0] && result[1][1] && result[1][2] && result[1][3] && result[1][4]) {
            lineCount++;
        }
        if (result[2][0] && result[2][1] && result[2][2] && result[2][3] && result[2][4]) {
            lineCount++;
        }
        if (result[3][0] && result[3][1] && result[3][2] && result[3][3] && result[3][4]) {
            lineCount++;
        }
        if (result[4][0] && result[4][1] && result[4][2] && result[4][3] && result[4][4]) {
            lineCount++;
        }
        if (result[0][0] && result[1][0] && result[2][0] && result[3][0] && result[4][0]) {
            lineCount++;
        }
        if (result[0][1] && result[1][1] && result[2][1] && result[3][1] && result[4][1]) {
            lineCount++;
        }
        if (result[0][2] && result[1][2] && result[2][2] && result[3][2] && result[4][2]) {
            lineCount++;
        }
        if (result[0][3] && result[1][3] && result[2][3] && result[3][3] && result[4][3]) {
            lineCount++;
        }
        if (result[0][4] && result[1][4] && result[2][4] && result[3][4] && result[4][4]) {
            lineCount++;
        }
        if (result[0][0] && result[1][1] && result[2][2] && result[3][3] && result[4][4]) {
            lineCount++;
        }
        if (result[0][4] && result[1][3] && result[2][2] && result[3][1] && result[4][0]) {
            lineCount++;
        }
        return lineCount;
    }
}
