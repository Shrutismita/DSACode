Q:- https://leetcode.com/problems/shortest-common-supersequence/
***************************************************************************
  class Solution {
    public String shortestCommonSupersequence(String s, String t) {
   int idx1=s.length();
        int idx2=t.length();
        int[][]dp=new int[idx1+1][idx2+1];
        
        //Tabulation
        for(int i=0;i<=idx1;i++) dp[i][0]=0;
        for(int j=0;j<=idx2;j++) dp[0][j]=0;

        for(int i=1;i<=idx1;i++){
            for(int j=1;j<=idx2;j++){
                if(s.charAt(i-1)==t.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        String ans="";
        int i=idx1,j=idx2;
        while (i>0 && j>0){
            if(s.charAt(i-1)==t.charAt(j-1)){
                ans+=s.charAt(i-1);
                i--;j--;
            }else if(dp[i-1][j]>dp[i][j-1]){
                ans+= s.charAt(i-1);
                i--;
            }else {
                ans+=t.charAt(j-1);
                j--;
            }
        }
        while (i>0){
            ans+=s.charAt(i-1);i--;
        }
        while (j>0){
            ans+=t.charAt(j-1);j--;
        }
        return reverse(ans);
    }

    //Memoization
    public int findRecur(int idx1,int idx2,String s,String t,int[][]dp){
        if(idx1<0 || idx2<0){
            return 0;
        }
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        if(s.charAt(idx1)==t.charAt(idx2)){
            return dp[idx1][idx2]=1+findRecur(idx1-1,idx2-1,s,t,dp);
        }
        return dp[idx1][idx2]=Math.max(findRecur(idx1-1,idx2,s,t,dp),findRecur(idx1,idx2-1,s,t,dp));
    }
    public String reverse(String s){
        int left=0,right=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(left<right){
            char ch=sb.charAt(left);
            sb.setCharAt(left,sb.charAt(right));
            sb.setCharAt(right,ch);
            left++;right--;
        }
        return sb.toString(); 
    }
}
