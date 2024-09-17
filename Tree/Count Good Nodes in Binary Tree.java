Q:- https://leetcode.com/problems/count-good-nodes-in-binary-tree/
T.C :- O(n)
S.C :- O(n)

==========================================================================================
  class Solution {
    int count = 0;
    void dfs(TreeNode root,int val)
    {
        if(root == null)return;
        if(root.val >= val)
           count++;

           dfs(root.left, Math.max(root.val,val));
           dfs(root.right, Math.max(root.val,val));
    }
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return count;
    }
}
