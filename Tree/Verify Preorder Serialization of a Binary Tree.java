Q:- https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

T.C:- O(n)
S.C:- O(1)
  ========================================================================================
  class Solution {
    int idx;
    boolean ans;
    void dfs(String preorder)
    {
        if(idx >= preorder.length())
        {
            ans = false;
            return;
        }
        if(preorder.charAt(idx) == '#')
        {
            idx += 2;
            return;
        }
        while(idx < preorder.length() && (preorder.charAt(idx) != ','))
        {
            idx++;
        }
        idx++;
        dfs(preorder);
        dfs(preorder);
    }
    public boolean isValidSerialization(String preorder) {
        idx = 0; 
        ans = true;
        dfs(preorder);
        if(idx < preorder.length())return false;
        return ans;
    }
}
