class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        recurse(grid.length - 1, grid[0].length - 1, grid, dp);
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int recurse(int row, int col, int[][] grid, int[][] dp){
        if(row < 0 || col < 0){
            return (int) Math.pow(10, 9);
        }
        if(row == 0 && col == 0){
            return dp[row][col] = grid[row][col];
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = grid[row][col] + recurse(row - 1, col, grid, dp);
        int left = grid[row][col] + recurse(row, col - 1, grid, dp);
        return dp[row][col] = Math.min(up, left);
    }
}