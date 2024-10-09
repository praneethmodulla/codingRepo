class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(m - 1, n - 1, 0, 0, dp);
    }

    public int recurse(int row, int col, int finalRow, int finalCol, int[][] dp){
        if(row == finalRow && col == finalCol){
            return 1;
        }
        if(row < finalRow){
            return 0;
        }
        if(col < finalCol){
            return 0;
        }
        if(dp[row][col] != -1){
            return dp[row][col];
        }
        int up = recurse(row - 1, col, finalRow, finalCol, dp);
        int left = recurse(row, col - 1, finalRow, finalCol, dp);
        return dp[row][col] = up + left;
    }
}