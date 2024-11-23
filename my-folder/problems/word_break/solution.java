class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return recurse(s, wordDict, s.length() - 1, dp);
    }

    public boolean recurse(String s, List<String> wordDict, int idx, int[] dp){
        if(idx < 0){
            return true;
        }
        if(dp[idx] != -1){
            return dp[idx] == 1; 
        }
        for(String word : wordDict){
            if(idx - word.length() + 1 < 0){
                continue;
            }
            if(s.substring(idx - word.length() + 1, idx + 1).equals(word) && recurse(s, wordDict, idx - word.length(), dp)){
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx] = 0;
        return false;
    }
}