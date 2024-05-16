import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1991 {
    static Node[] nodes;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());

        nodes = new Node[100];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            char value = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            nodes[value] = new Node(value);
            nodes[value].left = leftValue;
            nodes[value].right = rightValue;
        }

        pre(nodes['A']);
        System.out.println();
        in(nodes['A']);
        System.out.println();
        post(nodes['A']);
    }

    static class Node {
        char value;
        char left;
        char right;

        Node(char value) {
            this.value = value;
        }
    }

    static void pre(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value);
        pre(nodes[node.left]);
        pre(nodes[node.right]);
    }

    static void in(Node node) {
        if (node == null) {
            return;
        }
        in(nodes[node.left]);
        System.out.print(node.value);
        in(nodes[node.right]);
    }

    static void post(Node node) {
        if (node == null) {
            return;
        }
        post(nodes[node.left]);
        post(nodes[node.right]);
        System.out.print(node.value);
    }
}
