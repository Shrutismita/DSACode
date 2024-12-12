Q:- https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/
 Company Tags                : GOOGLE
******************************************************************************************************
//Time complexity: O(n^2)
//Space complexity: O(n^2)
//Note: pascal triangle is taking O(n^2) space & time. otherwise other operation takes O(n), visiting each node once.
----------------------------------------------------------------------------------------------------------
  class Solution {
    long mod = (long) 1e9+7;
     long[][] PT;
      long solve( List<Integer> nums)
      {
            int m = nums.size();
        
        if(m < 3)
            return 1;
          int root = nums.get(0);
        List<Integer> left = new ArrayList();
        List<Integer> right = new ArrayList();
        // int[] left = new int[m];
        // int[] right = new int[m];
        
        // int root = nums[0];
        for (int n : nums) {
            if (n < root)
                left.add(n);
            else if (n > root)
                right.add(n);
        }
        
        long leftways  = solve(left)  % mod;
        long rightways = solve(right) % mod;
        
        return (((leftways * rightways)%mod) * PT[m-1][left.size()]) % mod;
      }
    public int numOfWays(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
          
        for (int num : nums)
            arr.add(num);
         // Yang Hui (Pascle) triangle
        // 4C2 = triangle[4][2] = 6
        PT = new long[n+1][n+1];
        for(int i = 0; i <= n; i++) {
            
            PT[i][0] = PT[i][i]=1;
            
            for(int j = 1; j < i; j++) {
                PT[i][j] = (PT[i-1][j-1] + PT[i-1][j]) % mod;
            }
        }
        return (int)((solve(arr)-1) % mod);
    }
}
