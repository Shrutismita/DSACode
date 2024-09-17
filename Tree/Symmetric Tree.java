Q:- https://leetcode.com/problems/symmetric-tree/

T.C:- O(n)
S.C:- O(1)

 =======================================================================
  class Solution {
    boolean checkSymmetric(TreeNode left, TreeNode right)
    {
        if(left == null && right == null)return true;
        if(left == null || right == null)return false;

           if((left.val == right.val) && checkSymmetric(left.left,right.right) && checkSymmetric(left.right,right.left))
               return true;

        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return checkSymmetric(root.left,root.right);
    }
}
