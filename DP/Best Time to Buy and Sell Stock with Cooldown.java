Q:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
*****************************************************************************************
//Approach-1 (Recursion+Memoization)
//T.C: - O(n)
------------------------------------------------------
  class Solution {
    int[][] dp ;
    int solve(int[] prices, int day, int n, int buy)
    {
        if(day >= n) return 0;
        if(dp[day][buy] != -1)
             return dp[day][buy];

          int profit = 0;
          if(buy == 1)
          {// can buy
          // actually buy
            int take = solve(prices,day+1,n,0) - prices[day];
              // not buy
            int not_take = solve(prices,day+1,n,1);
            profit = Math.max(profit,Math.max(take,not_take));
          }   
          else
          {// can sell
           // actually sell
            int sell = solve(prices, day+2,n,1)+prices[day];
             // not sell
            int not_sell = solve(prices,day+1,n,0);
            profit = Math.max(profit, Math.max(sell,not_sell));
          }
          return dp[day][buy]=profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = 1;// inititally start with buy
        dp = new int[n][2];
        for(int[] arr : dp)
           Arrays.fill(arr,-1);

         return solve(prices,0,n,buy);  
    }
}
