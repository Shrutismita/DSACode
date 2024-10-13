Q:- https://leetcode.com/problems/longest-string-chain/

  /*
  NOTE - Since this problem is a variant of LIS (only difference is that we can pick the element/word in any order)
  So we sort the input in ascending order of their length to get the longest string chain as per condition.
  Also, since it's variant of LIS, it can be solved using all those methods by which LIS could be solved.
*/
*****************************************************************************************************************
//Approach-1 (Using Simple LIS recursion+memo: Top Down) - We sort it in the beginning to get words ordered in ascending order based on length
//T.C : O(n*n*n)
 ------------------------------------------------------------------------------
  class Solution {
    int n;
    int[][] dp = new int[1001][1001];

    boolean checkPredecessor(String prev, String curr) {
        int M = prev.length();
        int N = curr.length();

        if (M >= N || N - M != 1)
            return false;

        int i = 0, j = 0;
        while (i < M && j < N) {
            if (prev.charAt(i) == curr.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == M;
    }

    int lis(String[] words, int prevIdx, int currIdx) {
        if (currIdx == n)
            return 0;

        if (prevIdx != -1 && dp[prevIdx][currIdx] != -1)
            return dp[prevIdx][currIdx];

        int taken = 0;
        if (prevIdx == -1 || checkPredecessor(words[prevIdx], words[currIdx]))
            taken = 1 + lis(words, currIdx, currIdx + 1);

        int notTaken = lis(words, prevIdx, currIdx + 1);

        if (prevIdx != -1)
            dp[prevIdx][currIdx] = Math.max(taken, notTaken);

        return Math.max(taken, notTaken);
    }

    int longestStrChain(String[] words) {
        for(int i = 0; i < 1000; i++) {
            for(int j = 0; j < 1000; j++) {
                dp[i][j] = -1;
            }
        }
        
        n = words.length;
         Arrays.sort(words, (a,b)-> a.length()-b.length()); // You can select pairs in any order.
        return lis(words, -1, 0);
    }
}
=======================================================================================================================
//Approach-2 (Using Simple LIS Bottom Up) - We sort it in the beginning to get words ordered in ascending order based on length
//T.C : O(n*n*n)
------------------------------------------------------------------------------
  class Solution {
    boolean checkPredecessor(String prev, String curr)
    {
        int M = prev.length();
        int N = curr.length();

        if(M >= N || N-M != 1)
               return false;

         int i = 0, j = 0;
        while(i < M && j < N)  
        {
            if(prev.charAt(i) == curr.charAt(j))
            {
                i++;
            }
            j++;
        }
        return i == M;
    }
    int longestStrChain(String[] words) {
        int n = words.length;
         Arrays.sort(words, (a,b)-> a.length()-b.length()); // You can select pairs in any order.
        int[] dp = new int[n];
        Arrays.fill(dp,1);
         int maxLIS = 1;
                    
         for(int i = 0; i < n; i++)
         {
            for(int j = 0; j < i; j++)
            {
                  if (checkPredecessor(words[j], words[i]))
                  {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    maxLIS = Math.max(maxLIS,dp[i]);
                  }
            }
         }

        return maxLIS;
    }
}
