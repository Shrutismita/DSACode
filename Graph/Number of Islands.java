Q:- https://leetcode.com/problems/number-of-islands/
Company Tags : Paytm, Amazon, Microsoft, Samsung, Snapdeal, Citrix, D-E-Shaw, Ola Cabs, Visa, 
      Linkedin, Opera, Streamoid Technologies, Informatica
*****************************************************************************************************
//Approach-1 (DFS)
//T.C : O(m*n)
//S.C : O(m*n)
------------------------
  class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <m; j++)
            {
                if(grid[i][j] == '1')
                {
                        dfs(grid,i,j);
                        count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int i, int j)
    {
         if((i<0 || i >= grid.length ) || (j < 0 || j >= grid[0].length)){
            return ;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(grid[i][j]=='$'){
            return;
        }
        grid[i][j]= '$';
        dfs(grid,i-1,j);
        dfs(grid,i+1,j);
        dfs(grid,i,j-1);
        dfs(grid,i,j+1);
    }
}
================================================================================================
//Approach-2 (BFS)
//T.C : O(m*n)
//S.C : O(m*n)
------------------------------------------  
  class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j <m; j++)
            {
                if(grid[i][j] == '1')
                {
                        bfs(grid,i,j);
                        count++;
                }
            }
        }
        return count;
    }
    void bfs(char[][] grid, int i, int j)
    {
        int[][] dir = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
         Queue<Pair> queue =new LinkedList<Pair>();
         if((i<0 || i >= grid.length ) || (j < 0 || j >= grid[0].length)){
            return ;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(grid[i][j]=='$'){
            return;
        }
        queue.add(new Pair(i,j));
        grid[i][j]= '$';
           while (!queue.isEmpty()) 
           {
               Pair curr = queue.poll();
               for(int[] p : dir) 
               {
                 int i_ = curr.first + p[0];
                 int j_ =  curr.second + p[1];
                  if ( i_ >= 0 && i_ < grid.length && j_ >= 0 && j_ < grid[0].length && grid[i_][j_] == '1') {
                    queue.add(new Pair(i_, j_));
                    grid[i_][j_] = '$';
                }
               }
           }
    }
}
