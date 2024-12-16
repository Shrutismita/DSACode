Q:- https://leetcode.com/problems/kth-missing-positive-number/
Company Tags                : Google, Apple, Amazon, Meta
********************************************************************************
  //Naive Approach - 
  //Time Complexity:- O(n)
 -----------------------------------------------
  class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int num = 1;
        int i = 0 ;
        while(i < n && k > 0) 
        {
            if(arr[i] == num)
            {
                i++;
            }
            else
            {
                k--;
            }
            num++;
        }
        while(k-- > 0)
          num++;

       return num-1;   
    }
}
==========================================================================================
  //Approach-2 (Binary Search) - O(log(n))
  /*
  Explanation : 
  Since all the number in the array are in increasing order , so If NONE of the elemts is missing then 
  for each index i we should have the value (i+1). Here we are considering 0 based indexing.
  But if some the elements upto any index is missing , then we can find the number of missing elements using above logic.

  No of missing numbers at index i = (Current Value at index i ) - ( Correct Value as per contiguous sequence )
  = A[i]-(i+1) // At any index i
*/
 -----------------------------------------------------------------------------------------------------------------
  class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r= n-1;

        while(l <= r)
        {
               int mid = l + (r-l)/2;
               if(arr[mid] - (mid+1) < k ) //A[mid]-(mid+1)   --> This gives umber of missing number before m'th index
               {
                 l = mid+1;
               }
               else
               {
                r = mid - 1;
               }
        }
        return l+k;
    }
}
  
