Q:- https://leetcode.com/problems/maximum-product-subarray/
*********************************************************************
Time complexity: O(n)
Space complexity: O(1)
--------------------------------------------------
class Solution {
    public int maxProduct(int[] nums) {
         int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - 1; i++) {
            if (prefix == 0)
                prefix = 1;
            if (suffix == 0)
                suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - 1 - i];
            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;

    }

}
