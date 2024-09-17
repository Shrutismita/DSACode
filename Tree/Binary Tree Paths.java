Q:- https://leetcode.com/problems/binary-tree-paths/
  T.C:- O(n)
S.C:- O(1)  
  
  ========================================================================================
  class Solution {
    void dfs(TreeNode node, String s, List<String> res)
    {
        s += node.val;
        if(node.left == null && node.right == null)
        {
            res.add(s);
            return;
        }
        s += "->";
        if(node.left != null)dfs(node.left,s,res);
        if(node.right != null) dfs(node.right,s,res);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root,"",res);
        return res;
    }
}
