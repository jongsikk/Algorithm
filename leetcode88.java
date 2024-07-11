public class leetcode88 {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int i1 = m - 1;
            int i2 = n - 1;
            int last = m + n - 1;

            while (i2 >= 0) {
                if (i1 >= 0 && nums1[i1] > nums2[i2]) {
                    nums1[last--] = nums1[i1--];
                } else {
                    nums1[last--] = nums2[i2--];
                }
            }
        }
    }
}
