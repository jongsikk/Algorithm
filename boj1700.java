import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        List<Integer> multitab = new ArrayList();
        int[] input = new int[k];
        for (int i = 0; i < k; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 0; i < k; i++) {
            if (multitab.contains(input[i])) {
                continue;
            } else if (multitab.size() < n) {
                multitab.add(input[i]);
            } else {
                int max = 0;
                int index = 0;
                for (int j = 0; j < multitab.size(); j++) {
                    int count = 0;
                    for (int l = i + 1; l < k; l++) {
                        if (multitab.get(j) != input[l]) {
                            count++;
                        } else {
                            break;
                        }
                    }
                    if (max < count) {
                        index = j;
                        max = count;
                    }
                }
                multitab.remove(index);
                multitab.add(input[i]);
                answer++;
            }
        }
        System.out.println(answer);
    }
}
