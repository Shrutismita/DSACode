Q:- https://leetcode.com/problems/delete-node-in-a-bst/
T.C:- O(n)
S.C:- O(n)
  ========================================================================
  class Solution {
     TreeNode findLeft (TreeNode node)
     {
        if (node.left == null) return node;
        return findLeft(node.left);
     }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return null;

        if(root.val == key)
        {
            if(root.left == null && root.right == null)            
                return null;
            
            if(root.left == null)
              return root.right;
            if(root.right == null)
                return root.left; 

            TreeNode farLeft = findLeft(root.right);
            farLeft.left = root.left;

            return root.right;     
        }
        else
        {
            root.right = deleteNode(root.right,key);
            root.left = deleteNode(root.left, key);

            return root;
        }
    }
}
