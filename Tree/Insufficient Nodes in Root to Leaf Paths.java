Q:- https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

T.C:- O(n)
S.C:- O(n)

=====================================================================================
  class Solution {
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root == null)return root;
        if(root.left == null && root.right == null)
            return root.val < limit ? null : root;
            root.left = sufficientSubset(root.left,limit - root.val);
            root.right = sufficientSubset(root.right,limit - root.val);

            return root.left == root.right ? null : root;
    }
}
