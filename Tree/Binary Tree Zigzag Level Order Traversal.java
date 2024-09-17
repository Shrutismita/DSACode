Q:- https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

T.C:- O(n)
S.C:- O(n)
 ===================================================================================
  class Solution {
    List<List<Integer>> result = new ArrayList<>();
    void traverseNode(TreeNode root)
    {
        if(root == null) return;
       
        if(root.left == null && root.right == null)
        {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(root.val);
            result.add(temp);
            return;
        }
           Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int level = 0;
           while(!queue.isEmpty())
           {
             int n = queue.size();
              ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0 ; i < n;i++)
                {                    
                         TreeNode node = queue.poll();
                         temp.add(node.val);
                         if(node.left != null)
                           queue.add(node.left);
                         if(node.right != null)
                           queue.add(node.right);
                           

                }
                if(level % 2 != 0)
                {
                    Collections.reverse(temp);
                }
                result.add(temp);
                level++;
           }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
         traverseNode(root);
         return result;
    }
}
