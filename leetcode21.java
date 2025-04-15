public class leetcode21 {
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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode answer = new ListNode();
            ListNode now = answer;

            while (list1 != null && list2 != null) {
                if (list1.val > list2.val) {
                    now.next = list2;
                    list2 = list2.next;
                } else {
                    now.next = list1;
                    list1 = list1.next;
                }
                now = now.next;
            }

            now.next = list1 == null ? list2 : list1;

            return answer.next;
        }
    }
}
