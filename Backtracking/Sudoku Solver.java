Q: 37 https://leetcode.com/problems/sudoku-solver/description/
T.C :- Not able to find
S.C : - Not ableto find

  =====================================================================================
  class Solution {
    
     public boolean isValid(char[][] board, int i, int j, char ch) {
        
        for(int col = 0; col<9; col++) {
            if(board[i][col] == ch) return false;
        }
        
        for(int row = 0; row<9; row++) {
            if(board[row][j] == ch) return false;
        }        
        int start_i = i/3 * 3;
        int start_j = j/3 * 3;
        for(int k = 0; k<3; k++) {
            for(int l = 0; l<3; l++) {
                if(board[start_i + k][start_j + l] == ch) return false;
            }
        }
        
        
        return true;
    }
    
    public boolean backtrack(char[][] board, int i, int j) {
        
        if(i == 9)
            return true;
        
       
        if(j == 9)
            return backtrack(board, i+1, 0);
        
       
        if(board[i][j] != '.')
            return backtrack(board, i, j+1);
    
        for(char ch = '1'; ch<='9'; ch++) {
            if(isValid(board, i, j, ch)) {
                board[i][j] = ch;
                if(backtrack(board, i, j+1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        
        return false;
    }
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }
}
