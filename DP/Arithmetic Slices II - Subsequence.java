Q:- https://leetcode.com/problems/arithmetic-slices-ii-subsequence/
********************************************************************************
//T.C : O(n^2)
//S.C : O(n^2) - because of the 2D array mp, where each row mp[i] represents a different index in the input array nums
-------------------------------------------------------------------------------------------
  class Solution {
   
    public int numberOfArithmeticSlices(int[] nums) {
       int n = nums.length;
        int result = 0;
        Map<Long, Integer>[] mp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            mp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count_at_j = mp[j].getOrDefault(diff, 0);

                result += count_at_j;
                
                // Increment the count at index i
                mp[i].put(diff, mp[i].getOrDefault(diff, 0) + count_at_j + 1);
            }
        }
        return result;
    }

}
========================================================================================
  //Approach-2 (Recursion  + Memo)
  ---------------------------------------
  class Solution {
     public int arr[];
    Map<String, Long> dp;
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        dp = new HashMap<>();
        long ans = 0;
        arr = nums;
        for(int i = 0; i < n ; i++){
            for(int j = i+1; j < n; j++){
                ans +=  findDiff(j, (long)nums[j]-nums[i]);
            }
        }
        return (int)ans;
    }
    public long findDiff(int ind, long diff){

        // base case
        if(ind == arr.length) return 0;
        String str = ind + "-" + diff;
        if(dp.containsKey(str)) return dp.get(str);
        long count = 0;
        for(int i = ind+1; i < arr.length; i++){
             if((long)arr[i]-arr[ind] == diff){
                 count += 1 + findDiff(i, diff);
             }
        }
        dp.put(str, count);
        return count;
    }
}
