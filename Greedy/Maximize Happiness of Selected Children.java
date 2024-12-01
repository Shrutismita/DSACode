Q:- https://leetcode.com/problems/maximize-happiness-of-selected-children/
 Company Tags                : Amazon
*********************************************************************************************
//Approach-1 (Using Sorting + Greedy)
//T.C : O(nlogn)
//S.C : O(1)
---------------------------------------------------------
  class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
         reverseArray(happiness);

         long result = 0;
         int count = 0;

         for(int i = 0; i < k; i++)
         {
             result += Math.max(happiness[i] - count, 0);
             count++;
         }
          return result;
    }
    private void reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) 
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
==========================================================================================================
//Approach-2 (Using Max Heap + Greedy)
//T.C : O(nlogn)
//S.C : O(n)
------------------------------------------------------
  class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
         long result = 0;
         int count = 0;

         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
         for(int happy :happiness)
         {
            pq.add(happy);
         }
         for(int i = 0; i < k; i++)
         {
            int haapy = pq.poll();
             result += Math.max(haapy - count, 0);
             count++;
         }
          return result;
    }
}
