Q:- https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 Company Tags                : Uber
**********************************************************************************************************************
//Approach-1 (Using sliding window + heap)
//T.C : O(nlogn)
//S.C : O(n)
----------------------------------------------------------------------
  class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        PriorityQueue<int[]> maxEle = new PriorityQueue<>((a,b)-> b[0] - a[0]);
        PriorityQueue<int[]> minEle = new PriorityQueue<>((a,b)-> a[0] - b[0]);

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while(j < n)
        {
            maxEle.add(new int[]{nums[j],j});
            minEle.add(new int[]{nums[j],j});

            while(maxEle.peek()[0] - minEle.peek()[0] > limit)
            {
                  i = Math.min(maxEle.peek()[1] , minEle.peek()[1]) + 1;

                  while(maxEle.peek()[1] < i)
                  {
                    maxEle.poll();
                  }
                  while(minEle.peek()[1] < i)
                  {
                     minEle.poll();
                  }
            }
            maxLength = Math.max(maxLength, j - i +1);
            j++;
        }
        return maxLength;
    }
}
=============================================================================================================================
//Approach-2 (Using sliding window + TreeMap(which is contain Duplicate,Sorted and Delete element efficiently))
//T.C : O(nlogn)
//S.C : O(n)
-------------------------------------------------------------------------------------------------------------------
  class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
         TreeMap<Integer,Integer> mp = new TreeMap<>();

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while(j < n)
        {
           mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);

           while(mp.lastKey() - mp.firstKey() > limit)
           {
               mp.put(nums[i],mp.getOrDefault(nums[i],0) - 1);

               if(mp.get(nums[i]) == 0)
                   mp.remove(nums[i]);
                   
               i++;    
           }
           maxLength = Math.max(maxLength, j - i +1);
           j++;
        }
        return maxLength;
    }
}
