Q:- https://leetcode.com/problems/find-pivot-index/
 Company Tags                : Amazon, Adobe, Coupang, Radius
*******************************************************************************
//Time complexity:- O(n)
//Space complexity:- O(1)
--------------------------------------------------------
  class Solution {
    public int pivotIndex(int[] nums) {
   int totalSum = 0;
        // Calculate the total sum of the array
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int left_sum = 0; // Initialize the left sum
        // Iterate through the array to find the pivot index
        for (int i = 0; i < nums.length; i++) {
            int right_sum = totalSum - left_sum - nums[i]; // Calculate the right sum
            if (left_sum == right_sum) { // Check if left sum equals right sum
                return i; // Return the pivot index
            }
            left_sum = left_sum + nums[i]; // Update the left sum
        }

        return -1; // If no pivot index is found, return -1
    }
}
