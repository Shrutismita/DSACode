Q:- https://leetcode.com/problems/k-concatenation-maximum-sum
*****************************************************************************
  S.C- O(n)
  T.C:- O(n)
  -----------------
  class Solution {
    public static int m = 1000000007;

public long kadane(int[] nums){
    long maxSum = 0, currSum = 0;
    for(int i = 0; i<nums.length; ++i){
        currSum = Math.max(nums[i], currSum + nums[i]);
        maxSum = Math.max(currSum, maxSum);
    }
    return maxSum;
}
public int kConcatenationMaxSum(int[] arr, int k) {
        if (k == 1) {// if k == 1 then return maximum sum of given array
            return (int)kadane(arr);
        }

        int[] twice = new int[arr.length * 2];//make a array which contains all the elements of given array twice
        long total = 0;// for sum of all elements of given array

        for (int i = 0; i < arr.length; i++) {
            total += arr[i];//add each element to current sum so that we can get total of array
            twice[i] = twice[i + arr.length] = arr[i];
        }

        if (total < 0)
            return (int)(kadane(twice) % m);
        return (int)((kadane(twice) + (k - 2l) * total) % m);
}
}
