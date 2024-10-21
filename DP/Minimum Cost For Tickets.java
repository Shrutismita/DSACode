Q:- https://leetcode.com/problems/minimum-cost-for-tickets/
******************************************************************************
//Approach-1 (Recursion + Memoized) 
//T.C : O(max_day)
//S.C : O(n) //n = size of days array
----------------------------------------------------------------
  class Solution {
    int[] dp = new int[366];
    int memoized(int[] days, int[] costs,int n , int idx)
    {
         if(idx >= n)
            return 0; //you can't travel, so no cost
                
        if(dp[idx] != -1)
            return dp[idx];
        
        //if i take 1-day pass at idx
        int cost_1 = costs[0] + memoized(days, costs, n, idx+1);
        
        
        //if i take 7-day pass at idx
        int i          = idx;
        while(i < n && days[i] < days[idx]+7) {
            i++;
        }
        int cost_7 = costs[1] + memoized(days, costs, n, i);
        
        
        //if i take 30-day pass at idx
        int j      = idx;
        while(j < n && days[j] < days[idx]+30) {
            j++;
        }
        int cost_30 = costs[2] + memoized(days, costs, n, j);
        
        
        return dp[idx] = Math.min(cost_1, Math.min(cost_7, cost_30));
    }
    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, - 1);
         int n = days.length;
        return memoized(days, costs, n, 0);
    }
}
