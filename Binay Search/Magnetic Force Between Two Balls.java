Q:- https://leetcode.com/problems/magnetic-force-between-two-balls/
 Company Tags                : AMAZON
*****************************************************************************************************************
//Approach-1 (Using Binary Search on Answer)
//T.C : O(nlogn + n*log(max_force_diff))
//S.C : O(1)
--------------------------------------------------------------------
  class Solution {
    boolean possibleToPlace(int[] position, int midForce, int m)
    {
        int prev = position[0];
        int countBalls = 1;

        for(int i = 0; i < position.length; i++)
        {
            int curr = position[i];
            if((curr - prev) >= midForce)
            {
                countBalls++;
                prev = curr;
            }
            if(countBalls == m)
            {
                break;
            }
        }
        return countBalls == m;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int minForce = 1;
        int maxForce = position[n-1]-position[0];
        int result = 0;
        while(minForce <= maxForce)
        {
            int midForce = minForce + (maxForce-minForce)/2;
            if(possibleToPlace(position,midForce,m))
            {
                result = midForce;
                minForce = midForce + 1;
            }
            else
            {
               maxForce = midForce - 1; 
            }
        }
        return result;
    }
}
