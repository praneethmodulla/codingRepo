class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums.length == 0){
            return 0;
        }
        int maxVal = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        maxVal = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++){
            for(int k = i - 2; k >= 0; k--){
                dp[i] = Math.max(dp[i], nums[i] + dp[k]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal; 
    }
}