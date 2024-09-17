Q:- https://leetcode.com/problems/univalued-binary-tree/
T.C:- O(n)
S.C:- O(1)
=================================================================================
  class Solution {
    boolean ans = false;
    void dfs(TreeNode root,int key)
    {
        if(root == null)return;

        if(root.val != key)
        {
            ans = true;
            if(ans)return;
        }
        dfs(root.left,key);
        dfs(root.right,key);
    }
    public boolean isUnivalTree(TreeNode root) {
        dfs(root,root.val);
        return !ans;
    }
}
