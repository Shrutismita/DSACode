Q:- https://leetcode.com/problems/grumpy-bookstore-owner/
***************************************************************************************************
//Approach - Sliding Window
//T.C : O(n)
//S.C : O(1)
--------------------------------------------
  class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
       int n = customers.length;
       int currUnsat = 0;

      // Calculate initial unsatisfied customers in the first 'minutes' window
       for(int i = 0; i < minutes; i++)
       {
          if(grumpy[i] == 1)
               currUnsat += customers[i];
       }
       int maxUnsat = currUnsat;
      // Use two pointers i and j to define the sliding window of size 'minutes'
       int i = 0, j = minutes;
      
       while(j < n)
       {
           if(grumpy[j] == 1)
                 currUnsat += customers[j];  // Include current element

            if(grumpy[i] == 1)     
                  currUnsat -= customers[i]; // Remove element going out of window

           maxUnsat = Math.max(maxUnsat,currUnsat); // Update maxUnsat
           i++;
           j++;
       }
       int totalSat = maxUnsat;

       // Calculate total satisfied customers
       for(int k = 0; k < n; k++)
       {
           if(grumpy[k] == 0)
               totalSat += customers[k];
       }

       return totalSat;
    }

}
