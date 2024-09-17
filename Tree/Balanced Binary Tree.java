Q:- https://leetcode.com/problems/balanced-binary-tree/
T.C:- O(n)
S.C:- O(1)
===============================================================================

  class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int result = isBalancedTree(root);
        if(result >= 1)
        {
            return true;
        }
        return false;
    }
    public int isBalancedTree(TreeNode root)
    {
        if(root == null) return 0;
        int left = isBalancedTree(root.left);
        if(left == -1) return -1;
        int right = isBalancedTree(root.right);
        if(right == -1) return -1;
        if(Math.abs(left - right) > 1)
        {
            return -1;
        }
        else
        {
            return Math.max(left,right) + 1;
        }
    }
}
  
