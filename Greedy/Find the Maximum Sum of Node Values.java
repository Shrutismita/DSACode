Q:- https://leetcode.com/problems/find-the-maximum-sum-of-node-values/
Company Tags                : Google
**********************************************************************************************
//Approach-1 (Greedily picking nodes to xor)
//T.C : O(n)
//S.C : O(1)
--------------------------------------------------------
 class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int num : nums)
        {
            if((num ^ k ) > num)
            {
                count++;
                sum += (num^k);
            }
            else
            {
                sum += num;
            }

            minDiff = Math.min(minDiff,Math.abs(num - (num ^ k)));
        }
        if(count % 2 == 0)
              return sum;

        return sum-minDiff;      
    }
}
=================================================================================================================
 //Approach-2(Greedy  + Sorting)
//T.C : O(nlogn)
//S.C : O(n)
------------------------------------------------------
  class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
         List<Integer> minDiff = new ArrayList<>();
        long normalSum = 0;

        for (int num : nums) {
            minDiff.add((num ^ k) - num);
            normalSum += (long) num;
        }

        Collections.sort(minDiff, Collections.reverseOrder());

        for (int i = 0; i < minDiff.size() - 1; i += 2) {
            long pairSum = minDiff.get(i) + minDiff.get(i + 1);

            if (pairSum > 0) {
                normalSum += pairSum;
            }
        }
        return normalSum;
    }
}
