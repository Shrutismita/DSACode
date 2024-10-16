Q:- https://leetcode.com/problems/russian-doll-envelopes/
****************************************************************************
  Time Complexity:- O(nlogn)
  ---------------------------------
  class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) 
        {
             return 0;
        }
         //sort envelopes by width (envelopes[i][0]), then we only need to consider height
          Arrays.sort(envelopes, (a, b) -> {
                if (a[0] == b[0]) {
                     return b[1] - a[1];
                }
                else {
                     return a[0] - b[0];
                }
            });
               int n = envelopes.length;
               int[] tails = new int[n];
               int result = 0; 
             for (int[] envelope : envelopes) 
             {
                int left = 0, right = result;
             while (left < right) 
            {
            int mid = left + (right - left) / 2;
            if (tails[mid] < envelope[1]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }
         //update tails of current subsequence with length of left + 1
        tails[left] = envelope[1];
        //if updated subsequence is the longest one, increase result size by 1
        if (left == result) {
            result++;
        }
    }
    return result;

    }
}
