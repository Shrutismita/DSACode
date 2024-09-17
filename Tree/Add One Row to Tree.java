Q:- https://leetcode.com/problems/add-one-row-to-tree/

T.C:- O(n)
S.C:- O(n)

==================================================================
  class Solution {
    TreeNode add(TreeNode root, int val,int depth,int curr)
    {
        if(root == null) return null;
        if(curr == depth - 1)
        {
            TreeNode leftTemp = root.left;
            TreeNode rightTemp = root.right;

            root.left = new TreeNode(val);
            root.right = new TreeNode(val);

            root.left.left = leftTemp;
            root.right.right = rightTemp;

            return root;
        }
        root.left = add(root.left,val,depth,curr+1);
        root.right = add(root.right , val, depth, curr+1);
        return root;
    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1)
        {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        return add(root,val,depth,1);
    }
}
