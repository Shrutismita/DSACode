Q:- https://leetcode.com/problems/longest-increasing-subsequence/
************************************************************************************
//Approach- (Using concept of Patience Sorting (O(nlogn))
//T.C : O(nlogn)
//S.C : O(n)
--------------------------------------------------------------
  class Solution {
    
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;         
        List<Integer> sorted = new ArrayList<>();
          for (int i = 0; i < n; i++) {
            /*
                Why lower bound?
                We want an increasing subsequence, and hence
                we want to eliminate the duplicates as well.
                lower_bound returns the index of "next greater or equal to."
            */
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size())
                sorted.add(nums[i]); // greatest: so insert it
            else
                sorted.set(index, nums[i]); // replace
        }

        return sorted.size();
    }

    private int binarySearch(List<Integer> sorted, int target) {
        int left = 0, right = sorted.size();
        int result = sorted.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }
}
