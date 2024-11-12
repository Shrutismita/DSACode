Q:- https://leetcode.com/problems/construct-k-palindrome-strings/
****************************************************************************
//Time complexity: O(n)
//Space complexity: O(1)
----------------------------------------------------------
  class Solution {
    public boolean canConstruct(String s, int k) {
        int[] count = new int[26];
        if(s.length() < k)
              return false;

         for(char ch : s.toCharArray())
               count[ch - 'a']++;

          int distinctCharCount = 0;
          for(int i = 0; i < 26; i++)
          {
            if(count[i] != 0 && count[i] % 2 != 0)
            {
                distinctCharCount++;
                if(distinctCharCount > k)
                      return false;
            }
          }
          return true;       
    }
}
