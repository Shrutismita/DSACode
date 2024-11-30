Q:- https://leetcode.com/problems/maximum-number-of-coins-you-can-get/
**********************************************************************************************
//Approach-1 (Using Greedy + 3 pointers)
//T.C : O(nlogn) - Sorting
//S.C : O(1)
----------------------------------------------------------
  class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        Arrays.sort(piles);
        int result = 0;
         int alice = n-1; 
         int m = n-2;
         int bob = 0;

         while (m > bob)
         {
            result += piles[m];

            bob++;
            alice -= 2;
            m -= 2;
         }
        return result;
    }
}
===========================================================================================================
//Approach-2 (Using Greedy without 3 pointers)
//T.C : O(nlogn) - Sorting
//S.C : O(1)
------------------------------------------------------------
  class Solution {
    public int maxCoins(int[] piles) {
         int n = piles.length;
         Arrays.sort(piles);
         int result = 0;
         
          for(int m = n/3 ; m < n; m+=2)
          {
            result += piles[m];
          }
         
        return result;
    }
}
