class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b)->Integer.compare(a.length(), b.length()));
        int[][] dp = new int[words.length][words.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(words, words.length - 1, -1, dp);
    }

    public int recurse(String[] words, int idx, int prevPick, int[][] dp){
        if(idx < 0){
            return 0;
        }
        if(dp[idx][prevPick + 1] != -1){
            return dp[idx][prevPick + 1];
        }
        int notTake = 0 + recurse(words, idx - 1, prevPick, dp);
        int take = 0;
        if(prevPick == -1 || checkChain(words[idx], words[prevPick])){
            take = 1 + recurse(words, idx - 1, idx, dp);
        }
        return dp[idx][prevPick + 1] = Math.max(take, notTake);
    }

    public boolean checkChain(String word1, String word2){
        if(word1.length() + 1 == word2.length()){
            int i = 0;
            int j = 0;
            int k = 1;
            while(i < word1.length() && j < word2.length()){
                if(word1.charAt(i) == word2.charAt(j)){
                    i++;
                    j++;
                } else {
                    k--;
                    if(k < 0){
                        return false;
                    }
                    j++;
                }
            }
            return true;
        }
        return false;
    }
}