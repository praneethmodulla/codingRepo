class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int count = 0;
        int mod = (int)1e9 + 7;
        Arrays.fill(dp, -1);
        int i = 0;
        while(i < dp.length){
            if(i == 0 || dp[i] != -1){
                if(i == 0){
                    if(i + zero < dp.length){
                        dp[i + zero] = 1;
                    }
                    if(i + one < dp.length){
                        if(dp[i + one] != -1){
                            dp[i + one] += 1;
                        } else {
                            dp[i + one] = 1;
                        }
                    }
                } else {
                    if(i + zero < dp.length){
                        if(dp[i + zero] != -1){
                            dp[i + zero] = (dp[i + zero] + dp[i])%mod;
                        } else {
                            dp[i + zero] = dp[i];
                        }
                    }
                    if(i + one < dp.length){
                        if(dp[i + one] != -1){
                            dp[i + one] = (dp[i + one] + dp[i])%mod;
                        } else {
                            dp[i + one] = dp[i];
                        }
                    }
                }
            }
            i++;
        }
        for(int j = low; j <= high; j++){
            if(dp[j] != -1){
                count = (count + dp[j])%mod;
            }
        }
        return count;
    }
}