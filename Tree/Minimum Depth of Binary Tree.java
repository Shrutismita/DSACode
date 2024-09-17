Q:- https://leetcode.com/problems/minimum-depth-of-binary-tree/

T.C:- O(n)
S.C:- O(n)

 ==================================================================================
  class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;
        while(!queue.isEmpty())
        {
            int n = queue.size();
            for(int i = 0; i < n; i++)
            {
                TreeNode currNode = queue.poll();
                if(currNode.left == null && currNode.right == null)
                return depth;
                if(currNode.left != null)
                queue.add(currNode.left);
                if(currNode.right != null)
                queue.add(currNode.right);
            }
            depth++;
        }
        return depth;

        
    }
}
