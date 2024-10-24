Q:- https://leetcode.com/problems/continuous-subarray-sum/
 Company Tags                : Amazon, Facebook, Paytm
*********************************************************************************
//T.C: O(n)
//S.C : O(n)
-----------------------------------------
  class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
         int n = nums.length;
         // Map to store the first occurrence of a particular remainder
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);// This handles the case where a valid subarray starts from index 0
        
        int sum = 0;
        
        for(int i = 0; i<n; i++) {
            sum += nums[i];
            
            int remainder = sum % k;
             // If the remainder has been seen before
            if(map.containsKey(remainder)) {
                 // Check if the length of the subarray is at least 2
                if(i -  map.get(remainder) >= 2)
                    return true;
                
            } else {
                 // Store the index of the first occurrence of this remainder
                 map.put(remainder, i);
                
            }
        }
        return false;
    }
}
