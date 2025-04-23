class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(n == 1){
            List<String> res = new ArrayList<String>();
            res.add("Q");
            result.add(res);
            return result;
        }
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        constructBoard(board, result);
        return result;
    }

    public void build(char[][] board, List<List<String>> res){
        List<String> row = new ArrayList<String>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++){
                sb.append(board[i][j]);
            }
            row.add(sb.toString());
        }
        res.add(row);
    }

    public void constructBoard(char[][] board, List<List<String>> res){
        for(int i = 0; i < board.length; i++){
            board[board.length - 1][i] = 'Q';
            recurse(board, board.length - 2, res);
            board[board.length - 1][i] = '.';
        }
        return;
    }

    public boolean recurse(char[][] board, int row, List<List<String>> res){
        if(row < 0){
            return true;
        }
        for(int i = 0; i < board[row].length; i++){
            if(check(board, row, i)){
                board[row][i] = 'Q';
                if(recurse(board, row - 1, res)){
                    build(board, res);
                }
                board[row][i] = '.';
            }
        }
        return false;
    }

    public boolean check(char[][] board, int row, int col){
        // check Row
        for(int i = 0; i < board.length; i++){
            if(board[row][i] == 'Q'){
                return false;
            }
        }
        // check Column
        for(int i = row; i < board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        } 

        // check diagonal 1
        int i = row + 1;
        int j = col + 1;
        while(i < board.length && j < board.length){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++;
            j++;
        }
        i = row + 1;
        j = col - 1;
        while(i < board.length && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }
        return true;
    } 
}