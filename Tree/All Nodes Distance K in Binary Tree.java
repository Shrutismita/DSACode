Q:- https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

T.C:- O(n)
S.C:- O(n)

 ===========================================================================
  
class Solution {
     public void traverseForParent(HashMap<TreeNode,TreeNode> parents, TreeNode root){
        if(root == null)
            return ;
        
        if(root.left != null ){
            parents.put(root.left, root);
            traverseForParent(parents, root.left);
        }
        
        if( root.right != null){
            parents.put(root.right, root);
            traverseForParent(parents, root.right);
        }
        
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    HashMap<TreeNode, TreeNode> parents = new HashMap();
        parents.put(root, null);
        traverseForParent(parents, root);
        HashSet<TreeNode> visited = new HashSet();
        Queue<TreeNode> q =  new LinkedList();
        q.add(target);
        visited.add(target);
        List<Integer> ans = new ArrayList();
        while( k-- >0 ){
            int siz = q.size();
            for( int i = 0 ; i < siz; i++){
                TreeNode cur = q.poll();
               
                if(parents.get(cur) != null &&  !visited.contains(parents.get(cur))){
                    q.add(parents.get(cur));
                    visited.add(parents.get(cur));
                }

                if(cur.left != null &&  !visited.contains(cur.left)){
                    q.add(cur.left);
                    visited.add(cur.left);
                }
                
                if(cur.right != null &&  !visited.contains(cur.right)){
                    q.add(cur.right);
                    visited.add(cur.right);
                }
                
                
            }
            
        }

        while(q.size()>0)
            ans.add(q.poll().val);
        
        return ans;
        
    }   
}
