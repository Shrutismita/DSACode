Q:- https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/
*********************************************************************************************
  T.C.- O(n)
  --------------------
  class Solution {
    public int maximumSum(int[] arr) {
          
        int ans=arr[0];
        int n = arr.length;

        int deleted[] = new int[n];
        deleted[0] = 0;
        int notDeleted[] = new int[n];
        notDeleted[0] = arr[0];

        for(int i=1;i<arr.length;i++){
       
            int deleteCurrent = notDeleted[i-1];
            int addCurrentToPreviouslyDeleted = deleted[i-1] + arr[i];
            deleted[i] = Math.max(deleteCurrent,addCurrentToPreviouslyDeleted);

            int currTotalSum = notDeleted[i-1] + arr[i];
            int startNewSubArray = arr[i];
            notDeleted[i] = Math.max(currTotalSum,startNewSubArray);

            ans=Math.max(ans,Math.max(deleted[i],notDeleted[i]));
        }
        return ans;
    }                                            
}
