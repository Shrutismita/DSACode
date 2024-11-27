Q:- https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/
 Company Tags                : MICROSOFT
***************************************************************************************************************
//Approach-1 (Without using =set)
//T.C : O(n) we don't visit any character more than once and sorting freq is O(26log26) = O(1)
//S.C : O(1) - Note that freq is of size 26 which is of constant size
----------------------------------------------------------------------------------
  class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int result = 0;
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) -'a']++ ;

        Arrays.sort(freq);

         for(int i = 24; i >= 0 && freq[i] > 0 ; i--)
         {
            if(freq[i] >= freq[i+1])
            {
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i+1] -1);

                result += prev - freq[i];
            }
         } 
         return result;  
    }
}
========================================================================================================
//Approach-2 (Using set to keep track of frequencies)
//T.C : O(n) we don't visit any character more than once.
//S.C : O(n) - Set
------------------------------------------------------------------
  class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int result = 0;
        for(int i = 0; i < s.length(); i++)
            freq[s.charAt(i) -'a']++ ;

          Set<Integer> st = new HashSet<>();
         for (int i = 0; i < 26; ++i)
          {

            while (freq[i] > 0 && st.contains(freq[i])) {
                freq[i]--;
                result++;
            }
            st.add(freq[i]);

        }        
        return result;
    }
}
