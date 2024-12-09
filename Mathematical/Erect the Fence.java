Q:- https://leetcode.com/problems/erect-the-fence/
Company Tags                : Google
********************************************************************************************************
//Approach- Using Convex Hull Algorithms
//S.C:- O(nlogn)
//T.C:- O(n)
------------------------------------------------------------
  class Solution {
    public int findEquationValue(int[] p1, int[] p2, int[] p3) {
        
        int a = (p2[0]-p1[0]);
        int b = (p2[1]-p1[1]);
        int c = (p3[0]-p2[0]);
        int d = (p3[1]-p2[1]);
        return a*d-b*c; //+ve for right orientation, -ve for left oritentation
    }
    public int[][] outerTrees(int[][] trees) {
         Arrays.sort(trees,(a,b)-> a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);

          Stack<int[]> upper=new Stack<>();
          Stack<int[]> lower=new Stack<>();

          for(int i=0;i<trees.length;i++)
          {
                while(lower.size()>=2 && findEquationValue(lower.get(lower.size()-2),lower.get(lower.size()-1),trees[i])>0)
                {
                    lower.pop();
                }
            
                while(upper.size()>=2 && findEquationValue(upper.get(upper.size()-2),upper.get(upper.size()-1),trees[i])<0)
                {
                     upper.pop();
                }

                 lower.push(trees[i]);
                 upper.push(trees[i]);
          }
           Set<int[]> set=new HashSet<>();
            set.addAll(lower);
            set.addAll(upper);
        
            int[][] result = new int[set.size()][2];
        
            int i=0;
            for(int[] row:set)
            {
                 result[i]=row;
                 i++;
            }
        return result;
    }
}
