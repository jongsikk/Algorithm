import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        long sum = 1;
        for (int i = 1; i <= Integer.parseInt(input); i++) {
            sum *= i;
            sum %= 1000000007;
        }
        System.out.println(sum);
    }
}