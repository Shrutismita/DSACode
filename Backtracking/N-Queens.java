Q:- 51. https://leetcode.com/problems/n-queens/

T.C : O(n!)
S.C : O(n)
==============================================================================================
  class Solution {
    List<List<String>> result = new ArrayList<>();
    void backTrack(List<String> board,int row,HashSet<Integer> cols,HashSet<Integer> diags,HashSet<Integer> antiDiags)
    {
        if(row == board.size())
        {
            result.add(new ArrayList<>(board));
            return;
        }
        for (int col = 0; col < board.size(); col++) {
            int diagId = row - col;
            int antiDiagId = row + col;

            if (cols.contains(col) || diags.contains(diagId) || antiDiags.contains(antiDiagId))
                continue;

            cols.add(col);
            diags.add(diagId);
            antiDiags.add(antiDiagId);
            StringBuilder newRow = new StringBuilder(board.get(row));
            newRow.setCharAt(col, 'Q');
            board.set(row, newRow.toString());

            backTrack(board, row + 1, cols, diags, antiDiags);

            cols.remove(col);
            diags.remove(diagId);
            antiDiags.remove(antiDiagId);
            newRow.setCharAt(col, '.');
            board.set(row, newRow.toString());
        }
    }
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return new ArrayList<>();
         List<String> board = new ArrayList<>();
         for(int i = 0 ; i < n ; i++)
         {
            StringBuilder row = new StringBuilder();
            for(int j = 0 ; j < n ; j++)
           {
                row.append('.');
           }
           board.add(row.toString());
         }
         int startRow = 0;
         HashSet<Integer> cols = new HashSet<>();
         HashSet<Integer> diags = new HashSet<>();
         HashSet<Integer> antiDiags = new HashSet<>();
         backTrack( board,startRow,cols,diags,antiDiags);
         return result;
           
    }
}
