Q:- https://leetcode.com/problems/maximum-running-time-of-n-computers/
Company Tags                : GOOGLE
***********************************************************************************
  //Approach- (Using Binary Search on the result minutes) . 
  //T.C. : O(m⋅logk) - m = input array length and k = range of minutes
------------------------------------------------------------------------------------
  class Solution {
    boolean possible( int[] batteries,long mid_time, int n)
    {
         long target = n*mid_time; //each computer will run mid_time minutes
        
        long sum = 0;
        
        for(int i = 0; i<batteries.length; i++) {
            
            target -= Math.min((long)batteries[i], mid_time);
            
            if(target <= 0)
                return true;
            
        }
        return target <= 0;
    }
    public long maxRunTime(int n, int[] batteries) {
        long l = 1;
        long sum_total_minutes = 0;
        for(int battery : batteries)
        {
            l = Math.min(l,battery);
           sum_total_minutes += battery;
        }
        long r = sum_total_minutes/n;
        
        long result = 0;
        while(l <= r)
        {
            long mid_time = l + (r-l)/2;
            if(possible(batteries, mid_time, n)) {
                result = mid_time;
                l = mid_time+1;
            } else {
                r = mid_time-1;
            }
        }
       return result;
    }
}
