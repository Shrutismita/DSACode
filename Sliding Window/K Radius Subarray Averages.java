Q:- https://leetcode.com/problems/k-radius-subarray-averages/
Company Tags                : AMAZON
*********************************************************************************************
 ////My Approach-1 using Prefix Array is in Array/Cumulative_Sum(Prefix Array) folder Folde 
 //Approach-2 : Using Sliding Window 
 ---------------------------------------------
  class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        if(k == 0)
             return nums;

         int[] result = new int[n];
         Arrays.fill(result,-1);

         if(n < 2*k+1)
            return result;
 
          long windowSum = 0;
          int left = 0;
          int right = 2*k;
          int i     = k;

          for(int j = left; j <= right; j++)
          {
             windowSum += nums[j];
          }
            result[i] = (int) (windowSum/(2*k+1));
        
             i++;
             right++; //Shifting window
              while(right < n)
              {
                  int out_of_window  = nums[left];
                  int came_to_window = nums[right];
                  windowSum = windowSum - out_of_window + came_to_window;
            
                   result[i] = (int) (windowSum/(2*k+1));
                    i++;
                    left++;
                    right++;
              }
        return result;   
    }
}
