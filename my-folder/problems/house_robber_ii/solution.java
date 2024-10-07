class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];

        for(int i = 0; i < nums.length; i++){
            if(i != 0){
                nums1[i - 1] = nums[i];
            }
            if(i != nums.length - 1){
                nums2[i] = nums[i];
            }
        }
        return Math.max(houseRob(nums1), houseRob(nums2)); 
    }

    public int houseRob(int[] nums){
        int[] dp = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        int maxVal = Math.max(dp[0], dp[1]);
        for(int i = 2; i < nums.length; i++){
            for(int k = i - 2; k >= 0; k--){
                dp[i] = Math.max(dp[i], nums[i] + dp[k]);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }
}