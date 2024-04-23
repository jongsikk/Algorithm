import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class boj1339 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] strings = new String[n];
        int[] array = new int[100];
        for (int i = 0; i < n; i++) {
            strings[i] = reader.readLine();
        }
        Arrays.sort(strings, (s1, s2) -> (s2.length() - s1.length()));
        for (String s : strings) {
            int index = s.length() - 1;
            for (int j = 0; j < s.length(); j++) {
                int c = s.charAt(j);
                array[c] += Math.pow(10, index);
                index--;
            }
        }
        Integer[] arr_integer = Arrays.stream(array).boxed().toArray(Integer[]::new);
        Arrays.sort(arr_integer, Collections.reverseOrder());

        int value = 9;
        int sum = 0;
        for (int i = 0; i <= 26; i++) {
            sum += value-- * arr_integer[i];
        }
        System.out.println(sum);
    }
}
