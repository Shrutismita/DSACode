Q:- https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/
*********************************************************************************
Time complexity: O(n^2)
Space complexity: O(n^2)
---------------------------------------------------------
  class Solution {
    public int lenLongestFibSubseq(int[] arr) {
       //taking 2 dimension dp here because the rows will represent the no of elements we are using
        //columns respresent the current final element / sum that we are considering
        int dp[][] = new int[arr.length][arr.length];
        // HashMap<Integer, Integer> hm = new HashMap<>(); 
        int result = 0;
        for(int curr = 2; curr<arr.length; curr++){
            int leftptr = 0;
            int rightptr = curr-1;
            //here curr is the current final element till which we are finding the fibonacci sequence
            //left and right pointer point to the elements that come before current element
            while(leftptr<rightptr){
                if(arr[leftptr]+arr[rightptr] == arr[curr]){

                    //if sum becomes equal to current element then dp[rightptr][curr] -> using elements till rightptr what will be the 
                    //max length of fibonacci sequenct that will yield sum as current element
                    //which = dp[leftptr][rightptr] + 1 -> this represents elements till leftptr & rightptr is the current sum
                    //eg : [1,2,3,4,5,6,7,8] -> dp[5][8] = dp[3][5]+1
                    dp[rightptr][curr] = dp[leftptr][rightptr]+1;
                    result  = (int)Math.max(dp[rightptr][curr], result);
                    leftptr++;
                    rightptr--;
                }else if(arr[leftptr]+arr[rightptr] < arr[curr]){
                    leftptr++;
                }
                else{
                    rightptr--;
                }
            }

        }
        if(result != 0)
            return result+2;
        return 0;
    }
}
