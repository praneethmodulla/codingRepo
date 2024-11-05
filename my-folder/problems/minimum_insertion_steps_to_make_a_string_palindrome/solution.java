class Solution {
    public int minInsertions(String s) {
        StringBuilder reverse = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            reverse.append(s.charAt(i));
        }
        String rev = reverse.toString();
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int lenPalindrome = recurse(s, rev, s.length() - 1, rev.length() - 1, dp);
        return s.length() - lenPalindrome;
    }

    public int recurse(String s, String rev, int ind1, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s.charAt(ind1) == rev.charAt(ind2)){
            return dp[ind1][ind2] = 1 + recurse(s, rev, ind1 - 1, ind2 - 1, dp);
        } else {
            return dp[ind1][ind2] = Math.max(recurse(s, rev, ind1 - 1, ind2, dp), recurse(s, rev, ind1, ind2 - 1, dp));
        }
    }
}