Q:- https://leetcode.com/problems/check-completeness-of-a-binary-tree/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean nullFound = false;
        while(!queue.isEmpty()) {
            root = queue.poll();
            if (root.left == null || root.right == null) {
                if (nullFound && (root.left != root.right))
                    return false;
                if (root.right != null)
                    return false;
                if (root.left != null)
                    queue.add(root.left);
                nullFound = true;
            } else {
                if (nullFound) return false;
                queue.add(root.left);
                queue.add(root.right);
            }
        }
        return true;
    }
}
