Q:- https://leetcode.com/problems/scramble-string/
*************************************************************
  //Appoach- (Recursion + Memo)
  ---------------------------------------
  class Solution {
      Map<String, Boolean> mp = new HashMap<>();
      boolean solve(String s1, String s2)
      {
              int n = s1.length();
              if (s1.equals(s2)) return true;
              if (n == 1) return false;
            String key = s1 + " " + s2;

        if (mp.containsKey(key)) return mp.get(key);

        for (int i = 1; i < n; i++) {
            if (solve(s1.substring(0, i), s2.substring(0, i)) && solve(s1.substring(i), s2.substring(i))){
                mp.put(key, true);
                return true;
            }

            if (solve(s1.substring(0, i), s2.substring(n - i)) && solve(s1.substring(i), s2.substring(0, n - i))){
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
