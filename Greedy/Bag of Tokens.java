Q:- https://leetcode.com/problems/bag-of-tokens/
 Company Tags                : Google
 *****************************************************************************************************8
//T.C : O(nlogn)
//S.C : O(1)
-------------------------------------------------------------------
  class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
         int n = tokens.length;
         Arrays.sort(tokens);

        int currScore = 0;
        int maxScore = 0;
        int l = 0, r = n - 1;

        // GREEDY
        // While losing power, I will choose the smallest token
        // While gaining power, I will choose the largest token

        while (l <= r) {
            if (power >= tokens[l]) {
                currScore++;
                maxScore = Math.max(maxScore, currScore); // keep updating it
                power -= tokens[l]; // choose smallest token
                l++;

            } else if (currScore >= 1) {
                currScore--;
                power += tokens[r]; // choose largest token
                r--;

            } else {
                // no way further to increase score
                return maxScore;
            }
        }
        return maxScore;
    }
}
