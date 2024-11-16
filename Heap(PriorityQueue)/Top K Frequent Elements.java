Q:- https://leetcode.com/problems/top-k-frequent-elements/
Company Tags                :  Amazon, Accolite
****************************************************************************************
  //Approach-1 (Using min-heap) 
  //TC : O(nlog(k))
  -------------------------------------------------------------
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
             map.put(num, map.getOrDefault(num,0) + 1);

             int[] result = new int[k];

            
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return map.get(b)-map.get(a);
            }
        });

             for(int i : map.keySet())
                   pq.add(i);

                for(int i = 0 ; i < k; i++)
                {
                    result[i] = pq.poll();
                }   
                return result;
    }
}
