Q:- https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/
Company Tags                : Microsoft, Adobe
***********************************************************************************************************
//Approach-1 (Sliding Window without extra space)
//T.C : O(n)
//S.C : O(1)
  // Trick for any problem involving circular array then we have to append one more time the array
  // then we have check 2*arrany length and taking the i and j we should do module of i and j
-------------------------------------------------------------------------------------------------
  class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        for(int i = 0 ; i < n; i++)
        {
            if(nums[i] == 1)
             countOnes++; 
        }
         int i = 0;
        int j = 0;
        int currCount = 0;
        int maxCount = 0;

        while (j < 2 * n) { // Circular Array
            if (nums[j % n] == 1) {
                currCount++;
            }

            if (j - i + 1 > countOnes) {
                currCount -= nums[i % n];
                i++;
            }

            maxCount = Math.max(maxCount, currCount);
            j++;
        }

        return countOnes - maxCount;
    }
}
