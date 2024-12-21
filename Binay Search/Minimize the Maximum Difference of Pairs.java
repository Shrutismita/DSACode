Q:- https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/
****************************************************************************************
  class Solution {
    boolean isValid(int[] nums, int mid_max,int p)
    {
       int i = 0;
        int pair = 0;
         while(i < nums.length - 1)
          {
            
            if(nums[i+1] - nums[i] <= mid_max)
            {
                pair++;
                i += 2;
            }
             else
             {
                i++;
             }   
            
        }
        
        return pair >= p;
    }
    public int minimizeMax(int[] nums, int p) {
        
         int n = nums.length;
        
         Arrays.sort(nums);

        int maxL = 0;
        int maxR = nums[n-1] - nums[0];
        int result = 0;
        while(maxL <= maxR)
        {
            int mid_max = maxL + (maxR-maxL)/2;
            if(isValid(nums, mid_max,p)) {
                result = mid_max;
                maxR   = mid_max-1;
            } else {
                maxL = mid_max+1;
            }
        }
        return result;
    }
}
