Q:- https://leetcode.com/problems/binary-tree-maximum-path-sum/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  
class Solution {
    
     int maxSum(TreeNode node, int[] arr) {

        if(node == null) {
            return 0;
        }
        int leftNodesValues = Math.max(0, maxSum(node.left, arr));
        int rightNodesValues = Math.max(0, maxSum(node.right, arr));
        int totalSum = leftNodesValues + node.val + rightNodesValues;
        arr[0] = Math.max(arr[0], totalSum);
        return node.val + Math.max(leftNodesValues, rightNodesValues);
    }
    public int maxPathSum(TreeNode root) {
         int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        maxSum(root, ans);
        return ans[0];
    }
}
