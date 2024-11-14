Q:- https://leetcode.com/problems/buddy-strings/
Company Tags   : GOOGLE, META
***************************************************************************************************
 //Time complexity: O(n)
//Space complexity: O(1) 
-----------------------------------------------------------
  class Solution {
    public boolean buddyStrings(String s, String goal) {
        int m = s.length();
        int n = goal.length();
        int count = 0;
        if(m != n)
             return false;

         for(int i = 0 ; i < m; i++)
         {
            if(s.charAt(i) != goal.charAt(i))
                 count++;
         }    
         int[] freq1 = new int[26];
         int[] freq2 = new int[26];

         for(char ch: s.toCharArray())
         {
            freq1[ch - 'a']++;
         }
         for(char ch: goal.toCharArray())
         {
            freq2[ch - 'a']++;
         }
         if(count > 2)
             return false;

         for(int i = 0; i < 26; i++)
         {
            if(freq1[i] != freq2[i])
                  return false;
         }  
         if(count == 2)
             return true;

         for(int i = 0; i < 26; i++)
         {
            if(freq1[i] >= 2)
               return true;
         }      

         return false;
    }
}
