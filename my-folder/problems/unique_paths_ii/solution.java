class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int numWays = 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int[] row : dp){
            Arrays.fill(row, - 1);
        }
        numWays = recurse(obstacleGrid.length - 1, obstacleGrid[0].length - 1, 0, 0, obstacleGrid, dp);
        return numWays;
    }

    public int recurse(int row, int col, int finalRow, int finalCol, int[][] obstacleGrid, int[][] dp){
        if(row < 0 || col < 0){
            return 0;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        if(row == finalRow && col == finalCol){
            return 1;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = recurse(row - 1, col, finalRow, finalCol, obstacleGrid, dp);
        int left = recurse(row, col - 1, finalRow, finalCol, obstacleGrid, dp);

        return dp[row][col] = up + left;
    }
}