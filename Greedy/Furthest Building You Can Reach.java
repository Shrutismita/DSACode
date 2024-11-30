Q:- https://leetcode.com/problems/furthest-building-you-can-reach/
 Company Tags    		: Microsoft, Google
**********************************************************************************************
//Using Lazy Greedy
//T.C : O(nlogn)
//S.C : O(n)
-----------------------------------------------------------
  class Solution {
   
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        for(i = 0; i < n-1; i++)
        {
            if(heights[i] >= heights[i+1])
                  continue;

             int diff = heights[i + 1] - heights[i];
             if(diff <= bricks)
             {
                bricks -= diff;
                pq.add(diff);
             }
             else if(ladders > 0)
             {
                if(!pq.isEmpty() && pq.peek() > diff)
                {
                    bricks += (pq.remove() - diff);
                    pq.add(diff);
                }
                ladders--;
             }
             else
                break;
        }
       return i;
    }
}
