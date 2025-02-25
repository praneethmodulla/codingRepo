class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] vis = new int[grid.length][grid[0].length];  
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && vis[i][j] != 1){
                    recurse(grid, i, j, vis);
                    count++;
                }
            }
        }
        return count;
    }

    public void recurse(char[][] grid, int row, int col, int[][] vis){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == '0'){
            return;
        }
        if(vis[row][col] == 1){
            return;
        }
        if(grid[row][col] == '1' && vis[row][col] != 1){
            vis[row][col] = 1;
        }
        recurse(grid, row + 1, col, vis);
        recurse(grid, row - 1, col, vis);
        recurse(grid, row, col + 1, vis);
        recurse(grid, row, col - 1, vis);
        return;
    }
}