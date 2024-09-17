Q:- https://leetcode.com/problems/delete-leaves-with-a-given-value/

T.C:- O(n)
S.C:- O(1)
  ===================================================================================
  class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null)return null;

        root.left = removeLeafNodes(root.left,target);
        root.right = removeLeafNodes(root.right,target);

        if(root.left == null && root.right == null && root.val == target)
         return null;

         return root;
    }
}
