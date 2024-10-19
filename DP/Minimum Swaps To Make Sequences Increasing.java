Q:- https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/
********************************************************************************
//Approach-(Recursion+Memo)
-------------------------------------------
  class Solution {
     int[][] dp;
     int solve(int[] a, int[] b, int i, int swapped) {
        if(i==0) 
        	return swapped;
        if(dp[i][swapped]!= -1) 
        	return dp[i][swapped];
        //no swap
        int ans = Integer.MAX_VALUE;
        if(a[i]>a[i-1] && b[i]>b[i-1]) {
            ans = solve(a, b, i-1, swapped);
        }
        //swap
        if(a[i]>b[i-1] && b[i]>a[i-1]) {
            ans = Math.min(ans, solve(a, b, i-1, 1-swapped));
        }
        return dp[i][swapped] = ((swapped == 0) ? ans : ans+1);
    }
    public int minSwap(int[] nums1, int[] nums2) {
        dp = new int[nums1.length][2];
         for(int[] row : dp) Arrays.fill(row, -1);
        return Math.min(solve(nums1, nums2, nums1.length-1, 0),
                        solve(nums1, nums2, nums1.length-1, 1));
    }
}
