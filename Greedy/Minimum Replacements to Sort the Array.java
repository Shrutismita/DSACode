Q:- https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
 Company Tags                : GOOGLE
**********************************************************************************************
//Using Greedy Approach 
//T.C : O(n) 
// S.C : O(1)
------------------------------------------------------------------------
  class Solution {
    public long minimumReplacement(int[] nums) {
        int n = nums.length;
        long operations = 0;
        
        for(int i = n-2; i >= 0 ; i--)
        {
            if(nums[i] <= nums[i+1])
                continue;

            long parts = nums[i]/nums[i+1];
            if(nums[i] % nums[i+1] != 0)
            {
                parts++;
            } 
            operations += parts - 1;
            nums[i] = nums[i]/(int)parts;   
        }
        return operations;
    }
}
