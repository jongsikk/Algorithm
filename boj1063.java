import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1063 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        String king = st.nextToken();
        int[] k = { (king.charAt(0) - 64), king.charAt(1) - 48 };
        String stone = st.nextToken();
        int[] s = { (stone.charAt(0) - 64), stone.charAt(1) - 48 };

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            switch (reader.readLine()) {
                case "T":
                    if (k[1] < 8) {
                        if ((k[1] + 1 == s[1]) && (k[0] == s[0])) {
                            if (s[1] < 8) {
                                k[1] += 1;
                                s[1] += 1;
                            }
                        } else {
                            k[1] += 1;
                        }
                    }
                    break;
                case "B":
                    if (k[1] > 1) {
                        if ((k[1] - 1 == s[1]) && (k[0] == s[0])) {
                            if (s[1] > 1) {
                                k[1] -= 1;
                                s[1] -= 1;
                            }
                        } else {
                            k[1] -= 1;
                        }
                    }
                    break;
                case "L":
                    if (k[0] > 1) {
                        if ((k[0] - 1 == s[0]) && (k[1] == s[1])) {
                            if (s[0] > 1) {
                                k[0] -= 1;
                                s[0] -= 1;
                            }
                        } else {
                            k[0] -= 1;
                        }
                    }
                    break;
                case "R":
                    if (k[0] < 8) {
                        if ((k[0] + 1 == s[0]) && (k[1] == s[1])) {
                            if (s[0] < 8) {
                                k[0] += 1;
                                s[0] += 1;
                            }
                        } else {
                            k[0] += 1;
                        }
                    }
                    break;
                case "RT":
                    if (k[0] < 8 && k[1] < 8) {
                        if ((k[0] + 1 == s[0]) && (k[1] + 1 == s[1])) {
                            if (s[0] < 8 && s[1] < 8) {
                                k[0] += 1;
                                k[1] += 1;
                                s[0] += 1;
                                s[1] += 1;
                            }
                        } else {
                            k[0] += 1;
                            k[1] += 1;
                        }
                    }
                    break;
                case "RB":
                    if (k[0] < 8 && k[1] > 1) {
                        if ((k[0] + 1 == s[0]) && (k[1] - 1 == s[1])) {
                            if (s[0] < 8 && s[1] > 1) {
                                k[0] += 1;
                                k[1] -= 1;
                                s[0] += 1;
                                s[1] -= 1;
                            }
                        } else {
                            k[0] += 1;
                            k[1] -= 1;
                        }
                    }
                    break;
                case "LT":
                    if (k[0] > 1 && k[1] < 8) {
                        if ((k[0] - 1 == s[0]) && (k[1] + 1 == s[1])) {
                            if (s[0] > 1 && s[1] < 8) {
                                k[0] -= 1;
                                k[1] += 1;
                                s[0] -= 1;
                                s[1] += 1;
                            }
                        } else {
                            k[0] -= 1;
                            k[1] += 1;
                        }
                    }
                    break;
                case "LB":
                    if (k[0] > 1 && k[1] > 1) {
                        if ((k[0] - 1 == s[0]) && (k[1] - 1 == s[1])) {
                            if (s[0] > 1 && s[1] > 1) {
                                k[0] -= 1;
                                k[1] -= 1;
                                s[0] -= 1;
                                s[1] -= 1;
                            }
                        } else {
                            k[0] -= 1;
                            k[1] -= 1;
                        }
                    }
                    break;
            }
        }
        System.out.println((char) (k[0] + 64) + "" + (char) (k[1] + 48));
        System.out.println((char) (s[0] + 64) + "" + (char) (s[1] + 48));
    }
}
