class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int maxLen = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                maxLen = Math.max(maxLen, dfs(matrix, i, j, -1, dp));
            }
        }
        return maxLen;
    }

    public int dfs(int[][] matrix, int row, int col, int prevNum, int[][] dp){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length){
            return 0;
        }
        if(matrix[row][col] > prevNum && dp[row][col] != -1){
            return dp[row][col];
        }
        if(matrix[row][col] > prevNum){
            prevNum = matrix[row][col];
            int up = 1 + dfs(matrix, row - 1, col, prevNum, dp);
            int down = 1 + dfs(matrix, row + 1, col, prevNum, dp);
            int left = 1 + dfs(matrix, row, col - 1, prevNum, dp);
            int right = 1 + dfs(matrix, row, col + 1, prevNum, dp);
            int currMax = Math.max(up, Math.max(down, Math.max(left, right)));
            return dp[row][col] = currMax;
        } else {
            return 0;
        }
    }
}