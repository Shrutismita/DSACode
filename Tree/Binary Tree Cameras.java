Q:-https://leetcode.com/problems/binary-tree-cameras/
T.C:- O(n)
S.C:- O(n)
=================================================================================
  class Solution {
    int count = 0;
    public int dfs(TreeNode node){
        
        if(node == null) return 2;
            
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if(left == 0 || right == 0){ // even if one needs a camera then I put a camera
            count++;
            return 1;       
            
        } else if(left == 1 || right == 1){ // even if one has a camera then I'm safe
            return 2;     
            
        } else{ // if both are surveilled then I need a camera
            return 0;
        }
    }
    public int minCameraCover(TreeNode root) {
         // 0 -> need camera
        // 1 -> is camera
        // 2 -> has surveillance
         if(root.left == null && root.right == null) return 1;
        
        if(dfs(root) == 0) count++;
        return count;
    }
}
