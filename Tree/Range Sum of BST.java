Q:- https://leetcode.com/problems/range-sum-of-bst/
T.C:- O(n)
S.C:- O(1)
==============================================================================
  class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int sum = root.val >= low && root.val <= high ? root.val : 0;

        if(root.left != null)
        {
            sum += rangeSumBST(root.left,low,high);
        }
        if(root.right != null)
        {
            sum += rangeSumBST(root.right,low,high);
        }
        return sum;
    }
}
