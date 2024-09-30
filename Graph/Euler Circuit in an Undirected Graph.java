Q:-  https://www.geeksforgeeks.org/problems/euler-circuit-in-a-directed-graph/1

========================================================================================
T.C : O(V)
S.C : O(1)
 ==================================================================================================
  class Solution {
    public boolean isEularCircuitExist(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] degree = new int[v];
        for(int i = 0; i < v;i++)
        {
            degree[i] = adj.get(i).size();
        }
        for(int i = 0; i<v;i++)
        {
            if(degree[i]%2 != 0)
            {
                return false;
            }
        }
        return true;
    }
}
