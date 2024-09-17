Q:- https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

T.C:- O(n)
S.C:- O(1)

========================================Using DFS========================================
  class Solution {
    int sum = 0;
    void solve(TreeNode root, int curr)
    {
        if(root == null)return ;
        curr = curr * 2 + root.val;
        if(root.left == null && root.right == null)
        sum += curr;
        solve(root.left,curr);
        solve(root.right,curr);
    }
    public int sumRootToLeaf(TreeNode root) {
        solve(root,0);
        return sum;
    }
}
