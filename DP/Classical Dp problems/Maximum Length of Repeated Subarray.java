Q:- https://leetcode.com/problems/maximum-length-of-repeated-subarray/
**************************************************************************************************
//Time Complexity : O(m * n), where m and n are the length of the two arrays
//Space Complexity : O(m)
----------------------------------------------------------------------------------
  class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        
    int max = 0;        //this will store ans
        int len1 = nums1.length;        
        int len2  = nums2.length;
        
        int dp[] = new int[len2 + 1];     
        
        for(int i = 1; i <= len1; i++) {
            for(int j = len2; j > 0; j--){  //traverse from backward
    
                if(nums1[i-1] == nums2[j-1]) { //when numbers are same, we add '+1' to previous value(j-1)
                    dp[j] = dp[j-1] + 1;
                    max = Math.max(max, dp[j]);      //update the ans
                } else {
                    dp[j] = 0;
                }
                
            }
        }
        
        return max;
    }
}
