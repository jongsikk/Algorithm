public class leetcode2 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode answer = new ListNode();
            ListNode now = answer;

            int over = 0;
            while (l1 != null || l2 != null || over != 0) {
                int sum = over;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                if (sum > 9) {
                    over = 1;
                    sum %= 10;
                } else {
                    over = 0;
                }

                now.next = new ListNode(sum);
                now = now.next;
            }

            return answer.next;
        }
    }
}
