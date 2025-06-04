class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        return recurse(nums, nums.length - 1, nums.length, dp);
    }
    public int recurse(int[] nums, int idx, int prev, int[] dp){
        if(idx == 0){
            return nums[0];
        }
        if(idx < 0){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int take = nums[idx] + recurse(nums, idx - 2, idx, dp);
        int notTake = recurse(nums, idx - 1, prev, dp);
        return dp[idx] = Math.max(take, notTake);
    }
}