Q:- https://leetcode.com/problems/candy/
Company Tags                : Amazon
*********************************************************************
//Approach-1
//T.C : O(n)
//S.C : O(2*n) ~ O(n) But using 2 Extra Arrays
-------------------------------------------------------------
  class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] L2R = new int[n];
        Arrays.fill(L2R,1);

        int[] R2L = new int[n];
        Arrays.fill(R2L,1);

         //First comparing with only left neighbour
         for(int i = 1; i < n; i++)
         {
             if(ratings[i] > ratings[i-1])             
                 L2R[i] = Math.max(L2R[i],L2R[i-1]+1);             
         }

         //Then comparing with only right neighbour
         for(int i = n-2; i >= 0; i--)
         {
            if(ratings[i] > ratings[i+1])
                R2L[i] = Math.max(R2L[i], R2L[i+1]+1);
         }

        int result = 0;
        for(int i = 0; i < n; i++) 
        {
            result += Math.max(L2R[i], R2L[i]);
        }
        
        return result;
    }
}
=============================================================================================
//Approach-2 
//T.C : O(n)
//S.C : O(n) - Using only 1 Extra Array
---------------------------------------------------
  class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] count = new int[n];
        Arrays.fill(count,1);

         //First comparing with only left neighbour
         for(int i = 1; i < n; i++)
         {
             if(ratings[i] > ratings[i-1])             
                 count[i] = Math.max(count[i],count[i-1]+1);             
         }

         //Then comparing with only right neighbour
         for(int i = n-2; i >= 0; i--)
         {
            if(ratings[i] > ratings[i+1])
                count[i] = Math.max(count[i], count[i+1]+1);
         }

        int result = 0;
        for(int c : count) 
        {
            result += c;
        }
        
        return result;
    }
}
=========================================================================================================
  
