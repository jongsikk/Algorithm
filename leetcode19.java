public class leetcode19 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode node = head.next;
            int length = 1;
            while (node != null) {
                length++;
                node = node.next;
            }
            if (length == 1) {
                return null;
            }
            if (length == n) {
                return head.next;
            }

            node = head;
            head.next = node.next;
            for (int i = 1; i < length - n; i++) {
                node = node.next;
            }
            node.next = node.next.next;

            return head;
        }
    }
}
