Q:- https://leetcode.com/problems/increasing-order-search-tree/
T.C:- O(n)
S.C:- O(n)
  =============================================================
  class Solution {
    TreeNode currNode;
    void dfs(TreeNode root)
    {
        if(root == null)return;
        dfs(root.left);
        currNode.right = new TreeNode(root.val);
        currNode = currNode.right;
        dfs(root.right);
    }
    public TreeNode increasingBST(TreeNode root) {
        TreeNode newRoot = new TreeNode(-1);
        currNode = newRoot;
        dfs(root);
        return newRoot.right;
    }
}
