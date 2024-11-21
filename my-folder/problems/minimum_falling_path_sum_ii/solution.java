class Solution {
    public int minFallingPathSum(int[][] grid) {
        if(grid.length == 1){
            return grid[0][0];
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < grid[0].length; i++){
            minVal = Math.min(minVal, recurse(grid, dp, grid.length - 1, i));
        }
        return minVal;
    }

    public int recurse(int[][] grid, int[][] dp, int row, int col){
        if(row < 0){
            return 0;
        }
        if(dp[row][col] != Integer.MIN_VALUE){
            return dp[row][col];
        }
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < grid[row].length; i++){
            if(i == col){
                continue;
            }
            minVal = Math.min(minVal, recurse(grid, dp, row - 1, i));
        }
        return dp[row][col] = grid[row][col] + minVal;
    }
}