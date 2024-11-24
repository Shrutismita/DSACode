Q:- 1493. https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
Company Tags                : Google, Meta
======================================================================================================
//T.C:- O(n)
----------------------    
class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int last_zero_Index = -1;
        int maxLen = 0, i = 0, j = 0;
        while(j < n)
        {
            if(nums[j] == 0)
            {
                i = last_zero_Index + 1;
                last_zero_Index = j;
            }
            maxLen = Math.max(maxLen, (j - i));
            j++;
        }
        return maxLen; 
    }
}
