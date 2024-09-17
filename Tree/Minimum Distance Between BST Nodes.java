Q:- https://leetcode.com/problems/minimum-distance-between-bst-nodes/

T.C:- O(n)
S.C:- O(n)
 ======================================================================================================
  class Solution {
    List<Integer> list = new ArrayList<>();
    void dfs(TreeNode root)
    {
        if(root == null)return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        Collections.sort(list);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size()-1;i++)
        {
            min = Math.min(min,Math.abs(list.get(i) - list.get(i+1)));
        }
        return min;
    }
}
