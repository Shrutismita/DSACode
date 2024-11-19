Q:- https://leetcode.com/problems/k-th-smallest-prime-fraction/
  Company Tags                : Pony.ai
 ************************************************************************************
//Approach-1 (Using simple Heap solution as it's asking for kth smallest)
//T.C : O(n^2 * log(k))
//S.C : O(k)
------------------------------------------------
  class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[0],a[0]));

        for(int i = 0 ; i < n; i++)
        {
            for(int j = i+1; j < n; j++)
            {
                double div = (double) arr[i] / arr[j];
                pq.add(new double[]{div, (double) arr[i], (double) arr[j]});

                if(pq.size() > k)
                    pq.poll();
            }
        }
        double[] temp = pq.peek();
        int[] result = new int[2];
        result[0] = (int) temp[1];
        result[1] = (int) temp[2];

        return result;
    }
}
================================================================================================
//Approach-2 (Optimising Approach-1)
//T.C : O((n+k)logn)
//S.C : O(n)
------------------------------------------------------------
  class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
       int n = arr.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0]));

        for (int i = 0; i < n; i++)
            pq.offer(new double[]{1.0 * arr[i] / arr[n - 1], (double) i, (double) (n - 1)});

        int smallest = 1;

        while (smallest < k) {
            double[] vec = pq.poll();

            int i = (int) vec[1];
            int j = (int) vec[2] - 1;

            pq.offer(new double[]{1.0 * arr[i] / arr[j], (double) i, (double) j});
            smallest++;
        }

        double[] vec = pq.peek();
        int i = (int) vec[1];
        int j = (int) vec[2];
        return new int[]{arr[i], arr[j]};
    }
}
