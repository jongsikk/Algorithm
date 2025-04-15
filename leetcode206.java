public class leetcode206 {
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
        public ListNode reverseList(ListNode head) {
            ListNode answer = null;
            ListNode now = head;

            while (now != null) {
                ListNode temp = now.next;
                now.next = answer;
                answer = now;
                now = temp;
            }

            return answer;
        }
    }
}
