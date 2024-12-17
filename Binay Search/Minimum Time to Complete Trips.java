Q:- https://leetcode.com/problems/minimum-time-to-complete-trips/
Company Tags                : Google, PhonePe
*********************************************************************************************************
//Using Binary Search - O(n * log(totalTrips * m)) -> where m = minimum time in the given array
----------------------------------------------------------------------------------------------
  class Solution {
    boolean possible(int[] time, long givenTime,int totalTrips)
    {
        long actualTrips = 0;
        
        for(int t : time) {
            actualTrips += givenTime/t;
        }
        
        return actualTrips >= totalTrips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long l = 1;
        long max_time = 0;
        for(int t :time)
        {
            max_time = Math.max(max_time,t);
        }
        long r = max_time*totalTrips;

        while(l < r)
        {
            long mid_time = l + (r-l)/2;
            
            if(possible(time, mid_time, totalTrips)) {
                r = mid_time;
            } else {
                l = mid_time + 1;
            }
            
        }
        
        return l;
    }
}
