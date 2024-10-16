class Solution {
    public boolean canPartition(int[] nums) {
        if(nums.length == 1){
            return false;
        }
        int totalSum = 0;
        for(int i = 0; i < nums.length; i++){
            totalSum += nums[i];
        }
        if(totalSum % 2 == 1){
            return false;
        }
        int targetSum = (totalSum/2);
        int[][] dp = new int[nums.length][targetSum + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        recurse(nums, dp, nums.length - 1, targetSum);
        if(dp[nums.length - 1][targetSum] == 1){
            return true;
        }
        return false;
    }

    public int recurse(int[] nums, int[][] dp, int idx, int target){
        if(target < 0){
            return 0;
        }
        if(target == 0){
            return 1;
        }
        if(idx == 0){
            if(target == nums[idx]){
                return 1;
            }
            return 0;
        }
        if(dp[idx][target] != -1){
            return dp[idx][target];
        }
        int notTake = recurse(nums, dp, idx - 1, target);
        int take = recurse(nums, dp, idx - 1, target - nums[idx]);
        return dp[idx][target] = take > notTake ? take : notTake;
    }

    
}