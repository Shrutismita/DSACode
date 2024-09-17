Q:- https://leetcode.com/problems/smallest-string-starting-from-leaf/
T.C :- O(n)
 S.C:- O(n)
 ====================================================================================
  class Solution {
   String result = "";

    void dfs(TreeNode root, String curr) {
        if (root == null) {
            return;
        }

        curr = (char) (root.val + 'a') + curr; 
        
        if (root.left == null && root.right == null) {
            if (result.equals("") || result.compareTo(curr) > 0) {
                result = curr;
            }
            return;
        }

        dfs(root.left, curr);
        dfs(root.right, curr);
    }

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, "");
        return result;
    }
}
