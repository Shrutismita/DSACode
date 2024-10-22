Q:- https://leetcode.com/problems/diagonal-traverse/
Company Tags  : Google, Amazon
*************************************************************************************
//Time Complexity: O(m * n)
//Space Complexity: O(m * n)  
-----------------------------------------------------------------
  class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
          int m = mat.length;
        int n = mat[0].length;
          Map<Integer, ArrayList<Integer>> mp = new HashMap<>();
          int[] result=new int[mat.length*mat[0].length];
            //fill the map using [i+j]
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                  if(!mp.containsKey(i+j)){
                    mp.put((i+j),new ArrayList<Integer>());
                }
                mp.get(i+j).add(mat[i][j]);
            }
        }
          boolean flip = true;
          int k=0;
        for(int i:mp.keySet()) {
            ArrayList<Integer> al=mp.get(i);
            if(flip) {
                 Collections.reverse(al);
            }
            
            for(int j=0;j<al.size();j++){
                result[k]=al.get(j);
                k++;
            }
            
            flip = !flip;
        }
        
        return result;
    }
}
