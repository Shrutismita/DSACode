Q:- https://leetcode.com/problems/break-a-palindrome/
 Company Tags                : Amazon, Google(with some variation)
 **************************************************************************************
  class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if(n == 1) return "";
         char[] ch = palindrome.toCharArray();
        for(int i = 0; i < n/2; i++)
        {
            if(ch[i] != 'a')
            {
                ch[i] = 'a';
                return String.valueOf(ch);
            }
        }
        ch[n-1] = 'b';
        return String.valueOf(ch);
    }
}
