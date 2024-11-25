Q:- https://leetcode.com/problems/maximum-ice-cream-bars/
 Company Tags                : Apply, Amazon, Meta, Microsoft 
*********************************************************************************************
  class Solution {
    public int maxIceCream(int[] costs, int coins) {
        
        Arrays.sort(costs);
        int count = 0;
        for(int cost: costs)
        {
            if(cost > coins)
                return count;
            else {
                count++;
                coins -= cost;
            }
        }
        return count;
    }
}
