Q:- https://leetcode.com/problems/find-the-pivot-integer/
 Company Tags                : Apple
***********************************************************************************
//Approach-1 (Using two pointer)
//T.C : O(n)
//S.C : O(1) 
----------------------------------------------------------------
  class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        int i = 1;
        int j = n;

        int frontSum = 1;
        int backSum = n;
        while(i < j )
        {
             if (frontSum < backSum)
             {
                i++;
                frontSum += i;
            } else {
                j--;
                backSum += j;
            }
        }
        return frontSum == backSum ? i : -1;
    }
}
============================================================================
// Approach-2 (Using Binary Search)
// T.C: log(n)
// S.C: O(1)
--------------------------------------------------------
  class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        
       int totalSum = n * (n + 1) / 2;

        int left = 1, right = n;

        while (left <= right) {
            int midPivot = left + (right - left) / 2;

            if (midPivot * midPivot == totalSum) {
                return midPivot;
            } else if (midPivot * midPivot < totalSum) {
                left = midPivot + 1;
            } else {
                right = midPivot - 1;
            }
        }

        return -1;
    }
}
===========================================================================
// Approach-3 (Using Quick Math)
// T.C: O(1)
// S.C: O(1)
---------------------------------------------
  class Solution {
    public int pivotInteger(int n) {
        if(n == 1) return 1;
        
        int totalSum = n * (n + 1) / 2;

        int pivot = (int) Math.sqrt(totalSum);

        if (pivot * pivot == totalSum)
            return pivot;

        return -1;
    }
}
  
