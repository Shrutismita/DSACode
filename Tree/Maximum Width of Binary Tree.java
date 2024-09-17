Q:- https://leetcode.com/problems/maximum-width-of-binary-tree/

T.C:- O(n)
S.C:- O(n)

 ===========================================================================================
  class Solution {
    
    public int widthOfBinaryTree(TreeNode root) {
          if(root == null)   
            return 0;
         Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
             queue.add(new Pair<>(root, 0));
             int maxWidth = 0;
        
        while(!queue.isEmpty()) {
            int n = queue.size();
           int levelStart = queue.peek().getValue();
            int index = 0;
                        
            for(int i = 0; i< n;i++) {
                 Pair<TreeNode, Integer> pair = queue.poll();
                  TreeNode node = pair.getKey();
                   index = pair.getValue();
                 if(node.left != null) {
                        queue.add(new Pair<>(node.left, 2*index+1));
                    }
                 if(node.right != null) {
                       queue.add(new Pair<>(node.right, 2*index+2));
                    }
            }
            maxWidth = Math.max(maxWidth, index - levelStart + 1);
        }
        return maxWidth;
    }
}
