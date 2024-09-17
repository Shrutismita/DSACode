Q:- https://leetcode.com/problems/maximum-depth-of-binary-tree/
S.C:- O(n)
 T.C :- O(1)

 ================================================================================================
   public class Solution {
    public int MaxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = MaxDepth(root.left);
        int right = MaxDepth(root.right);
        return Math.Max(left,right) + 1;
    }
}
