Q:- https://leetcode.com/problems/maximum-subsequence-score/
 Company Tags                : Amazon
***************************************************************************************
//Approach- (Using Priority Queue + Sorting)
//Time complexity: O(n∗log(n))
//Space complexity: O(n)
--------------------------------------------------------------------
  class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        var n = nums1.length;
    var arr = new int[n][2];

    for (var i=0; i<n; i++)
      arr[i] = new int[] {nums1[i], nums2[i]};

    Arrays.sort(arr, (a, b) -> Integer.compare(b[1], a[1]));

    long result = 0, kSum = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

    for (var i=0; i<n; i++) 
    {

      heap.add(arr[i][0]);
      kSum += arr[i][0];

      if (i >= k)
        kSum -= heap.poll();
      
      if (i >= k-1)
        result = Math.max(result, kSum * arr[i][1]);
    }
    return result;
  }
}
