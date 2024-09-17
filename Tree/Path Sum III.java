Q:- https://leetcode.com/problems/path-sum-iii/

T.C:- O(n)
S.C:- O(1)
 ============================================================================
  class Solution {
    static int pathSumFromRoot(TreeNode root, long sum){
    if(root == null) return 0;
    
    int res = 0;
    if(root.val == sum) {
        res += 1;
    }
    
    res += pathSumFromRoot(root.left, sum - root.val);
    res += pathSumFromRoot(root.right, sum - root.val);
    
    return (int)res;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;

         return pathSumFromRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }
}
