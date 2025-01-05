Q:- https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/
/***********************************************************************************************************************/
//Approach (Using Binary Search in Answer - See the problem statement : It asks to Minimize the Maximum which hints towards Binary Search On Answer)
//T.C : O(nlog(MAX)), where n = length of nums, MAX = max value in nums
//S.C : O(1)
------------------------------------------------------------------------------------------------------
  class Solution {
    boolean isPossible(int[] nums, int maxOps, int mid)
    {
        int totalOps = 0; // To bring each number <= mid
        for(int num : nums)
        {
            int ops = num/mid;
            if(num % mid == 0)
            {
                ops -= 1;
            }
            totalOps += ops;
        }
        return totalOps <= maxOps;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        int result = r; // We have to minimize this

        // Binary search: O(n * log(MAX))
        while(l <= r)
        {
            int mid = l + (r-l)/2;
            if(isPossible(nums,maxOperations,mid))
            {
                result = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return result;
    }
}
