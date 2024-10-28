class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return recurse(nums, 0, -1, dp);
    }

    public int recurse(int[] nums, int idx, int prev, int[][] dp){
        if(idx == nums.length){
            return 0;
        } 
        if(dp[idx][prev + 1] != -1){
            return dp[idx][prev + 1];
        }
        int notTake = 0 + recurse(nums, idx + 1, prev, dp);
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]){
            take = 1 + recurse(nums, idx + 1, idx, dp);
        }
        return dp[idx][prev + 1] = Math.max(take, notTake);
    }
}