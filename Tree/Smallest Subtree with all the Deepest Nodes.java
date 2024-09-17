Q:- https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

T.C:- O(n)
S.C:- O(n)

  ===============================================================================
  
class Solution {
    TreeNode result;
    int maxDepth = 0;
    int dfs(TreeNode root,int level)
    {
        if(root == null)return level;

        int left = dfs(root.left,level+1);
        int right = dfs(root.right,level+1);

        if(left == right)
        {
            maxDepth = Math.max(maxDepth,left);
            if(maxDepth == left)
            {
                result = root;
            }
        }
        return Math.max(left,right);
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs(root,0);
        return result;
    }
}
