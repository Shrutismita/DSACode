Q:- https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
*************************************************************************************************
//Approach (Using classic sliding window template + using set/map to keep distinct element)
//T.C : O(n)
//S.C : O(n)
---------------------------------------------------------------------------------------
  class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        long result = 0;
        long currWindowSum = 0;
        int i = 0, j = 0;
        while(j < n)
        {
            // Adjust the window if nums[j] is already in the set
            while(set.contains(nums[j]))
            {
                 currWindowSum -= nums[i];
                 set.remove(nums[i]);
                 i++;
            }

            set.add(nums[j]);
            currWindowSum += nums[j];

            // Check if the window size is equal to k
            if((j-i+1) == k)
            {
                result = Math.max(result,currWindowSum);
                // Shrink the window from the left
                currWindowSum -= nums[i];
                set.remove(nums[i]);
                i++;
            }
           
            j++;
        }
        return result;
    }
}
