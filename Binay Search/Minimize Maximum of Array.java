Q:- https://leetcode.com/problems/minimize-maximum-of-array/
 Company Tags                : Meta
Similar Leetcode Qn          : https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
************************************************************************************************************
 //Approach- BinarySearch
//Time complexity: O(log(max-min))
//Space complexity: O(1)
 -------------------------------------------------
  class Solution {
    boolean isValid(int[] nums, int mid_max, int n)
    {
        long moves = 0;
        for(int i = 0; i<n; i++) {
            
            if(nums[i] < mid_max)
            {
                moves += mid_max - nums[i];
            }
             else
             {
                moves -= nums[i] - mid_max;
                if(moves < 0)
                    return false;
             }   
            
        }
        
        return moves >= 0;
    }
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        int maxL = 0;
        int maxR = 0;
        for(int num : nums)
        {
            maxL = Math.min(maxL,num);
            maxR = Math.max(maxR,num);
        }
        int result = 0;
        while(maxL <= maxR)
        {
            int mid_max = maxL + (maxR-maxL)/2;
            if(isValid(nums, mid_max, n)) {
                result = mid_max;
                maxR   = mid_max-1;
            } else {
                maxL = mid_max+1;
            }
        }
        return result;
    }
}
================================================================================================
  //Approach- Math
//Time complexity: O(n)
//Space complexity: O(1)
  ---------------------------
  class Solution {
    
    public int minimizeArrayValue(int[] nums) {
        long sum = 0, res = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            res = Math.max(res, (sum + i) / (i + 1));
        }
        return (int)res;
    }
}
