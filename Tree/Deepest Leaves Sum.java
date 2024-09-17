Q:- https://leetcode.com/problems/deepest-leaves-sum/

T.C:- O(n)
S.C:- O(n)

=========================================================================
  class Solution {
    public int deepestLeavesSum(TreeNode root) {
      if (root == null) {
            return root.val;
        }

        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            boolean isDeepest = true;
            sum = 0;
            for (int i = 0; i < levelCount; i++) {
                TreeNode curNode = queue.poll();
				
                if (curNode.left == null && curNode.right == null) {
                    sum += curNode.val;
                }
				
                if (curNode.left != null) {
                    isDeepest = false;
                    queue.offer(curNode.left);
                }
				
                if (curNode.right != null) {
                    isDeepest = false;
                    queue.offer(curNode.right);
                }
            }

            if (isDeepest && queue.isEmpty()) {
                return sum;
            }
        }

        return sum;
    }
    }
