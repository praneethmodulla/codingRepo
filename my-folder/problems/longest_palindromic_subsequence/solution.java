class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(s, s.length() - 1, sb.toString(), s.length() - 1, dp);
    }

    public int recurse(String s, int ind1, String rs, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == rs.charAt(ind2)){
            return dp[ind1][ind2] = 1 + recurse(s, ind1 - 1, rs, ind2 - 1, dp);
        } else {
            return dp[ind1][ind2] = Math.max(recurse(s, ind1 - 1, rs, ind2, dp), recurse(s, ind1, rs, ind2 - 1, dp));
        }
    }
}