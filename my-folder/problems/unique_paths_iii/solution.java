class Solution {
    public int uniquePathsIII(int[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int total = grid.length * grid[0].length;
        int startRow = -1;
        int startCol = -1;
        int finalRow = -1;
        int finalCol = -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    startRow = i;
                    startCol = j;
                }
                if(grid[i][j] == -1){
                    total--;
                }
                if(grid[i][j] == 2){
                    finalRow = i;
                    finalCol = j;
                }
            }
        }
        return recurse(grid, vis, startRow, startCol, finalRow, finalCol, total);
    }

    public int recurse(int[][] grid, int[][] vis, int row, int col, int finalRow, int finalCol, int total){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return 0;
        }
        if(vis[row][col] == 1){
            return 0;
        }
        if(grid[row][col] == -1){
            return 0;
        }
        if(row == finalRow && col == finalCol && total == 1){
            return 1;
        }
        vis[row][col] = 1;
        int up = recurse(grid, vis, row - 1, col, finalRow, finalCol, total - 1);
        int down = recurse(grid, vis, row + 1, col, finalRow, finalCol, total - 1);
        int left = recurse(grid, vis, row, col - 1, finalRow, finalCol, total - 1);
        int right = recurse(grid, vis, row, col + 1, finalRow, finalCol, total - 1);
        vis[row][col] = 0;
        return up + left + down + right;
    }
}