class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int maxVal = recurse(nums.length - 1, nums, dp);
        return maxVal;
    }

    public int recurse(int ind, int[] nums, int[] dp){
        if(ind == 0){
            return nums[0];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = nums[ind] + recurse(ind - 2, nums, dp);
        int nonPick = 0 + recurse(ind - 1, nums, dp);

        return dp[ind] = Math.max(pick, nonPick);
    }
}