class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d){
            return -1;
        }
        int n = jobDifficulty.length;
        int[][] dp = new int[n][d];
        for(int[] row : dp){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return recurse(jobDifficulty, d - 1, 0, dp);
    }

    public int recurse(int[] difficulty, int splits, int idx, int[][] dp){
        if(splits == 0){
            int max = 0;
            for(int i = idx; i < difficulty.length; i++){
                max = Math.max(max, difficulty[i]);
            }
            return dp[idx][splits] = Math.min(dp[idx][splits], max);
        }

        if(dp[idx][splits] != Integer.MAX_VALUE){
            return dp[idx][splits];
        }
        int max = 0;
        for(int i = idx; i <= difficulty.length - splits - 1; i++){
            max = Math.max(max, difficulty[i]);
            dp[idx][splits] = Math.min(dp[idx][splits], max + recurse(difficulty, splits - 1, i + 1, dp));
        }
        return dp[idx][splits];
    }
}