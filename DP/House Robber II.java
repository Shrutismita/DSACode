Q:- https://leetcode.com/problems/house-robber-ii/
*********************************************************
//Time complexity: O(N)
//Space complexity: O(N)
----------------------------------------------
  class Solution {
     public static int cal(int[] nums,int s,int e,int b){
        int[] dp=new int[nums.length-b];
        dp[0+s]=nums[0+s];
        dp[1+s]=Math.max(nums[1+s],nums[0+s]);
        for(int i=2+s;i<nums.length-b;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1-b];
    }
    public int rob(int[] nums) {
        if(nums.length==1){return nums[0];}
        if(nums.length==2){return Math.max(nums[0],nums[1]);}
        int a1=cal(nums,0,nums.length-1,1);
        int a2=cal(nums,1,nums.length,0);
        return Math.max(a1,a2);
    }
}
