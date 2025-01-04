Q:- https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 Company Tags                : AMAZON
 ****************************************************************************************************
//Approach - Using "Binary Search on Answer"
//T.C : O(n * log(max_d)), n is the number of flowers and max_d is the highest value in the array bloomDay.
//S.C : O(1)
-------------------------------------------------------------------------------
  class Solution {
    int getNumOfBouquets(int[] bloomDay, int mid, int k)
    {
         int numOfBouquets = 0;
         int consecutiveCount = 0;
        for(int i = 0; i < bloomDay.length; i++)
        {
            if(bloomDay[i] <= mid)
            {
                consecutiveCount++;
            }
            else
            {
                consecutiveCount = 0 ;
            }
             if( consecutiveCount == k)
             {
                   numOfBouquets++;
                   consecutiveCount = 0;
             }
        }
       return numOfBouquets;
    }
    public int minDays(int[] bloomDay, int m, int k) {
         // If it's impossible to get m bouquets
        if (bloomDay.length < m * k) {
            return -1;
        }

        int startDay = 1;
         int endDay = Arrays.stream(bloomDay).max().getAsInt();
        int minDays = - 1;
        while(startDay <= endDay)
        {
            int mid = startDay + (endDay - startDay)/2;
            if(getNumOfBouquets(bloomDay,mid,k) >= m)
            {
                minDays = mid;
                endDay = mid - 1;
            }
            else
            {
                startDay = mid +1;
            }
        }

      return minDays;
    }
}
