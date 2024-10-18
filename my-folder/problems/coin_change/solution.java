class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        recurse(coins, coins.length - 1, amount, dp);
        if(dp[coins.length - 1][amount] >= (int)Math.pow(10, 9)){
            return -1;
        }
        return dp[coins.length - 1][amount];
    }

    public int recurse(int[] coins, int idx, int amount, int[][] dp){
        if(amount == 0){
            return dp[idx][amount] = 0;
        }
        if(idx == 0){
            if(amount % coins[idx] == 0){
                return dp[idx][amount] = amount/coins[idx];
            }
            return dp[idx][amount] = (int)Math.pow(10, 9);
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int notTaken = 0 + recurse(coins, idx - 1, amount, dp);
        int taken = (int)Math.pow(10, 9);
        if(amount >= coins[idx]){
            taken = 1 + recurse(coins, idx, amount - coins[idx], dp);
        }
        return dp[idx][amount] = Math.min(notTaken, taken);
    }
}