Q:- https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/

T.C:- O(n)
S.C:- O(n)

========================================================================================
  class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue =  new LinkedList<>();
        int sum = 0;
        queue.add(root);
        while(!queue.isEmpty())
        {
             TreeNode curr = queue.poll();
             if(curr.left != null)
               queue.add(curr.left);
             if(curr.right != null)
               queue.add(curr.right);  
             if(curr.val % 2 == 0)
             {
                if(curr.left != null && curr.left.left != null)
                {
                    sum += curr.left.left.val;
                }
                if(curr.left != null && curr.left.right != null)
                {
                    sum += curr.left.right.val;
                }
                if(curr.right != null && curr.right.left != null)
                {
                    sum += curr.right.left.val;
                }
                if(curr.right != null && curr.right.right != null)
                {
                    sum += curr.right.right.val;
                }
             }
        }
        return sum;
    }
}
