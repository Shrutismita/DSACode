Q:- https://leetcode.com/problems/search-in-a-binary-search-tree/

T.C:- O(n)
S.C:- O(1)
  ================================================================
  class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)return null;
        if(root.val == val) return root;

        TreeNode left = searchBST(root.left,val);
        TreeNode right = searchBST(root.right,val);

        return left != null ? left: right;
    }
}
