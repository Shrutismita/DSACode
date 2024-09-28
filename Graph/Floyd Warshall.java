Q:- https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
Floyd Warshall
The problem is to find the shortest distances between every pair of vertices in a given edge-weighted directed graph. 
  The graph is represented as an adjacency matrix of size n*n. Matrix[i][j] denotes the weight of the edge from i to j. 
  If Matrix[i][j]=-1, it means there is no edge from i to j.
Note : Modify the distances for every pair in-place.
======================================================================================================================================
T.C:- O(n^3)
S.C:- O(1)
======================================================================================================
  class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
     int n=matrix.length;
        //int max=;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==-1)
                  matrix[i][j]=Integer.MAX_VALUE;
                if(i==j)
                  matrix[i][j]=0;
            }
        }
        
         //floyd warshall algorithm
        
        for(int via = 0; via < n;via++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(matrix[i][via]!=Integer.MAX_VALUE && matrix[via][j]!=Integer.MAX_VALUE) 
                    {
                      matrix[i][j]=Math.min(matrix[i][j],(matrix[i][via]+matrix[via][j]));
                    }
                }
            }
        }
        
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==Integer.MAX_VALUE)
                  matrix[i][j]= -1;
                
            }
        }
    }
}
