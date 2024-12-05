Q:- https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/
***********************************************************************************************************8
//Approach-1 (Classic sliding window)
//T.C : O(n)
//S.C : O(1)
--------------------------------------------------------
  class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxE = 0;
        int i = 0 , j = 0;
        long result = 0;
        int countMax = 0;
        for(int num : nums)
             maxE = Math.max(maxE,num);

        while(j < n)
        {
            if (nums[j] == maxE) {
                countMax++;
            }

            while (countMax >= k) {
                result += n - j;

                if (nums[i] == maxE) {
                    countMax--;
                }
                i++;
            }
            j++;
        }
        return result;
    }
}
===============================================================================================================
//Approach-2 (Without Sliding Window)
//T.C : O(n)
//S.C : O(n)
-------------------------------------------------------
  class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxE = 0;
        long result = 0;
      
        for(int num : nums)
             maxE = Math.max(maxE,num);

          List<Integer> maxIndices = new ArrayList<>();

          for(int i = 0; i < n; i++)
          {
             if(nums[i] == maxE)
             {
                 maxIndices.add(i);
             }
             int size = maxIndices.size();
             if(size >= k)
             {
                int last_index = maxIndices.get(size - k);
                result += last_index + 1;
             }
          }
       
        return result;
    }
}
