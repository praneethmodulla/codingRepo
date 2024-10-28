class Solution {
    public int numEnclaves(int[][] grid) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        int cnt = 0;
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if((i == 0 || i == numRows - 1 || j == 0 || j == numCols - 1) && grid[i][j] == 1){
                    recurse(grid, i, j);
                }
            }
        }
        for(int i = 0; i < numRows; i++){
            for(int j = 0; j < numCols; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void recurse(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length){
            return;
        }
        if(col < 0 || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == 0){
            return;
        }
        grid[row][col] = 0;
        recurse(grid, row - 1, col);
        recurse(grid, row + 1, col);
        recurse(grid, row, col - 1);
        recurse(grid, row, col + 1);
        return;
    }
}