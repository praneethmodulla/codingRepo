class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int[] numLIS = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(numLIS, 1);
        int maxLen = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        numLIS[i] = numLIS[j];
                    } else if(dp[i] == dp[j] + 1){
                        numLIS[i] += numLIS[j];
                    }
                }
            }
            if(maxLen < dp[i]){
                maxLen = dp[i];
            }
        }

        int ans = 0;
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == maxLen){
                ans += numLIS[i];
            }
        }
        return ans;
    }
}