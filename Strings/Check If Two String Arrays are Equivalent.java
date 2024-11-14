Q:- https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
****************************************************************************************
//Approach- (Simple concatenation)
//T.C : O(n*k) - n and m = length of word1 and word2 respectively
//S.C : O(n+k)
----------------------------------------------------------------------------
  class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(String wd : word1)
           sb1.append(wd);

        for(String wd : word2)
             sb2.append(wd);

          return sb1.toString().equals(sb2.toString());      
    }
}
