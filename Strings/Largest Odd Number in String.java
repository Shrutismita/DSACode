Q:- https://leetcode.com/problems/largest-odd-number-in-string/
*****************************************************************************
//Time complexity: O(n), where n is the length of the string. We traverse the string once from right to left.
Space complexity: O(1)
------------------------------------------------------------------------------
  class Solution {
    public String largestOddNumber(String num) {
        for(int i = num.length() - 1; i >= 0; i--)
        {
             int s = num.charAt(i) + 0;
             if((s % 2) != 0)
             {
                return num.substring(0, i + 1);
             }
        }
        return "";
    }
}
