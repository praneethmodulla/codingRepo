class Solution {
    public boolean exist(char[][] board, String word) {
        boolean checkExists = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    checkExists = recurse(board, word, i, j, 0);
                    if(checkExists){
                        return checkExists;
                    }
                }
            }
        }
        return false;
    }

    public boolean recurse(char[][] board, String word, int row, int col, int idx){
        if(idx == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length){
            return false;
        }
        if(col < 0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] == '1'){
            return false;
        }

        if(board[row][col] == word.charAt(idx)){
            char temp = board[row][col];
            board[row][col] = '1';
            boolean checkUp = recurse(board, word, row - 1, col, idx + 1);
            boolean checkDown = recurse(board, word, row + 1, col, idx + 1);
            boolean checkLeft = recurse(board, word, row, col - 1, idx + 1);
            boolean checkRight = recurse(board, word, row, col + 1, idx + 1);
            board[row][col] = temp;
            return checkUp || checkDown || checkLeft || checkRight;
        }

        return false;
    }
}