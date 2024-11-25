Q:- https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/
*******************************************************************************
//T.C:- O(nlogn)
----------------------------
  class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int[] required = new int[n];

        for(int i = 0 ; i< n; i++)
        {
            required[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(required);
        int count = 0;
        for(int i = 0; i < n; i++)
        {           
                if(additionalRocks >= required[i])
                {
                    additionalRocks -= required[i];
                    count++;
                }
                else
                {
                    break;
                }
                
        }
        return count;
    }
}
