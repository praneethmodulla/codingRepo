class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; 
        int[] sqnums = new int[(int)Math.sqrt(n) + 1];
        for(int i = 1; i < sqnums.length; i++){
            sqnums[i] = i * i;
        }
        for(int i = 1; i <=n; i++){
            for(int j = 1; j < sqnums.length; j++){
                if(i < sqnums[j]){
                    break;
                }
                dp[i] = Math.min(dp[i - sqnums[j]] + 1, dp[i]);
            }
        }
        return dp[n];
    }
}