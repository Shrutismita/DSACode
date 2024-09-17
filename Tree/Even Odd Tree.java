Q:- https://leetcode.com/problems/even-odd-tree/

T.C:- O(n)
S.C:- O(n) + O(m) -- where m is the depth of tree

====================================================================
  class Solution {
    private List<Integer> levelPrev = new ArrayList<>();
    private boolean dfs(TreeNode root, int level) {
        if (root == null) {
            return true;
        }

        if ((level % 2 == 0 && root.val % 2 == 0) || 
            (level % 2 != 0 && root.val % 2 != 0)) {
            return false;
        }

        if (level >= levelPrev.size()) {
            levelPrev.add(root.val);
        } else {
            if ((level % 2 == 0 && root.val <= levelPrev.get(level)) ||
                (level % 2 != 0 && root.val >= levelPrev.get(level))) {
                return false;
            }
            levelPrev.set(level, root.val);
        }

        return dfs(root.left, level + 1) && dfs(root.right, level + 1);
    }
    public boolean isEvenOddTree(TreeNode root) {
            return dfs (root, 0);
    }
}
