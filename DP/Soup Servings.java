Q:- https://leetcode.com/problems/soup-servings/
*******************************************************************
  class Solution {
     private static double solve(int a, int b, double[][] dp) {
        if (a <= 0 && b <= 0) {
            // Base case: both A and B are empty
            return 0.5;
        }
        if (a <= 0) {
            // Base case: A is empty
            return 1.0;
        }
        if (b <= 0) {
            // Base case: B is empty
            return 0.0;
        }

        if (dp[a][b] != -1) {
            // If the probability for this state has been calculated, return it
            return dp[a][b];
        }

        // Calculate the probability of each operation and add them up
        double probability = 0.25 * (
                solve(a - 4, b, dp) +
                solve(a - 3, b - 1, dp) +
                solve(a - 2, b - 2, dp) +
                solve(a - 1, b - 3, dp)
        );

        // Store the probability in the DP table
        dp[a][b] = probability;
        return probability;
    }
    public double soupServings(int n) {
         // Divide the input by 25 to simplify calculations
        // Each operation will now serve 4 units (100 / 25 = 4)
        n = (n + 24) / 25;

        // If n is large, the probability of A becoming empty first will be very close to 1
        if (n >= 500) {
            return 1.0;
        }

        // Create a 2D array to store the probabilities
        double[][] dp = new double[n + 1][n + 1];
        for (double[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Helper function to calculate the probability recursively
        return solve(n, n, dp);
    }
}
