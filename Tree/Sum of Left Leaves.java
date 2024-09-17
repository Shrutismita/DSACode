Q:- https://leetcode.com/problems/sum-of-left-leaves/
T.C:- O(n)
S.C:- O(1)

  ==================================================================================
  class Solution {
    int sum = 0;
    TreeNode dfs(TreeNode root)
    {
        if(root == null)return null;
        if(root.left != null)
        {
            if(root.left.left == null && root.left.right == null)
            {
                sum += root.left.val;
            }
        }
        dfs(root.left);
        dfs(root.right);

        return null;
    }
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
}
