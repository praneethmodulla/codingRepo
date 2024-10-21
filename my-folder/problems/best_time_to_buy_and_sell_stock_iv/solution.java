class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k + 1];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        return recurse(prices, 0, 1, k, dp);
    }

    public int recurse(int[] prices, int idx, int buy, int transact, int[][][] dp){
        if(idx == prices.length || transact == 0){
            return 0;
        }
        if(dp[idx][buy][transact] != -1){
            return dp[idx][buy][transact];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[idx] + recurse(prices, idx + 1, 0, transact, dp)), recurse(prices, idx + 1, 1, transact, dp));
        } else {
            profit = Math.max((prices[idx] + recurse(prices, idx + 1, 1, transact - 1, dp)), recurse(prices, idx + 1, 0, transact, dp));
        }
        return dp[idx][buy][transact] = profit;
    }
}