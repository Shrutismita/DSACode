Q:- https://leetcode.com/problems/new-21-game/
 Company Tags                : Google
***************************************************************************************************
//Time complexity: O(n)
//Space complexity: O(maxPts)
-----------------------------------------------------------
  class Solution {
    public double new21Game(int n, int k, int maxPts) {
        
        if(k == 0 || n >= k+maxPts) return 1.0;
          double[] P = new double[n+1];
          P[0] = 1.0;
          double currProbabSum = k > 0 ? 1 : 0;
          double result = 0.0;
            for (int i = 1; i <= n; i++) 
            {            
               P[i] = currProbabSum/maxPts;
            
                if(i < k) 
                {
                      currProbabSum += P[i];
                }
                else
                {
                    result += P[i];
                }
            
               if(i - maxPts >= 0 && i-maxPts < k) 
                {
                  currProbabSum -= P[i-maxPts];
                }
            
        }
        return result;

    }
}
