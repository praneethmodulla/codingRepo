class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        int len = recurse(word1, word2, word1.length() - 1, word2.length() - 1, dp);
        return (word1.length() - len) + (word2.length() - len);
    }

    public int recurse(String s, String t, int ind1, int ind2, int[][] dp){
        if(ind1 < 0 || ind2 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }

        if(s.charAt(ind1) == t.charAt(ind2)){
            return dp[ind1][ind2] = 1 + recurse(s, t, ind1 - 1, ind2 - 1, dp);
        } else {
            return dp[ind1][ind2] = Math.max(recurse(s, t, ind1 - 1, ind2, dp), recurse(s, t, ind1, ind2 - 1, dp));
        }
    }
}