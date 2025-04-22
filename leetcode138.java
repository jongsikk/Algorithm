import java.util.HashMap;
import java.util.Map;

public class leetcode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }
            Map<Node, Node> map = new HashMap<>();
            Node answer = new Node(head.val);

            Node h = head;
            while (h != null) {
                map.put(h, new Node(h.val));
                h = h.next;
            }

            h = head;
            while (h != null) {
                map.get(h).next = map.get(h.next);
                map.get(h).random = map.get(h.random);
                h = h.next;
            }

            return map.get(head);
        }
    }
}
