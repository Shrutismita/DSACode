Q:- https://leetcode.com/problems/validate-binary-search-tree/

T.C:- O(n)
S.C:- O(1)

  =======================================================================================
  class Solution {
    boolean isBst(TreeNode root , TreeNode l, TreeNode r)
    {
        if(root == null)return true;
        if( (r != null && root.val >= r.val) || ( l != null && root.val <= l.val)) return false;
        if((!isBst(root.left,l,root)) || (!isBst(root.right,root,r)))
            return false;

       return true;     
    }
    public boolean isValidBST(TreeNode root) {
        TreeNode l = null;
        TreeNode r = null;
        return isBst(root,l,r);
    }
}
