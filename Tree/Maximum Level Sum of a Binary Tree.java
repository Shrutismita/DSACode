Q:- https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

T.C:- O(n)
S.C:- O(n)

  =========================================================================================
  class Solution {
    public int maxLevelSum(TreeNode root) {
        
    int maxSum = Integer.MIN_VALUE;
        int resultLevel = 0;
        int currLevel = 1;
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        
        
        while(!que.isEmpty()) {

            int n = que.size();
            
            int sum = 0;
            
            for(int i = 0; i < n; i++){
                
                TreeNode node = que.poll();
                //que.poll();
                
                sum += node.val;
                
                if(node.left != null)
                    que.offer(node.left);
                
                if(node.right != null)
                    que.offer(node.right);
            }
            
            if(sum > maxSum) {
                maxSum = sum;
                resultLevel = currLevel;
            }
            currLevel++;
        }
        
        return resultLevel;
        
    }
}
