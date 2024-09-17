Q:- https://leetcode.com/problems/sum-root-to-leaf-numbers/

T.C:- O(n)
S.C:- O(1)

===========================================using DFS==================================================
  class Solution {
    int solve(TreeNode root, int curr)
    {
        if(root == null) return 0;
        curr = curr*10 + root.val;
        if(root.left == null && root.right == null)
         return curr;
         int leftSum = solve(root.left,curr);
         int rightSum = solve(root.right,curr);
         return leftSum + rightSum;
    }
    public int sumNumbers(TreeNode root) {
        return solve(root,0);
    }
}
