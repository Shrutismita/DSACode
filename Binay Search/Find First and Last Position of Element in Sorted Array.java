Q:- https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 Company Tags                : LinkedIn, Amazon, Microsoft
*************************************************************************************************************
 //Approach-1 (Using Two Custom Binary Search)
//T.C : O(nlogn)
-------------------------------------------------------------------------
  class Solution {
    public int findFirstPosition(int[] nums, int target)
    {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while(l <= r)
        {
            int mid =  l +(r-l)/2;
            if (nums[mid] == target) {
                result = mid; // possibly my answer
                r = mid - 1; // but lets look at left more
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;

    }
    public int findLastPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int result = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                result = mid; // possibly my answer
                l = mid + 1; // but lets look at right more
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int firstPosition = findFirstPosition(nums,target);
        int lastPosition = findLastPosition(nums,target);

        return new int[]{firstPosition, lastPosition};
    }
}
