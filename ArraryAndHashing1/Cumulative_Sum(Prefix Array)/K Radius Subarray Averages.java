Q:- https://leetcode.com/problems/k-radius-subarray-averages/
 Company Tags                : AMAZON
************************************************************************************************************
//My Approach-2 is in Sliding Window Folder 
  
//Approach-1 (Using Prefix Array)
//T.C:- O(n) 
//S.C:- O(n)
==============================================================================
  class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if(k == 0)
             return nums;

         int[] result = new int[n];
         Arrays.fill(result,-1);

         if(n < 2*k+1)
            return result;

           long[] prefixSum = new long[n+1];
            prefixSum[0] = nums[0];

            for(int i= 0 ; i < n;i++)
                  prefixSum[i+1] = prefixSum[i]+nums[i];

             for(int i = k ; i < n-k; i++)
             {
                int left_idx = i - k;
                int right_idx = i + k +1;
                long sum = prefixSum[right_idx] - prefixSum[left_idx];                
                int avg =(int) (sum/(k*2+1));
                result[i] = avg;
             }  
             return result;   
    }
}
