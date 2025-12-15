class Solution {
    public int maximumProfit(int[] present, int[] future, int budget) {
        int[][] dp = new int[present.length][budget + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(present, future, 0, budget, dp);
    }

    public int recurse(int[] present, int[] future, int idx, int budget, int[][] dp){
        if(idx == present.length){
            return 0;
        }
        if(dp[idx][budget] != -1){
            return dp[idx][budget];
        }
        int notTake = 0 + recurse(present, future, idx + 1, budget, dp);
        int take = 0;
        if(budget - present[idx] >= 0){
            take = future[idx] - present[idx] + recurse(present, future, idx + 1, budget - present[idx], dp);
        }
        return dp[idx][budget] = Math.max(take, notTake);
    }
}