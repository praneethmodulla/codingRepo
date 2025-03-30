class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int[] maxArea = new int[1];
        int max = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    recurse(i, j, grid, maxArea);
                    if(max < maxArea[0]){
                        max = maxArea[0];
                    }
                    maxArea[0] = 0; 
                }
            }
        }
        return max;
    }

    public void recurse(int row, int col, int[][] grid, int[] maxArea){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return;
        }
        if(grid[row][col] == 0){
            return;
        }
        if(grid[row][col] == 1){
            maxArea[0]++;
        }
        grid[row][col] = 0;
        recurse(row + 1, col, grid, maxArea);
        recurse(row - 1, col, grid, maxArea);
        recurse(row, col + 1, grid, maxArea);
        recurse(row, col - 1, grid, maxArea);
        //grid[row][col] = 1;
        return;
    }
}