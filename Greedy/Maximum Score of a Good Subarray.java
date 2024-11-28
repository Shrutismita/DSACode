Q:- https://leetcode.com/problems/maximum-score-of-a-good-subarray/
Company Tags                : AMAZON
**************************************************************************************
 //T.C :- O(n)
 ------------------------------------------
  class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int currMin = nums[k];
        int result = nums[k];

        while(i > 0 || j < n-1)
        {
            int leftValue = (i > 0) ? nums[i-1] : 0;
            int rightValue = j < n-1 ? nums[j+1] : 0;

            if(leftValue < rightValue)
            {
                j++;
                currMin = Math.min(currMin, nums[j]);
            }
            else
            {
                i--;
                currMin = Math.min(currMin, nums[i]);
            }
            result = Math.max(result, currMin * (j - i + 1));
        }
        return result;
    }
}
