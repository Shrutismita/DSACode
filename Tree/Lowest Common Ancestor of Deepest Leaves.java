Q:- https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

T.C:- O(n)
S.C:- O(n)

=========================================================================
  class Solution {
    int deepset = 0;
    TreeNode node;
    int dfs(TreeNode root, int depth)
    {
        deepset = Math.max(deepset,depth);
        if(root == null)return depth;

         int left = dfs(root.left,depth + 1);
         int right = dfs(root.right, depth + 1);

         if(left == deepset && left == right)
         node = root;

         return Math.max(left, right);
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root,0);
        return node;
    }
}
