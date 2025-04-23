class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(recurse(board, i, j, word, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean recurse(char[][] board, int row, int col, String word, int idx){
        if(idx == word.length()){
            return true;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] == word.charAt(idx)){
            char temp = board[row][col];
            board[row][col] = '0';
            boolean up = recurse(board, row - 1, col, word, idx + 1);
            boolean down = recurse(board, row + 1, col, word, idx + 1);
            boolean right = recurse(board, row, col + 1, word, idx + 1);
            boolean left = recurse(board, row, col - 1, word, idx + 1);
            board[row][col] = temp;
            return up || down || left || right; 
        }
        return false;
    }
}