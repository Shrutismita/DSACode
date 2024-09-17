Q:- https://leetcode.com/problems/convert-bst-to-greater-tree/
T.C:- O(n)
S.C:- O(1)

 =====================================================================
  class Solution {
    int sum = 0;
    void GreaterTree(TreeNode root)
    {
        if(root == null)return ;
        GreaterTree(root.right);
        sum += root.val;
        root.val = sum;
        GreaterTree(root.left);
    }
    public TreeNode convertBST(TreeNode root) {
        GreaterTree(root);
        return root;
    }
}
