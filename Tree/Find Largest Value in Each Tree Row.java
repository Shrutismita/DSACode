Q:- https://leetcode.com/problems/find-largest-value-in-each-tree-row/
T.C- O(n)
 S.C:- O(n)

  ========================================================================
  class Solution {
    List<Integer> result = new ArrayList<>();
    void dfs(TreeNode root, int depth)
    {
        if(root == null) return;
        if(result.size() == depth)
        {
            result.add(root.val);
        }
        else
        {
            result.set(depth,Math.max(result.get(depth),root.val));
        }
        dfs(root.left,depth + 1);
        dfs(root.right,depth + 1);
    }
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,0);
        return result;
    }
}
