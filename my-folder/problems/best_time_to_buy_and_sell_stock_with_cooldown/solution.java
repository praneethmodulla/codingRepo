class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(prices, 0, 1, dp);
    }

    public int recurse(int[] prices, int idx, int buy, int[][] dp){
        if(idx >= prices.length){
            return 0;
        }
        if(dp[idx][buy] != -1){
            return dp[idx][buy];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max((-prices[idx] + recurse(prices, idx + 1, 0, dp)), recurse(prices, idx + 1, 1, dp));
        } else {
            profit = Math.max((prices[idx] + recurse(prices, idx + 2, 1, dp)), recurse(prices, idx + 1, 0, dp));
        }
        return dp[idx][buy] = profit;
    }
}