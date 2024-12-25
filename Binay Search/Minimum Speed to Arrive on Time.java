Q:- https://leetcode.com/problems/minimum-speed-to-arrive-on-time/
 Company Tags                : GOOGLE
   Similar Porblems - 
            https://leetcode.com/problems/koko-eating-bananas/
            https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
            https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
            https://leetcode.com/problems/magnetic-force-between-two-balls/
            Allocate Minimum Number Of Pages (https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1)

 /*
  Two hints in this Qn which lead to Binary Search
  - The range of possible values here is 1 - 10^7. In binary search, we have to find answer from a sorted array. 
    Here we are left of finding answer from a sorted range. That's why it can be done using binary search

  - We have to find a speed x such that total time taken is less than the time given in problem,
    if I take too less speed then, it will take much more time and
    if we take more speed it will take less time but we need to keep speed to minimum.
    It hints towards moving towards left or right which we do in Binary Search
*/
******************************************************************************************************************************
//Binary Search
-------------------------
 class Solution {
    double possible(int[] dist,int speed)
    {
        double time = 0.0;
        int n = dist.length;
        for(int i = 0; i < n - 1; i++)
        {
            double t = (double) dist[i]/speed;
            time += Math.ceil(t);
        }
        time += (double) dist[n-1]/speed;
        return time;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = (int)1e7;
        int result = -1;
        while(l <= r)
        {
            int mid_speed = l+(r-l)/2;
            if(possible(dist,mid_speed) <= hour)
            {
                result = mid_speed;
                 r = mid_speed-1;
            }
            else
            {
                l = mid_speed+1;
            }
        }
        return result;
    }
}                                             
                                              
