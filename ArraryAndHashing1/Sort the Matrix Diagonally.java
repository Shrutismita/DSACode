Q:- https://leetcode.com/problems/sort-the-matrix-diagonally/
 Company Tags  : MICROSOFT
 ***********************************************************************************
  class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        // Map to store the diagonal elements (i - j as the key)
        Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();
         // Store elements of each diagonal into the map
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                   int key = i - j;
                    mp.putIfAbsent(key, new PriorityQueue<>());  // Initialize a priority queue for each diagonal
                    mp.get(key).offer(mat[i][j]);  // Add element to the diagonal (min-heap for sorting)
            }
        }
        // Place the sorted elements back into the matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int key = i - j;
                mat[i][j] = mp.get(key).poll();  // Retrieve the smallest element from the priority queue
            }
        }
        return mat;
    }
}
