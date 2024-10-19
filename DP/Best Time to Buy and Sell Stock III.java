Q:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
********************************************************************************
  class Solution {
    Integer[][] dp;
    
    public int maxProfit(int[] prices) {
        dp = new Integer[prices.length+1][(4*2)+1];
        return solve(4,prices,0);
    }
    
    int solve(int k,int[] prices,int idx){
        
        if( k == 0 || idx >= prices.length) return 0;
        if(dp[idx][k]!=null) return dp[idx][k];
        return dp[idx][k] = Math.max(solve(k,prices,idx+1),
                        (int)(prices[idx]*Math.pow(-1,(k+1)%2) + solve(k-1,prices,idx+1)));
    }
}
