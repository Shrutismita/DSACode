Q:- https://leetcode.com/problems/dice-roll-simulation/
*************************************************************************
  class Solution {
    public static final long MOD = 1000000007;
    public int dieSimulator(int n, int[] rollMax) {
       long[][] counts = new long[6][];
        

        for (int i = 0; i < 6; i++)
        {
            counts[i] = new long[rollMax[i]];
            counts[i][0] = 1; //we can always use the length 1 sequence
        }

        //there are 6 valid sequences of length 1.
        long totalSeqsFromLastStep = 6;


        for (int step = 1; step < n; step++)
        {
            //keep a count of the sequences we've generated this step
            long totalSeqsFromThisStep = 0;

            for (int endsWith = 0; endsWith < 6; endsWith++)
            {
                long[] validSeqsWithSuffix = counts[endsWith];

                long totalOldSeqsWithSuffix = validSeqsWithSuffix[validSeqsWithSuffix.length - 1];
                for (int i = validSeqsWithSuffix.length - 1; i > 0; i--)
                {
                    long withSuffix = validSeqsWithSuffix[i - 1];
                    validSeqsWithSuffix[i] = withSuffix; 
                    
                    totalOldSeqsWithSuffix += withSuffix;
                    totalSeqsFromThisStep += withSuffix; 
                }

                long withSuffixSizeOne = (totalSeqsFromLastStep - totalOldSeqsWithSuffix + MOD) % MOD;
                validSeqsWithSuffix[0] = withSuffixSizeOne;
                totalSeqsFromThisStep += withSuffixSizeOne;
            }

            totalSeqsFromLastStep = totalSeqsFromThisStep % MOD;
        }

        return (int) totalSeqsFromLastStep;
    }
}
