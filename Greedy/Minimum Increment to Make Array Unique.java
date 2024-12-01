Q:- https://leetcode.com/problems/minimum-increment-to-make-array-unique/
*****************************************************************************************
//Approach-1 (Using sorting)
//T.C : O(nlogn)
//S.C : O(1)
-------------------------------------------
  class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int moves = 0;
         for (int i = 1; i < n; i++) 
         {
            if (nums[i] <= nums[i - 1]) {
                moves += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }
        return moves;
    }
}
=========================================================================================
//Approach-2 (Using Counting Sort)
//T.C : O(n+maxVal)
//S.C : O(n+maxVal)
---------------------------------------------------------
  class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int maxElement = 0;
        int moves = 0;
        for(int num : nums)
        {
            maxElement = Math.max(maxElement,num);
        }
         int[] count = new int[n + maxElement];
         for(int val : nums)
         {
            count[val]++;
         }
           for (int i = 0; i < count.length; i++)
           {
                if(count[i] <= 1)
                {
                    continue;
                }
                int extra = count[i]-1 ;
                count[i+1] += extra;
                 count[i] = 1;
                  moves += extra;
           }
         return moves;
    }
}
