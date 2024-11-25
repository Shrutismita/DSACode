Q:- https://leetcode.com/problems/gas-station/
 Company Tags                : Google, Amazon, Uber, Microsoft, FactSet, Morgan Stanley, Zoho, Flipkart
 ****************************************************************************************************************
//Time complexity:- O(n), as we only iterate through gas and cost once.
//Space complexity:- O(1)
------------------------------------------------------------------------
  class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
         int n = gas.length;

        int sum = 0;

        // check if roundtrip is feasible
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0)
            return -1;

          // find the starting station
        int total = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                result = i + 1;
                total = 0;
            }
        }

        return result;
    }
}
