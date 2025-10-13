class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int[][] dp = new int[(1<<tasks.length)][sessionTime + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        recurse(tasks, dp, 0, 0, sessionTime);
        return dp[0][0];
    }

    public int recurse(int[] tasks, int[][] dp, int mask, int remainTime, int sessionTime){
        if(mask == (1<<tasks.length) - 1){
            return 0;
        }
        if(dp[mask][remainTime] != -1){
            return dp[mask][remainTime];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < tasks.length; i++){
            if((mask & (1 << i)) == 0){
                if(tasks[i] <= remainTime){
                    ans = Math.min(ans, recurse(tasks, dp, mask | (1 << i), remainTime - tasks[i], sessionTime));
                } else {
                    ans = Math.min(ans, 1 + recurse(tasks, dp, mask | (1 << i), sessionTime - tasks[i], sessionTime));
                }
            }
        }
        return dp[mask][remainTime] = ans;
    }
}