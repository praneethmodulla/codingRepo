class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> Integer.compare(a[0], b[0]));
        long[] dp = new long[rides.length];
        Arrays.fill(dp, -1);
        return recurse(rides, 0, dp);
    }

    public long recurse(int[][] rides, int idx, long[] dp){
        if(idx == rides.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int i = 0;
        for(i = idx + 1; i < rides.length; i++){
            if(rides[i][0] >= rides[idx][1]){
                break;
            }
        }
        long earn = rides[idx][1] - rides[idx][0] + rides[idx][2];
        long take = earn + recurse(rides, i, dp);
        long notTake = recurse(rides, idx + 1, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}