class Solution {
    public int countBattleships(char[][] board) {
        int[][] vis = new int[board.length][board[0].length];
        int cnt = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X' && vis[i][j] != 1){
                    cnt++;
                    recurse(board, i, j, vis);
                }
            }
        } 
        return cnt;
    }

    public void recurse(char[][] board, int row, int col, int[][] vis){
        if(row < 0 || col < 0 || col >= board[0].length || row >= board.length || board[row][col] != 'X' || vis[row][col] == 1){
            return;
        }
        vis[row][col] = 1;
        recurse(board, row + 1, col, vis);
        recurse(board, row - 1, col, vis);
        recurse(board, row, col + 1, vis);
        recurse(board, row, col - 1, vis);
    }
}