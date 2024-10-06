Q:- https://leetcode.com/problems/frog-position-after-t-seconds/
T.C:- O(V+E)
S.C:- O(V+E)
=================================================================================
  class Solution {
     class Node{
        int val;
        double pro;
        Node(int val, double pro){
            this.val=val;
            this.pro=pro;
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
         HashMap<Integer, List<Integer>> adj= new HashMap<>();
        for(int[] edge:edges){
            int src=edge[0];
            int dest=edge[1];
            adj.putIfAbsent(src, new ArrayList<Integer>());
            adj.putIfAbsent(dest, new ArrayList<Integer>());
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        Queue<Node> q= new LinkedList<>();
        Node root= new Node(1,1.0);
        boolean[] vis= new boolean[n+1];
        vis[1]=true;
        q.offer(root);
        while(!q.isEmpty()){
            boolean found=false;
            if(t<0)return 0.0;
            int n1=q.size();
            for(int i=0;i<n1;i++){
                Node node=q.poll();
                int child=0;
                if(adj.containsKey(node.val)){
                    for(int ch:adj.get(node.val)){
                        if(!vis[ch]){
                            child++;
                        }
                    }
                    double proToReachChild=node.pro/child;
                    for(int ch:adj.get(node.val)){
                        if(!vis[ch]){
                            q.offer(new Node(ch,proToReachChild ));
                            vis[ch]=true;
                        }
                    }
                }
                if(node.val==target){
                        if(t==0 || child==0)
                            return node.pro;
                    else return 0.0;
                }
            }
            t--;
        }
        return 0.0;
    }
}
