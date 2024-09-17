Q:- https://leetcode.com/problems/binary-tree-level-order-traversal/

T.C:- O(n)
S.C:- O(n)

==============================================Using BFS ======================================================
  class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < n; i++)
            {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);
            }
            ans.add(temp);

        }
        return ans;
    }
}
