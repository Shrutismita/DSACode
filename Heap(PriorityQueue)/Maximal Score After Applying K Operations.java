Q:- https://leetcode.com/problems/maximal-score-after-applying-k-operations/
**************************************************************************************
//Approach (standard heap approach)
//T.C : O(nlogn + klogn)
//S.C : O(k)
----------------------------------------------------------
  class Solution {
    public long maxKelements(int[] nums, int k) {
        long sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums)
        {
            pq.add(num);
        }
        while(k-- > 0)
        {
            int maxEl = pq.poll();
            sum += maxEl;

            // Add back the updated element
            maxEl = (int) Math.ceil(maxEl / 3.0);
            pq.add(maxEl);
        }
        return sum;
    }
}
