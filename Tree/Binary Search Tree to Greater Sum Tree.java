Q:- https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/

T.C:- O(n)
S.C:- O(1)

 ===================================================================================
  class Solution {
    int sum = 0;
    void solve(TreeNode root)
    {
        if(root == null)return;
        solve(root.right);
        sum += root.val;
        root.val = sum;
        solve(root.left);
    }
    public TreeNode bstToGst(TreeNode root) {
        solve(root);
        return root;
    }
}
