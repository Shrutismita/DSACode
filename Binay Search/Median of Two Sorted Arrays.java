Q:- https://leetcode.com/problems/median-of-two-sorted-arrays/
  Company Tags                : Google, Microsoft, Apple, Zenefits, Yahoo, Adobe, Dropbox
 ***********************************************************************************************************
//Approach-1 - Brute Force
//T.C : O(m+n)
//S.C : O(m+n)
---------------------------------------------------
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int[] temp = new int[m+n];
        int i = 0, j = 0, k = 0;
        
        while(i < m && j < n) {
            if(nums1[i] < nums2[j])
                temp[k++] = nums1[i++];
            else
                temp[k++] = nums2[j++];
        }
        
        while(i < m) temp[k++] = nums1[i++];
        while(j < n) temp[k++] = nums2[j++];
        
        int size = m+n;
        
        if(size%2 != 0)
            return temp[size/2];
        
        return (temp[size/2]+temp[(size/2)-1])/2.0;
    }
}
=======================================================================================================
//Approach-2 (Using Binary Search)
//T.C : O(log(min(m, n))
//S.C : O(1)
---------------------------------------------------------------
  class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length;
        int n = nums2.length;
        
       int low = 0, high = m;
       while(low <= high)
       {
            int Px = low + (high-low)/2; //mid - from nums1
            int Py = (m+n+1)/2 - Px; // from nums2
          
            //left half side
            int x1  = (Px == 0) ? Integer.MIN_VALUE : nums1[Px-1];
            int x2  = (Py == 0) ? Integer.MIN_VALUE : nums2[Py-1];
            
            //Right half side
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];           
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];
            
            if(x1 <= x4 && x2 <= x3) {
                if((m+n)%2 == 0)
                    return (Math.max(x1, x2) + Math.min(x3, x4))/2.0;
                
                return Math.max(x1, x2);
            } else if(x1 > x4) {
                high = Px-1;
            } else {
                low = Px+1;
            }
       }
       return -1;
    }
}
