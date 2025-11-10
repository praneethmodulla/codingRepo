class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int[][][] dp = new int[grid.length][grid[0].length][k + 1];
        for(int[][] mat : dp){
            for(int[] res : mat){
                Arrays.fill(res, -2);
            }
        }
        return recurse(grid, grid.length - 1, grid[0].length - 1, k, dp);
    }

    public int recurse(int[][] grid, int row, int col, int cost, int[][][] dp){
        if(cost < 0){
            return -1;
        }
        if(row == 0 && col == 0){
            return dp[row][col][cost] = grid[row][col];
        }
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length){
            return -1;
        }
        if(dp[row][col][cost] != -2){
            return dp[row][col][cost];
        }
        int newCost = cost;
        if(grid[row][col] == 2 || grid[row][col] == 1){
            newCost = cost - 1;
        } 
        int up = recurse(grid, row - 1, col, newCost, dp);
        int left = recurse(grid, row, col - 1, newCost, dp);
        if(up == -1 && left == -1){
            return dp[row][col][cost] = -1;
        }
        return dp[row][col][cost] = grid[row][col] + Math.max(up, left);
    }
}