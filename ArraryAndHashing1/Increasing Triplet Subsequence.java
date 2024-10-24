Q:- https://leetcode.com/problems/increasing-triplet-subsequence/
 Company Tags : Facebook, Amazon, FactSet, Walmart
************************************************************************************
//TimeComplexity : O(n) 
//SpaceComplexity : O(1)
------------------------------------------------------------
  class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        
        int num1 = Integer.MAX_VALUE;
        int num2 = Integer.MAX_VALUE;

        for(int i = 0; i< n; i++)
        {
            int num3 = nums[i];
            if(num3 <= num1) //ask num1
            {
                num1 = num3;
            }
            else if(num3 <= num2) ////ask num2
            {
                num2 = num3;
            }
            else
            {//num1 < num2 < num3
                return true;
            }
        }
        return false;
    }
}
