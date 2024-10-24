Q:- https://leetcode.com/problems/scramble-string/
*************************************************************
//Appoach- (Recursion + Memo)
--------------------------------------------------
 class Solution {
      Map<String, Boolean> mp = new HashMap<>();
      boolean solve(String s1, String s2)
      {
              int n = s1.length();
              if (s1.equals(s2)) return true;
              if (n == 1) return false;
            String key = s1 + " " + s2;

        if (mp.containsKey(key)) return mp.get(key);
        // boolean result = false;
        for (int i = 1; i < n; i++) {
              /*
            Example : "great"  "eatgr"
            if swapped at i = 2
            we compare s1.substr(0, i) i.e "gr"  with s2.substr(n-i, i) i.e. "gr"
            && s1.substr(i, n-i) i.e "eat"  with s2.substr(0, n-i) i.e. "eat"
            */

            boolean swapped = solve(s1.substring(0, i), s2.substring(0, i)) 
                              && solve(s1.substring(i), s2.substring(i));
            if(swapped) { //if we find they are scrambled, we don't need to check further
                mp.put(key, true);
                return true;
            }
            /*
            Example : "great"  "great"
            if not swapped at i = 2
            we compare s1.substr(0, i) i.e "gr"  with s2.substr(0, i) i.e. "gr"
            && s1.substr(i, n-i) i.e "eat"  with s2.substr(i, n-i) i.e. "eat"
            */

            boolean not_swapped = solve(s1.substring(0, i), s2.substring(n - i)) &&
                               solve(s1.substring(i), s2.substring(0, n - i));
            if(not_swapped) { //if we find they are scrambled, we don't need to check further
                mp.put(key, true);
                return true;
               
            }
            
        }

        mp.put(key, false);
        return false;
      }
    public boolean isScramble(String s1, String s2) {
        mp.clear();
        return solve(s1, s2);
    }
}
