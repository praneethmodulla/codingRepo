class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        recurse(amount, coins, coins.length - 1, dp);
        if(dp[coins.length - 1][amount] != -1){
            return dp[coins.length - 1][amount];
        }
        return 0;
    }

    public int recurse(int amount, int[] coins, int idx, int[][] dp){
        if(amount == 0){
            return dp[idx][amount] = 1;
        }
        if(idx == 0){
            if(amount%coins[idx] == 0){
                return dp[idx][amount] = 1;
            }
            return dp[idx][amount] = 0;
        }
        if(dp[idx][amount] != -1){
            return dp[idx][amount];
        }
        int notTaken = recurse(amount, coins, idx - 1, dp);
        int taken = 0;
        if(amount >= coins[idx]){
            taken = recurse(amount - coins[idx], coins, idx, dp);
        }
        return dp[idx][amount] = taken + notTaken;
    }
}