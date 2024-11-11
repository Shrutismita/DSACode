Q:- https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/
***************************************************************************************
 //TimeComplexcity: O(n)
 //SpaceComplexcity: O(1) 
 -------------------------------------
  class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        int first = strToNum(firstWord);
        int second = strToNum(secondWord);
        int target = strToNum(targetWord);

        if(first + second == target)
        {
            return true;
        }
        return false;
    }
    int strToNum(String word)
    {
        int val = 0;
        for(char ch : word.toCharArray())
        {
            val = val * 10 + (ch - 'a');
        }
        return val;
    }
}
