Q:- https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 Company Tags : Meta, Baidu, Google, Flipkart, D-E-Shaw, Amazon
  Keywords to identify this Qn category : "(in the order given by weights/count)"
*************************************************************************************************
  class Solution {
    int possible(int[] weights, int mid)
    {        
        int currDayCount  = 1;
        int currSumWeight = 0;
        for(int w : weights) {
            currSumWeight += w;
            
            if(currSumWeight > mid) {
                currDayCount++;
                currSumWeight = w;
            }
            
        }
        
        return currDayCount;

    }
    public int shipWithinDays(int[] weights, int days) {
        int minWeight = 0;
        int maxWt = 0;
        int result = 0;
        int n = weights.length;
        

        for(int i = 0 ; i < weights.length; i++)
        {
            maxWt = Math.max(maxWt,weights[i]);
            minWeight += weights[i];
        }
         if(n < days)
            return -1; //not possible case
        
        if(days == 1)
            return minWeight;

             int high = minWeight;
             int low  = maxWt; 

        while(low < high)
        {
            int mid = low + (high-low)/2;
            if(possible(weights,mid) <= days)
            {
                high = mid;
            }
            else
            {
                low = mid+1;
            }
        }
        return high;
    }
}
  
