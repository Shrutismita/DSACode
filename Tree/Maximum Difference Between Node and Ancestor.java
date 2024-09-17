Q:- https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
T.C:- O(n)
S.C:- O(n)

========================================Using MIN and Max Value===================================================  

  class Solution {
   
      int findMaxDiff(TreeNode root, int minV, int maxV)
      {
        if(root == null)
        {
            return Math.abs(minV-maxV);
        }
        minV = Math.min(minV,root.val);
        maxV = Math.max(maxV,root.val);
        int leftMax = findMaxDiff(root.left,minV,maxV);
        int rightMax = findMaxDiff(root.right,minV,maxV);

        return Math.max(leftMax,rightMax);
      }
    public int maxAncestorDiff(TreeNode root) {
        
          int minV = root.val;
          int maxV = root.val;
          return findMaxDiff(root,minV,maxV);
    }
}
