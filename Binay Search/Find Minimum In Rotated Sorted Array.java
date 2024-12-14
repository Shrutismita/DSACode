Q:-153 https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
Company Tags                 : Amazon, Adobe, Microsoft, Morgan Stanley, Samsung, Snapdeal, Times Internet
*******************************************************************************************************************
//Time complexity: O(logn)
//Space complexity: O(1)
---------------------------------------------------
    class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while( l < r)
        {
            int mid = l + (r-l)/2;
            if(nums[mid] > nums[r])
            {
                l = mid+1;
            }
            else
            {
                r = mid;
            }
        }
        return nums[l];
    }
}
