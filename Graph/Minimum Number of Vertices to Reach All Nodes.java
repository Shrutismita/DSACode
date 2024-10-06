Q:- https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/
T.C:- O(E)
S.C:- O(N)
=================================================================================
  class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] inDegree = new boolean[n];
        for(List<Integer> edge : edges)
        {
            int u = edge.get(0);
            int v = edge.get(1);
            inDegree[v] = true;
        }
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++)
        {
            if(inDegree[i] == false)
            {
                result.add(i);
            }
        }
        return result;
    }
}
