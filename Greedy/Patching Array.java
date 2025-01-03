Q:- https://leetcode.com/problems/patching-array/
Company Tags                : GOOGLE
*************************************************************************************************
//Approach (Greedy observation)
//T.C : O(max(l, log(n)), l = length of nums
//S.C : O(1)
---------------------------------------------------------------------------
  class Solution {
    public int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int patch = 0;
        int i = 0;

        while(maxReach < n)
        {
            if(i < nums.length && nums[i] <= maxReach +1)
            {
                maxReach += nums[i];
                i++;
            }
            else
            {
                maxReach += (maxReach+1);
                patch++;
            }
        }
        return patch;
    }
}
