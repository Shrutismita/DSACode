Q:- https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
Company Tags                : META
******************************************************************************************************
 //Time complexity : O(n)
//Space complexity : O(1) 
----------------------------------------------------
  class Solution {
    public long mod = (long)1e9+7;
    public int countOrders(int n) {
        if(n == 1) return 1;
        long result = 1;
        for(int i = 2; i <= n ; i++)
        {
               int spaces = (i-1)*2+1;
               int possibility = spaces*(spaces+1)/2;
               result *= possibility;
               result %= mod;

        }
        return (int)result;
    }
}
