import javax.swing.tree.TreeNode;

public class leetcode543 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int answer = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            if (root == null) {
                return 0;
            }
            depth(root);

            return answer;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = depth(root.left);
            int right = depth(root.right);
            answer = Math.max(answer, left + right);

            return Math.max(left, right) + 1;
        }
    }
}
