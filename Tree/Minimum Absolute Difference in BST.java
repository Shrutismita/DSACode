Q:- https://leetcode.com/problems/minimum-absolute-difference-in-bst/
T.C:- O(n)
S.C:- O(n)

=============================================================================================
  class Solution {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    void inOrder(TreeNode root)
    {
        if(root == null) return;
        inOrder(root.left);
        if(prev != null)
        {
              int absDiff = root.val - prev.val;
              minDiff = Math.min(minDiff , absDiff);
        }
       prev = root;
       inOrder(root.right);

    }
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
}
