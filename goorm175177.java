import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] coins = new int[] { 40, 20, 10, 5, 1 };
        for (int i = 0; i < coins.length; i++) {
            if (n / coins[i] != 0) {
                answer += n / coins[i];
                n %= coins[i];
            }
        }
        System.out.println(answer);
    }
}