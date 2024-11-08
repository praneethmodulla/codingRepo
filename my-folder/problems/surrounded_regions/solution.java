class Solution {
    public void solve(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == 'O' && vis[i][0] != 1){
                checkSurround(board, i, 0, vis);
            }
            if(board[i][board[0].length - 1] == 'O' && vis[i][board[0].length - 1] != 1){
                checkSurround(board, i, board[0].length - 1, vis);
            }
        }
        for(int j = 0; j < board[0].length; j++){
            if(board[0][j] == 'O' && vis[0][j] != 1){
                checkSurround(board, 0, j, vis);
            }
            if(board[board.length - 1][j] == 'O' && vis[board.length - 1][j] != 1){
                checkSurround(board, board.length - 1, j, vis);
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(vis[i][j] != 1 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void checkSurround(char[][] board, int i, int j, int[][] vis){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return;
        }
        if(board[i][j] == 'X'){
            return;
        }
        if(vis[i][j] == 1){
            return;
        }
        vis[i][j] = 1;
        checkSurround(board, i + 1, j, vis);
        checkSurround(board, i - 1, j, vis);
        checkSurround(board, i, j + 1, vis);
        checkSurround(board, i, j - 1, vis);
        return;
    }
}