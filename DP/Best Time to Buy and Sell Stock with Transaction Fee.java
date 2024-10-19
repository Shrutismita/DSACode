Q:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
**********************************************************************************************
//Approach (Using Recursion+Memo)
//T.C:- O(n*n)
---------------------------------------------------------
  class Solution {
     int[][] dp ;
     int n ;
     public int solve(int[] arr, int i, int last,int fee){
        if(i>=n)
            return 0;
        if(dp[i][last]!=-1)
            return dp[i][last];
        int buy = -1000000008 , sell = -1000000008;
        if(last==0)
            buy = -arr[i] + solve(arr,i+1,1,fee);
        if(last==1)
            sell = arr[i] + solve(arr,i+1,0,fee) - fee;
        int hold = solve(arr,i+1,last,fee);
        return dp[i][last] = (int)Math.max((int)Math.max(buy,sell),hold);
    }
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        dp = new int[n+1][2];
        for ( int i=0; i<=n; i++){
            for ( int j=0; j<2; j++)
                dp[i][j] = -1;
        }
        return solve(prices,0,0,fee);
    }
}
