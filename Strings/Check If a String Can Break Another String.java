Q:- https://leetcode.com/problems/check-if-a-string-can-break-another-string/
*****************************************************************************************
  class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
           boolean ans=check(s1,s2) || check(s2,s1);
        return ans;
    }
      private boolean check(String s1,String s2){
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        for(int i=0;i<str1.length;i++){
            if(str1[i]>str2[i]){
                return false;
            }
        }
        return true;
    }
}
