class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.' && (!check(board, i, j))){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(char[][] board, int row, int col){
        boolean checkRow = true;
        boolean checkCol = true;
        boolean checkBox = true;
        //Check Column and Row
        for(int i = 0; i < board.length; i++){
            if(i != row){
                if(board[i][col] == board[row][col]){
                    return false;
                }
            }
            if(i != col){
                if(board[row][i] == board[row][col]){
                    return false;
                }
            }
        }
        //Check Box
        int boxRow = row/3;
        int boxCol = col/3;
        int startRow = boxRow * 3;
        int startCol = boxCol * 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(row != startRow + i && col != startCol + j && board[row][col] == board[startRow + i][startCol + j]){
                    return false;
                }
            }
        }
        return checkRow && checkCol && checkBox;
    }
}