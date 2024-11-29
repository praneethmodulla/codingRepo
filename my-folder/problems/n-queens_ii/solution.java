class Solution {
    public int totalNQueens(int n) {
        int[] res = new int[1];
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        recurse(board, n - 1, res);
        return res[0];
    }

    public void recurse(char[][] board, int row, int[] res){
        if(row < 0){
            res[0] += 1;
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(validate(board, row, i)){
                board[row][i] = 'Q';
                recurse(board, row - 1, res);
                board[row][i] = '.';
            }
        }
        return;
    }

    public boolean validate(char[][] board, int row, int col){
        int tempRow = row;
        int tempCol = col;

        while(tempRow < board.length){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
        }

        tempRow = row;
        tempCol = col;
        while(tempRow < board.length && tempCol >= 0){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
            tempCol--;
        }

        tempRow = row;
        tempCol = col;
        while(tempRow < board.length && tempCol < board.length){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
            tempCol++;
        }
        return true;
    }
}