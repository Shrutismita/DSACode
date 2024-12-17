Q:-704 https://leetcode.com/problems/binary-search/
 Company Tags                : Everyone :-)
*******************************************************************************************************   
//Iterative : O(log(n))
--------------------------------------------------
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while(l <= r)
        {
            int mid = l+(r-l)/2;
            if(nums[mid] == target)
            {
                return mid;
            }
            else if (nums[mid] < target)
            {
                l = mid+1;
            }
            else
            {
                r = mid - 1;
            }
        }
        return -1;
    }
}
================================================================================================
//Recursive : O(log(n))
------------------------------------
    class Solution {
    int solve(int[] nums, int l, int r, int target) {
        if(l > r)
            return -1;
        
        int mid = l + (r-l)/2;
        
        if(nums[mid] == target)
            return mid;
        else if(nums[mid] < target)
            return solve(nums, mid+1, r, target);
        else
            return solve(nums, l, mid-1, target);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
         return solve(nums, 0, n-1, target);
    }
}
