class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        if(s.charAt(0) == '0'){
            return 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 1; i < s.length(); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i - 1) + "" + s.charAt(i));
            int num = Integer.valueOf(sb.toString());
            if(s.charAt(i) == '0'){
                if(num >= 10 && num <= 26){
                    dp[i + 1] = dp[i - 1];
                } else {
                    return 0;
                }
            } else {
                if(num >= 10 && num <= 26){
                    dp[i + 1] = dp[i] + dp[i - 1];
                } else {
                    dp[i + 1] = dp[i];
                }
            }
        }
        return dp[s.length()];
    }
}