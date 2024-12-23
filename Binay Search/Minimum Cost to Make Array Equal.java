Q:- https://leetcode.com/problems/minimum-cost-to-make-array-equal/
Company Tags                - MICROSOFT
********************************************************************************************
  class Solution {
    long getCost(int[] nums, int[] cost,int target)
    {
        long ans = 0;
        for(int i = 0; i < nums.length; i++)
        {
            ans += (long) Math.abs(nums[i] - target)*cost[i];
        }
        return ans;
    }
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        long result = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for(int num : nums)
        {
            left = Math.min(left,num);
            right = Math.max(right,num);
        }
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            long cost1 = getCost(nums, cost, mid);
            long cost2 = getCost(nums, cost, mid + 1);

            result = Math.min(cost1,cost2);
            if(cost1 > cost2)
               left = mid+1;
            else
               right = mid -1;   
        }
        return result == Integer.MAX_VALUE ? 0: result;
    }
}
