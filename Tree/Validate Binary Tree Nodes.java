Q:- https://leetcode.com/problems/validate-binary-tree-nodes/

T.C:- O(n)
S.C:- O(n)

 ==============================================================================
  class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int []indegree = new int[n];
        for(int i=0; i<n; i++){
            if(leftChild[i] != -1) indegree[leftChild[i]]++;
            if(rightChild[i] != -1) indegree[rightChild[i]]++;
        }

        int root=-1;
        for(int i=0; i<n; i++){
            if(indegree[i] == 0){
                if(root==-1) root=i;
                else return false;
            }
        }

        if(root==-1) return false;
        boolean []visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(visited[node]) return false;
            visited[node] = true;
            if(leftChild[node] != -1) queue.add(leftChild[node]);
            if(rightChild[node] != -1) queue.add(rightChild[node]);
        }

        int t_count=0;
        for(boolean v:visited){
            if(v) t_count++;
        }
        return t_count==n;
    }
}
