class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        recurse(nums, 0, dp);
        if(dp[0] == 1){
            return true;
        }
        return false;
    }

    public int recurse(int[] nums, int idx, int[] dp){
        if(idx == nums.length - 1){
            return 1;
        }

        if(dp[idx] != -1){
            return dp[idx];
        }
        for(int i = 1; i <= nums[idx]; i++){
            int num = 0;
            num = recurse(nums, idx + i, dp);
            if(num == 1){
                return dp[idx] = num;
            }
        }
        
        return dp[idx] = 0;
    }
}