Q:- https://leetcode.com/problems/total-cost-to-hire-k-workers/
 Company Tags                - META
 ****************************************************************************************
  //Approach-1 : Using 2 Heaps 
  //T.C. :- O((k+m)⋅logm)
 ------------------------------------------------------------
  class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
         PriorityQueue<Integer> pq2 = new PriorityQueue<>();

         long ans = 0 ;
         int hired = 0;
          int i = 0, j = n-1;
         while(hired < k)
         {
            while(pq1.size() < candidates && i <= j)
            {
                pq1.add(costs[i]);
                i++;
            }
            while(pq2.size() < candidates && j >= i)
            {
                pq2.add(costs[j]);
                j--;
            }
            int min_heap1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int min_heap2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if(min_heap1 <= min_heap2)
            {
                ans += min_heap1;
                pq1.remove();
            }
            else
            {
                  ans += min_heap2;
                  pq2.remove();
            }
            hired++;
         }
         return ans;
    }
}
=====================================================================================================
//Approach-1 : Using 1 Heaps 
//T.C:-   O(mlogm)
---------------------------------------------------
  class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> costs[a] == costs[b] ? a-b: costs[a] - costs[b]
        );
         
         long ans = 0 ;
         
          int i = 0, j = n-1;

         while (i < candidates) {
            pq.add(i++);
        }
        while (j >= i && j + candidates >= n) {
            pq.add(j--);
        }
         while(k-- > 0)
         {
             int index = pq.poll();
             ans += costs[index];
             
             if(i > j)
                   continue;

              if(index < i)
                 {
                    pq.add(i++);
                 } 
                 else
                 {
                    pq.add(j--);
                 }    
            
         }
         return ans;
    }
}

  
