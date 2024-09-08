Q: - 131 https://leetcode.com/problems/palindrome-partitioning/

T.C : O(n * 2^n) 
S.C : O(n * 2^n)

===============================================================================================
  class Solution {
    int n ;
    public List<List<String>> partition(String s) {
          n = s.length();
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backTrack( s,0,curr,result);
        return result;
    }
    void backTrack(String s, int idx, List<String> curr, List<List<String>> result)
    {
        if(idx == n)
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        for(int i = idx; i< n ; i++)
        {
            if(isPalindrom(s,idx,i))
            {
                curr.add(s.substring(idx,i+1));
                backTrack(s,i+1,curr,result);
                curr.remove(curr.size() - 1);
            }
        }
    }
    boolean isPalindrom(String s, int l , int r)
    {
        while(l < r)
        {
            if(s.charAt(l) != s.charAt(r))
            return false;
             l++;
             r--;
        }
        return true;
    }
}
