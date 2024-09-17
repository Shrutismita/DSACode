Q:- https://leetcode.com/problems/trim-a-binary-search-tree/

T.C:- O(n)
S.C:- O(n)

 =======================================================================================
  class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        if(root.val > high || root.val < low)
        {
            if(root.left != null) return root.left;
            else return root.right;
        }
        else return root;
    }
}
