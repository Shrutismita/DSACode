Q:- https://leetcode.com/problems/apply-operations-to-maximize-frequency-score/
***********************************************************************************************************
//T.C : O(n * log(n))
//S.C : O(n)
-------------------------------------------------------------
  class Solution {
    private boolean isPossible(int len, int[] nums, long[] prefix, long k, int n) {
        if (len == 0)
            return false;

        int i = 0;
        int j = len - 1;

        while (j < n) {
            long targetIdx = (i + j) / 2;
            long target = nums[(int) targetIdx];

            long operationsLeft;
            long operationsRight;

            if (targetIdx == 0) {
                operationsLeft = 0;
            } else {
                operationsLeft = Math.abs(((targetIdx - i) * target)
                        - (prefix[(int) targetIdx - 1] - (i > 0 ? prefix[i - 1] : 0)));
            }

            operationsRight = Math.abs(((j - targetIdx) * target) - (prefix[j] - prefix[(int) targetIdx]));

            if (operationsRight + operationsLeft <= k) {
                return true;
            }

            i++;
            j++;
        }

        return false;
    }

    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefix = new long[n];
        prefix[0]=nums[0];
        for(int i = 1; i < n; i++)
            prefix[i] = prefix[i-1]+nums[i];

        int minScore = 1;
        int maxScore = n;
        int resultScore = 1;
        while(minScore <= maxScore)
        {
            int mid = (minScore + maxScore)/2;
            if(isPossible(mid, nums, prefix, k, n))
            {
                resultScore = mid;
                minScore = mid + 1;
            } else {
                maxScore = mid - 1;
            }
        }
        return resultScore;
    }
}
