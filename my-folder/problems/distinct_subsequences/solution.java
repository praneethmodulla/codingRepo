class Solution {
    public int numDistinct(String s, String t) {
        int ind1 = s.length() - 1;
        int ind2 = t.length() - 1;
        int[][] dp = new int[s.length()][t.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(s, t, ind1, ind2, dp);
    }

    public int recurse(String s, String t, int ind1, int ind2, int[][] dp){
        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == t.charAt(ind2)){
            int take = recurse(s, t, ind1 - 1, ind2 - 1, dp);
            int notTake = recurse(s, t, ind1 - 1, ind2, dp);
            return dp[ind1][ind2] = take + notTake;
        }
        return dp[ind1][ind2] = recurse(s, t, ind1 - 1, ind2, dp);
    }
}