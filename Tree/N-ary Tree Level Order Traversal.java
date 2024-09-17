Q:- https://leetcode.com/problems/n-ary-tree-level-order-traversal/

T.C:- O(n)
S.C:- O(n)
 =========================================================================================
  
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
     Queue<Node> queue = new ArrayDeque<>();
        
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)return ans;
         queue.add(root);
        List<Integer> list;
        while(queue.size()>0)
        {
          list=new ArrayList<>();  
            int n = queue.size();
            for(int i = 0;i < n ;i++){
                Node temp = queue.poll();
                list.add(temp.val);
                for (Node c : temp.children)
                    queue.add(c);
            }
            ans.add(list);
            
        }   
        return ans;
    }
}
