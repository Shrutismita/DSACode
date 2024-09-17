Q:- https://leetcode.com/problems/average-of-levels-in-binary-tree/

T.C:- O(n)
S.C:- O(n)

 ===========================================================================================
  class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        double sum = 0;
        while(!queue.isEmpty())
        {
            sum = 0;
            int n = queue.size();
            for(int i = 0; i < n; i++)
            {
                TreeNode curr = queue.poll();
                sum +=curr.val;
                if(curr.left != null)
                queue.add(curr.left);
                if(curr.right != null)
                queue.add(curr.right);
            }
            double avg = sum / n;
            result.add(avg);
        }
        return result;
    }
}
