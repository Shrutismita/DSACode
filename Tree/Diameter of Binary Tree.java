Q:- https://leetcode.com/problems/diameter-of-binary-tree/
T.C:- O(n)
S.C :- O(1)

==========================================================================================
  class Solution {
     int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
       
        if(root == null) return 0;
         findDiameter(root);
         return result;
        
    }
    public int findDiameter(TreeNode root)
    {
         if(root == null)return 0;
          int left = findDiameter(root.left);
          int right = findDiameter(root.right);
          result = Math.max(result , (left + right));

         return Math.max(left,right) + 1;
    }
}
