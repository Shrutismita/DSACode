Q:- https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 Company Tags                : Adobe, Amazon, Microsoft, Morgan Stanley, Samsung, Snapdeal, Times Internet
*****************************************************************************************************************
//T.C:- O(nlogn)
------------------------
  class Solution {
    int findPivot(int[] nums,int l, int r)
    {
        while(l < r)
        {
         while(l < r && nums[l] == nums[l+1])
                l++;
            
            while(r < l && nums[r] == nums[r-1])
                r--;
         int mid = l + (r-l)/2;
         if(nums[mid] > nums[r])
         {
            l = mid + 1;
         }
         else
         { //sorted part
            r = mid; //possibly my pivot
         }
        }
        return r;
    }
    boolean binarySearch(int[] nums,int l, int r, int target)
    {
        while(l <= r)
        {
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
                 return true;

            if(nums[mid] < target)
            {
                l = mid+1;
            }
            else
            {
                r = mid - 1;
            }     
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int pivot = findPivot(nums,0,n-1);

        if(binarySearch(nums,0,pivot - 1, target))
        {
            return true;
        }
         return binarySearch(nums, pivot, n-1, target);
    }
}
