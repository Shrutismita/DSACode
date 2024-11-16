Q:- https://leetcode.com/problems/last-stone-weight/
 Company Tags                : Google, Amazon
 *****************************************************************************************************
  //Approach- (Using Heap)
  //TC : (nlog(n))
  -----------------------------------------------------------
  class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
       
        for(Integer stone : stones)
             pq.add(stone);

           while(pq.size() > 1)
           {
            int a = pq.poll();
            int b = pq.poll();
            if(a != b)
              pq.add(a-b);
           }  

         return pq.isEmpty() ? 0: pq.poll();  
    }
}
