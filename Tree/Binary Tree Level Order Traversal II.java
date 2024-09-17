Q:- https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

T.C:- O(n)
S.C:- O(n)

 =======================================================================
  class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> helper = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                TreeNode node = queue.poll();

                if(node.left != null)
                queue.add(node.left);
                if(node.right != null)
                queue.add(node.right);

                helper.add(node.val);

            }
            result.add(helper);
        }
        Collections.reverse(result);
        return result;
    }
}
