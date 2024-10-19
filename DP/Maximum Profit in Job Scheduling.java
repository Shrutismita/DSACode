Q:- https://leetcode.com/problems/maximum-profit-in-job-scheduling/
*****************************************************************************************************
//Approach-1 (Recur + Memo)
//T.C : O(nlogn), where n is the number of jobs
//S.C : O(n), where n is the number of jobs.
----------------------------------------------------------------
  class Solution {
      private int[] memo;
      private int n;

      // Find the first job whose starting point >= currentJob's end point
     int getNextIndex(int[][] array, int l, int currentJobEnd) 
     {
        int r = n - 1;
        int result = n + 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (array[mid][0] >= currentJobEnd) { // we can take this task
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
    int solve(int[][] array, int i)
    {
         if (i >= n)
            return 0;

        if (memo[i] != -1)
            return memo[i];

        int next = getNextIndex(array, i + 1, array[i][1]);
        int taken = array[i][2] + solve(array, next);
        int notTaken = solve(array, i + 1);

        return memo[i] = Math.max(taken, notTaken);    

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        n = startTime.length;
        memo = new int[n];
        Arrays.fill(memo,-1);
         int[][] array = new int[n][3]; // {s, e, p}
         for(int i = 0; i < n;i++)
         {
            array[i][0] = startTime[i];
            array[i][1] = endTime[i];
            array[i][2] = profit[i];
         }
         Arrays.sort(array,Comparator.comparingInt(a -> a[0]));
          return solve(array, 0);
    }
}
==========================================================================================================
//Approach-2 (Bttom Up) - Video coming soon
//T.C :  O(nlogn), where n is the number of jobs
//S.C : O(n)
--------------------------------------------------------------------
  class Solution {
    int binarySearch(int[][] jobs, int end, int left, int right) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= end) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
         int n = startTime.length;
          int[][] jobs = new int[n][3];
         for(int i = 0; i < n;i++)
         {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
         }
         Arrays.sort(jobs,Comparator.comparingInt(a -> a[1]));
          int[] dp = new int[n];
          dp[0] = jobs[0][2];
           for (int i = 1; i < n; i++) {
            int prev = 0;
            int lastJobIndex = binarySearch(jobs, jobs[i][0], 0, i - 1);

            if (lastJobIndex != -1) {
                prev = dp[lastJobIndex];
            }

            dp[i] = Math.max(prev + jobs[i][2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}
  
