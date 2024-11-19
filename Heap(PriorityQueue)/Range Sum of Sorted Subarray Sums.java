Q:- https://leetcode.com/problems/range-sum-of-sorted-subarray-sums/
****************************************************************************
//Approach-1 (Brute Force)
//T.C : O(n^2 * logn) - we have total n^2 elements in temp
//S.C : O(n)
class Solution {
    private static final int M = (int)1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> temp = new ArrayList<>();
        
        // Generate all subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                temp.add(sum);
            }
        }

        // Sort the list of subarray sums
        Collections.sort(temp);

        // Calculate the sum of values from 'left' to 'right'
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + temp.get(i)) % M;
        }

        return result;
    }
}
=======================================================================================
  //Approach-2 (How to find sorted subarray sums using Heap)
//T.C : O(n^2 *n logn)
//S.C : O(n)
class Solution {
    private static final int M = (int)1e9 + 7;

    public int rangeSum(int[] nums, int n, int left, int right) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        // Initialize the priority queue with the initial subarray sums
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{nums[i], i});
        }

        int result = 0;

        for (int i = 1; i <= right; i++) {
            int[] current = pq.poll();

            // If the current index is within the desired range, add the value to the result
            if (i >= left) {
                result = (result + current[0]) % M;
            }

            // If index is less than the last index, increment it and add the new subarray sum to the queue
            if (current[1] < n - 1) {
                pq.add(new int[]{current[0] + nums[current[1] + 1], current[1] + 1});
            }
        }
        return result;
    }
}
