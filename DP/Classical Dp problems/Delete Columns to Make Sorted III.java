Q:- https://leetcode.com/problems/delete-columns-to-make-sorted-iii/
*****************************************************************************
  class Solution {
    public int minDeletionSize(String[] strs) {
       int n = strs.length;
    int m = strs[0].length();
    int[] dp = new int[m];
    
    int overallMax = 0;
    for(int i=0;i<m;i++){
        dp[i] = 1;
        for(int j=0;j<i;j++){
            
            if(isValid(strs,i,j)){
                dp[i] = Math.max(dp[i],dp[j]+1);
            }
            
        }
        overallMax = Math.max(dp[i],overallMax);
    }
    
    return m-overallMax;
}

private boolean isValid(String[] strs ,int i,int j){
    for(int k=0;k<strs.length;k++){
        if(strs[k].charAt(j)>strs[k].charAt(i))
            return false;
    }
    return true;
}
}
