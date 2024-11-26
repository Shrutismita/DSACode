Q:- https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
  Company Tags                : Atlassian, Adobe, Twitter
 *********************************************************************************************************
//Approach-1 (Using Greedy approach similar to Jump Game-II)
//TC : O(n)
//SC : O(1)
----------------------------------------------------------------
  class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] startEnd = new int[n+1];
        Arrays.fill(startEnd,0);

        for(int i = 0; i < ranges.length; i++)
        {
           int start = Math.max(0, i - ranges[i]);
           int end = Math.min(n, i+ranges[i]);
           startEnd[start] = Math.max(startEnd[start],end);
        }
       int taps = 0;
       int maxEnd = 0;
       int currEnd = 0;
       for(int i = 0; i <=n;i++)
       {
            if(i > maxEnd)
            {
                return -1;
            }
            if(i > currEnd)
            {
                taps++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd,startEnd[i]);
       }
       return taps;
    }
}
