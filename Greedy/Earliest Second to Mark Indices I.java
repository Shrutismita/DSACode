Q:- https://leetcode.com/problems/earliest-second-to-mark-indices-i/
**********************************************************************************************
//Approach-1 (Replace main for loop with Binary Search on answer (time))
//T.C : O(log(m) * (m + nlogn)
//S.C : O(n)
-----------------------------------------------------------------------------
  class Solution {
    private int m, n;
        private boolean isValid(int seconds, int[] changeIndices, int[] nums) {
        int[] lastPosition = new int[n + 1];
        Arrays.fill(lastPosition, -1);

        for (int i = 0; i <= seconds; i++) {
            int idx = changeIndices[i];
            lastPosition[idx] = i;
        }

        for (int i = 1; i <= n; i++) {
            if (lastPosition[i] == -1) {
                // index i was not there in the range till seconds
                return false;
            }
        }

        TreeMap<Integer, Integer> positionIndexMap = new TreeMap<>();
        for (int i = 1; i <= n; i++) {
            int position = lastPosition[i];
            positionIndexMap.put(position, i);
        }

        int usedTill = 0;
        for (Map.Entry<Integer, Integer> entry : positionIndexMap.entrySet()) {
            int position = entry.getKey();
            int index = entry.getValue();
            int req = 1 + nums[index - 1]; // +1 is for marking it when it becomes 0
            if (usedTill + req > position + 1) {
                return false;
            }

            usedTill += req;
        }

        return true;
    }

    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
         m = changeIndices.length;
        n = nums.length;

        int timeLeft = 0;
        int timeRight = m - 1;
        int result = -1;

        while (timeLeft <= timeRight) {
            int timeMid = timeLeft + (timeRight - timeLeft) / 2;

            if (isValid(timeMid, changeIndices, nums)) {
                result = timeMid + 1;
                timeRight = timeMid - 1;
            } else {
                timeLeft = timeMid + 1;
            }
        }

        return result;
    }
}
