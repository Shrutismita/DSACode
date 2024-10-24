Q:- https://leetcode.com/problems/sum-of-even-numbers-after-queries/
  Company Tags                : Indeed (Frequently Asked)
 ***************************************************************************************
//Time complexity: O(n+m) , n = nums.length, m = queries.length
//Space complexity: O(m)
--------------------------------------------------------------------
  class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0; 
        for(int n : nums)
        {
            if(n%2 == 0)
            sum += n;
        }
         int m = queries.length;
        int[] ans = new int[m];
        for(int i = 0; i < m; i++){
            if(queries[i][0] % 2 == 0){
                if(nums[queries[i][1]] % 2 == 0){
                    sum += queries[i][0];
                }
            }else{
                if(nums[queries[i][1]] % 2 != 0){
                    sum += nums[queries[i][1]] + queries[i][0];
                }else{
                    sum -= nums[queries[i][1]];
                }
            }
            nums[queries[i][1]] += queries[i][0];
            ans[i] = sum;
        }
        return ans;
    }
}
