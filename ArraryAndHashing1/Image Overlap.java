Q:- https://leetcode.com/problems/image-overlap/
 Company Tags                : Google
 ************************************************************
  class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
      int n = img1.length;
        List<int[]> l = new ArrayList<>();
        List<int[]> r = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(img1[i][j]==1) l.add(new int[]{i,j});
                if(img2[i][j]==1) r.add(new int[]{i,j});
            }
        }
        
        int[][] cnt = new int[2*n][2*n];
        int res = 0;
        for(int[] x:l){
            for(int[] y:r){
                int xd=x[0]-y[0]+n,yd=x[1]-y[1]+n;
                cnt[xd][yd]++;
                res = Math.max(res, cnt[xd][yd]);
            }
        }
        return res;
    }
}
