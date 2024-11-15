Q:- https://leetcode.com/problems/remove-stones-to-minimize-the-total/
  Company Tags                : Google, Miscrosoft, Netflix, Salesforce, Meta
************************************************************************************************
  //Time Complexity : O(n + k*log(n))
  ---------------------------------------------------------
  class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a,Integer b)
            {
                return b-a;
            }
        });
        int n = piles.length;
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            pq.add(piles[i]);
            sum += piles[i];
        }
        for(int i = 1; i <= k; i++)
        {
            int curr = pq.poll();
            int remove = curr / 2;
            sum -= remove;
            int remaining = curr - remove;

            pq.add(remaining);
        }
        return sum;
    }
}
