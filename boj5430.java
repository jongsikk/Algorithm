import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class boj5430 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String p = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            String line = reader.readLine();
            line = line.substring(1, line.length() - 1);
            String[] array = line.split(",");
            Deque<String> deque = new ArrayDeque<>();
            boolean isReversed = false;
            boolean isError = false;
            for (int j = 0; j < n; j++) {
                deque.add(array[j]);
            }
            for (int j = 0; j < p.length(); j++) {
                if (isError) {
                    break;
                }
                switch (p.charAt(j)) {
                    case 'R':
                        isReversed = !isReversed;
                        break;
                    case 'D':
                        if (deque.isEmpty()) {
                            writer.write("error");
                            isError = true;
                            break;
                        } else {
                            if (isReversed) {
                                deque.pollLast();
                            } else {
                                deque.pollFirst();
                            }
                        }
                        break;
                    default:
                        break;
                }
            }
            Iterator<String> iterator = deque.iterator();
            if (isReversed) {
                iterator = deque.descendingIterator();
            }
            if (!isError) {
                writer.write("[");
                while (iterator.hasNext()) {
                    writer.write(iterator.next());
                    if (iterator.hasNext()) {
                        writer.write(",");
                    }
                }
                writer.write("]");
            }
            if (i != t - 1) {
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
    }
}
