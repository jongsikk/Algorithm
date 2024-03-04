public class boj4673 {
    public static void main(String[] args) {
        boolean[] result = new boolean[10000];
        int sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum = d(i);
            if (sum <= 10000)
                result[sum - 1] = true;
        }
        for (int i = 0; i < 10000; i++) {
            if (!result[i])
                System.out.println(i + 1);
        }
    }

    private static int d(int n) {
        int sum = n;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
