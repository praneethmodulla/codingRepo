class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++){
            dp[i][i] = true;
        }
        int[] ans = new int[2];
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)){
                dp[i][i + 1] = true;
                ans[0] = i;
                ans[1] = i + 1; 
            }
        }
        for(int diff = 2; diff < s.length(); diff++){
            for(int i = 0; i < s.length() - diff; i++){
                int j = i + diff;
                if(s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true){
                    dp[i][j] = true;
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return s.substring(ans[0], ans[1] + 1);
    }
}