Q:- https://leetcode.com/problems/tallest-billboard/
***************************************************************
//Using DP+Memo
-----------------------------------------------------------------
  class Solution {
     int solve(int [] rod, int diff, int idx ,int [][]dp){
        if(idx<0){
            if(diff==0) return 0;
            return Integer.MIN_VALUE;
        }
        if(dp[idx][diff+5000]!=-1) return dp[idx][diff+5000];
       
        int notPick = solve(rod,diff,idx-1,dp);
        int pick1 = rod[idx] + solve(rod,diff+rod[idx],idx-1,dp);
        int pick2 = solve(rod,diff-rod[idx],idx-1,dp);

        dp[idx][diff+5000]=Math.max(notPick,Math.max(pick1,pick2));

        return dp[idx][diff+5000];
    }
    public int tallestBillboard(int[] rods) {
         int [][] dp= new int [rods.length][10001];
        for(int i=0;i<rods.length;i++) Arrays.fill(dp[i],-1);
        return solve(rods,0,rods.length-1,dp);
    }
}
