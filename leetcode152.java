import java.math.BigInteger;

public class leetcode152 {

    class Solution {
        public int maxProduct(int[] nums) {
            BigInteger maxProduct = BigInteger.valueOf(Integer.MIN_VALUE);

            BigInteger product = BigInteger.ONE;
            for (int num : nums) {
                if (product.equals(BigInteger.ZERO))
                    product = BigInteger.ONE;
                product = product.multiply(BigInteger.valueOf(num));
                maxProduct = maxProduct.max(product);
            }

            product = BigInteger.ONE;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (product.equals(BigInteger.ZERO))
                    product = BigInteger.ONE;
                product = product.multiply(BigInteger.valueOf(nums[i]));
                maxProduct = maxProduct.max(product);
            }

            return maxProduct.intValue();
        }
    }
}
