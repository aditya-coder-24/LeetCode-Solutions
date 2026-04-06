class Solution {

    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        
        solve(0, board, result);
        return result;
    }

    private void solve(int row, char[][] board, List<List<String>> result) {
        
        if(row == board.length) {
            result.add(construct(board));
            return;
        }
        
        for(int col = 0; col < board.length; col++) {
            
            if(isSafe(row, col, board)) {
                
                board[row][col] = 'Q';
                solve(row + 1, board, result);
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {
        
        // column check
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q')
                return false;
        }
        
        // left diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }
        
        // right diagonal
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if(board[i][j] == 'Q')
                return false;
        }
        
        return true;
    }

    private List<String> construct(char[][] board) {
        
        List<String> list = new ArrayList<>();
        
        for(int i = 0; i < board.length; i++) {
            list.add(new String(board[i]));
        }
        
        return list;
    }
}