Q:- https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
*************************************************************************************************
//T.C : O(nlogn)
//S.C : O(1)
----------------------------------------
  class Solution {
    public long largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long perimeter = 0;
        long remainigsideSum = 0;
        for(int i = 0; i < n; i++)
        {
            if(nums[i] < remainigsideSum)
            {
               perimeter = remainigsideSum + nums[i];
            }
            remainigsideSum += nums[i];
        }
        return perimeter == 0 ? -1 : perimeter;
    }
}
