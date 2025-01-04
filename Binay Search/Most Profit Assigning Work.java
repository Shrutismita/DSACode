Q:- https://leetcode.com/problems/most-profit-assigning-work/
 Comoany Tags                : Netease Games
***********************************************************************************************************
//Approach-1 (Using max-heap)
//T.C : O(nlogn + mlogn)
//S.C : O(n)
------------------------------------------------
  class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int n = difficulty.length;
        int m = worker.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
         for (int i = 0; i < n; i++) {
            int diff = difficulty[i];
            int prof = profit[i];

            pq.offer(new int[]{prof, diff});
        }

        // Sort worker array in descending order
        Arrays.sort(worker);
        for (int i = 0; i < worker.length / 2; i++) {
            int temp = worker[i];
            worker[i] = worker[worker.length - 1 - i];
            worker[worker.length - 1 - i] = temp;
        }

        int i = 0;
        int totalProfit = 0;
        while (i < m && !pq.isEmpty()) {
            if (pq.peek()[1] > worker[i]) {
                pq.poll();
            } else {
                totalProfit += pq.peek()[0];
                i++;
            }
        }

        return totalProfit;
    }
}
===========================================================================================================
//Approach-2 (Using Binary Search)
//T.C : O(nlogn)
//S.C : O(n)
----------------------------------------------------
  class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
         int n = difficulty.length;
        int m = worker.length;

        List<int[]> vec = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vec.add(new int[]{difficulty[i], profit[i]});
        }

        // Sort the vector based on difficulty
        Collections.sort(vec, (a, b) -> Integer.compare(a[0], b[0]));

        // Pre-processing to find the maximum profit till index i at constant time
        for (int i = 1; i < vec.size(); i++) {
            vec.get(i)[1] = Math.max(vec.get(i)[1], vec.get(i - 1)[1]);
        }

        int totalProfit = 0;
        for (int i = 0; i < m; i++) {
            int workerDiffLevel = worker[i];

            // Apply binary search on vec
            int l = 0, r = vec.size() - 1;
            int maxProfit = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (vec.get(mid)[0] <= workerDiffLevel) {
                    maxProfit = Math.max(maxProfit, vec.get(mid)[1]);
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

            totalProfit += maxProfit;
        }

        return totalProfit;
    }
}
