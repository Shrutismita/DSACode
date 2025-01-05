Q:- https://leetcode.com/problems/find-k-th-smallest-pair-distance/
/******************************************************************************************************************************************/
//Approach-1 (storing the distances and finding the kth smallest)
//T.C : O(n^2)
//S.C : O(maxEl)
-----------------------------------------------------------------------
  class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int n = nums.length;
        int maxEl = Arrays.stream(nums).max().getAsInt();
        int[] vec = new int[maxEl + 1];
        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                int d = Math.abs(nums[i] - nums[j]);
                vec[d]++;
            }
        }
        for(int i = 0; i< maxEl; i++)
        {
             k -= vec[i];
            if (k <= 0) {
                return i; // Returning kth smallest distance
            }
        }
        return -1;
    }
}
==================================================================================================================
//Approach-2 (Binary Search + Sliding Window)
//T.C : O(nlogn + nlogM), where nlogn is for sorting nums and nlogM is becasue of binary search and sliding window
//S.C : O(1)
-----------------------------------------------------------------------------------------------
  class Solution {
     // Find count of pairs having distance <= D
    int slidingWindowCount(int[] nums, int D)
    {
         int count = 0;
         int n = nums.length;
         int i = 0; int j = 1;
         while(j < n)
         {
              while(nums[j]-nums[i] > D)
              {
                  i++;
              }
              count += j-i;
              j++;
         }
         return count;
    }
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n-1]-nums[0];
         int result = 0;
        while(l <= r)
        {
            int mid = l+(r-l)/2;
            int count = slidingWindowCount(nums,mid);
            if(count < k)
            {
                l = mid+1;
            }
            else
            {
                result = mid; // Store the mid as a potential result
                r = mid -1;
            }

        }
        
        return result;
    }
}
