class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        int minVal = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int diag1 = matrix[n - 1][i] + recurse(matrix, dp, n - 2, i - 1);
            int diag2 = matrix[n - 1][i] + recurse(matrix, dp, n - 2, i);
            int diag3 = matrix[n - 1][i] + recurse(matrix, dp, n - 2, i + 1);
            if(n - 2 >= 0){
                dp[n - 1][i] = Math.min(diag1, Math.min(diag2, diag3));
            } else {
                dp[n - 1][i] = matrix[n - 1][i];
            }
            minVal = Math.min(minVal, dp[n - 1][i]);
        }
        return minVal;
    }

    public int recurse(int[][] matrix, int[][] dp, int rowIdx, int colIdx){
        if(rowIdx < 0 || colIdx < 0){
            return (int)Math.pow(10, 9);
        }
        if(rowIdx >= matrix.length || colIdx >= matrix.length){
            return (int)Math.pow(10, 9);
        }
        if(rowIdx == 0 && (colIdx >= 0 && colIdx < matrix.length)){
            return matrix[rowIdx][colIdx];
        }
        if(dp[rowIdx][colIdx] != Integer.MAX_VALUE){
            return dp[rowIdx][colIdx];
        }
        int diag1 = matrix[rowIdx][colIdx] + recurse(matrix, dp, rowIdx - 1, colIdx - 1);
        int diag2 = matrix[rowIdx][colIdx] + recurse(matrix, dp, rowIdx - 1, colIdx);
        int diag3 = matrix[rowIdx][colIdx] + recurse(matrix, dp, rowIdx - 1, colIdx + 1);
        return dp[rowIdx][colIdx] = Math.min(diag1, Math.min(diag2, diag3));
    }
}