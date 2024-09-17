Q:- https://leetcode.com/problems/invert-binary-tree/
T.C:- O(n)
S.C :- O(1)

 =================================================================================
  public class Solution {
    public TreeNode InvertTree(TreeNode root) {
        if(root != null)
        {
            var temp = root.left;
            root.left = root.right;
            root.right = temp;
            InvertTree(root.left);
            InvertTree(root.right);
        }
        return root;
    }
}
