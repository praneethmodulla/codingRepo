class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        recurse(n - 1, board, res);
        return res;
    }

    public void recurse(int row, char[][] board, List<List<String>> res){
        if(row < 0){
            res = construct(board, res);
            return;
        }

        for(int i = 0; i < board.length; i++){
            if(validate(row, i, board)){
                board[row][i] = 'Q';
                recurse(row - 1, board, res);
                board[row][i] = '.';
            }
        }
        return;
    }
    public List<List<String>> construct(char[][] board, List<List<String>> res){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            result.add(new String(board[i]));
        }
        res.add(result);
        return res;
    }
    public boolean validate(int row, int col, char[][] board){
        int tempCol = col;
        int tempRow = row;
        //Check for No Queen in the column
        while(tempRow < board.length){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
        }
        //Check for No Queen in the Diagonal - 1
        tempRow = row;
        tempCol = col;
        while(tempRow < board.length && tempCol < board.length){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
            tempCol++;
        }
        //Check for No Queen in the Diagonal - 2
        tempRow = row;
        tempCol = col;
        while(tempRow < board.length && tempCol >= 0){
            if(board[tempRow][tempCol] == 'Q'){
                return false;
            }
            tempRow++;
            tempCol--;
        }
        return true;
    }
}