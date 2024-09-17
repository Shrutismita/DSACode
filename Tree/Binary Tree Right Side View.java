Q:- https://leetcode.com/problems/binary-tree-right-side-view/

T.C:- O(n)
S.C:- O(n)

====================================================================================================
  
class Solution {
    void dfs(TreeNode root, int level, List<Integer> result)
    {
        if(root == null)return ;

        if(result.size() < level)
        {
           result.add(root.val);
        }
        dfs(root.right,level + 1, result);
        dfs(root.left,level+1,result);
    }
    public List<Integer> rightSideView(TreeNode root) {
      if(root == null)
      return new ArrayList<>();

      List<Integer> result = new ArrayList<>();
      dfs(root,1,result);
      return result;
    }
}
