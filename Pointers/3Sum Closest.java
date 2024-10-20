Q:- https://leetcode.com/problems/3sum-closest/
 Company Tags                 : Facebook, Amazon, Microsoft, Oracle
*****************************************************************************************
//Approach-(Using Two Pointer)
//T.C:- O(n log n)
//S.C:- O(1)
-----------------------------------------------------
  class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int closestSum = Integer.MAX_VALUE;
        for(int i = 0; i < n-2; i++)
        {
             int l = i+1, r = n-1;
             while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if(Math.abs(target-sum) < Math.abs(target-closestSum)) {
                    closestSum = sum;
                }
                
                if(sum > target)
                    r--;
                else
                    l++;
            }
        }
        return closestSum;
    }
}
  
