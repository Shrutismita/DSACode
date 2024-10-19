Q:- https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
*************************************************************************************************
//Time Complexity : O(2 * k * n)
//Space complexity: O(n)
---------------------------------------------------------------
  class Solution {
    public int maxProfit(int k, int[] prices) {
        
     int n = prices.length, DEF_VAL = Integer.MIN_VALUE;
        int maxProfit = 0;

        // Solve special Edge cases
        if (n <= 1 || k <= 0) {
            return 0;
        }

        if (k * 2 >= n) {
            int res = 0;
            for (int i = 1; i < n; i++) {
                res += Math.max(0, prices[i] - prices[i - 1]);
            }
            return res;
        }

        int[] dp = new int[n+1];

        // Base case
        // For (2*k)th transaction sequence, maxProfit == 0
        Arrays.fill(dp,0);

        int temp, next;

        // fill the array
        for (int s = (2*k)-1; s > -1; s--) {
            next = dp[n - (2*k - (s + 1))];
            dp[n - (2*k - (s + 1))] = DEF_VAL;
            for (int d = (n - 1) - (2*k - (s + 1)); d > -1; d--) {
                temp = dp[d];
                if(s % 2 == 1) {
                    dp[d] = Math.max(
                        dp[d + 1], next + prices[d]
                    );
                } else {
                    dp[d] = Math.max(
                        dp[d + 1], next - prices[d]
                    );
                }
                next = temp;
            }
            if(s%2 == 0) maxProfit = Math.max(maxProfit,dp[0]);
        }
        return maxProfit;
    }
}
