Q:- https://leetcode.com/problems/max-points-on-a-line/
 Company Tags                : Google, Apple, LinkedIn, Amazon
 *********************************************************************************************************** 
  //Brute Force : O(n^3) - ACCEPTED
  -----------------------------------------
  class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
        int result = 0;

        for(int i = 0; i < n; i++)
        {
            for(int j = i+1; j <n; j++)
            {
                int count = 2;
                 int dx = points[j][0] - points[i][0];
                 int dy = points[j][1] - points[i][1];

                for(int k = 0 ; k < n; k++)
                {
                    if(i != k && j != k)
                    {
                          int dx_ = points[k][0] - points[i][0];
                          int dy_ = points[k][1] - points[i][1];
                          
                          if(dx_*dy == dy_*dx)
                          {
                            count++;
                          }
                    }
                }
                result = Math.max(result,count);
            }
        }
        return result;
    }
}
=========================================================================================
  //Math : O(n^2)
  -------------------------------
  class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n == 1) return 1;
        int result = 0;
        double temp = 0;
        for(int i = 0; i < n; i++)
        {
              HashMap<Double,Integer> map = new HashMap<>();
            for(int j = 0; j <n; j++)
            {
                  if(i == j) continue;
                
                 int dx = points[j][0] - points[i][0];
                 int dy = points[j][1] - points[i][1];
                  if(dx == 0)
                  {
                        temp = 100000;
                  }
                  else
                  {
                    temp = (double)dy / (double)dx;
                  }
                map.put(temp,map.getOrDefault(temp,0)+1);
                result = Math.max(result,map.get(temp));
            }
        }
        return result+1;
    }
}
