class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;
        dp[0] = nums[0];
        dp[1] = nums[1];
        max = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++){
            int cnt = 2;
            while(i - cnt >= 0){
                dp[i] = Math.max(dp[i], dp[i - cnt] + nums[i]);
                cnt++;
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}